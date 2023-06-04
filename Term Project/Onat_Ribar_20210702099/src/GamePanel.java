import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

enum DifficultyEnum {
    NOVICE(1, 5, 10),
    INTERMEDIATE(2, 8, 25),
    ADVANCED(3, 12, 40);



    private int key;
    private int enemyCount;
    private int enemySpeed;

    DifficultyEnum(int key, int enemyCount, int enemySpeed) {
        this.key = key;
        this.enemyCount = enemyCount;
        this.enemySpeed = enemySpeed;
    }
    public int getKey() { return key; }
    public int getEnemyCount() { return enemyCount; }
    public int getEnemySpeed() {return enemySpeed; }
};

public class GamePanel extends JPanel {
    private DifficultyEnum currentDifficulty;
    private Random random = new Random();
    Clip sfxClip; // background sfx
    private BufferedImage bg_game, destroyedImage;
    private Spaceship player;
    private boolean notLost = true;
    private ArrayList<Alien> AlienArray;
    private Vector<Bullet> BulletArray = new Vector<Bullet>();
    private int bulletCooldown = 0;
    private int score = 0;

    GamePanel(int difficultyInput) throws IOException {

        // Set difficulty and alien array
        this.setPreferredSize(new Dimension(800, 800));
        for(DifficultyEnum value: DifficultyEnum.values()) {
            if(value.getKey() == difficultyInput)
                currentDifficulty = value;
        }

        // Royalty free source https://www.vecteezy.com/vector-art/8202202-explosion-with-pixel-art-vector-illustration
        destroyedImage = ImageIO.read(new File("icons/Models/explosion.png"));

        AlienArray = new ArrayList<Alien>(currentDifficulty.getEnemyCount());

        for(int i = 0; i < currentDifficulty.getEnemyCount(); i++) {
            Alien tempAlien = new Alien(currentDifficulty.getEnemySpeed(), 40 + random.nextInt() % 10);
            AlienArray.add(tempAlien);
            tempAlien.setPosX(Math.abs(random.nextInt() % 700));
        }

        player = new Spaceship();

        addBackground();
        setupKeyBindings(); // for the key bindings (keylistener doesnt work bcs of actionlistener focus on frame)

        // Keep on painting - Bob Ross
        Timer timer = new Timer(1, e -> {
            if(notLost)
                repaint();
        });
        timer.start();
    }

    private void setupKeyBindings() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        bindKey(inputMap, actionMap, "moveUp", KeyEvent.VK_UP);
        bindKey(inputMap, actionMap, "moveDown", KeyEvent.VK_DOWN);
        bindKey(inputMap, actionMap, "moveLeft", KeyEvent.VK_LEFT);
        bindKey(inputMap, actionMap, "moveRight", KeyEvent.VK_RIGHT);
        bindKey(inputMap, actionMap, "shoot", KeyEvent.VK_SPACE);
    }

    private void bindKey(InputMap inputMap, ActionMap actionMap, String actionKey, int keyCode) {
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle key action here
                int displacement = 20;
                int desiredResolutionX = 720;
                switch (actionKey) {
                    case "moveUp" -> {
                        if (player.getPosY() >= 10)
                            player.verticalDisplacement(-displacement);
                    }
                    case "moveDown" ->
                        // had trouble troubleshooting this, so no restrictions..
                            player.verticalDisplacement(displacement);
                    case "moveRight" -> {
                        if (player.getPosX() + (player.getWidth() / 2) <= 720)
                            player.horizontalDisplacement(displacement);
                    }
                    case "moveLeft" -> {
                        if (player.getPosX() - (player.getWidth() / 2) >= -20)
                            player.horizontalDisplacement(-displacement);
                    }
                    case "shoot" -> {
                        if (player.getBulletCooldown() == 0) {
                            Bullet tempBullet = new Bullet(20, 6, (player.getPosX() + player.getWidth() / 2), player.getPosY(), 10);
                            BulletArray.add(tempBullet);
                           try {
                              tempBullet.playSfxClip();
                           } catch (UnsupportedAudioFileException e2) {
                                throw new RuntimeException(e2);
                           } catch (IOException e3) {
                                throw new RuntimeException(e3);
                           } catch (LineUnavailableException e4) {
                                throw new RuntimeException(e4);
                           }
                           player.resetBulletCooldown();
                        }
                    }
                }
            }
        };

        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0), actionKey);
        actionMap.put(actionKey, action);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (player.isDestroyed()){
            return;
        }

        if (player.getBulletCooldown() > 0)
            player.decrementBulletCooldown();

        if (bg_game != null)
            g.drawImage(bg_game, 0, 0, this);

        g.drawImage(player.getPrimaryImage(), player.getPosX(), player.getPosY(), this);

        for(Alien alien: AlienArray){
            for (int i = BulletArray.size() - 1; i >= 0; i--) {
                Bullet bullet = BulletArray.get(i);
                if (Math.abs(alien.getPosX() - bullet.getPosX()) < alien.getWidth()
                        && Math.abs(alien.getPosY() - bullet.getPosY()) < alien.getHeight()) {
                    score += 20;
                    alien.setDestroyed(true);
                    BulletArray.remove(i);
                }
            }
        }
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.setColor(new Color(255, 255, 255));
        g.drawString(String.format("Score: %d", score), 350, 50);

        for (int i = AlienArray.size() - 1; i >= 0; i--) {
            Alien alien = AlienArray.get(i);
            alien.decrementMoveInTurns();
            if (alien.getMoveInTurns() == 0){
                alien.moveAlien(currentDifficulty.getEnemySpeed());
                alien.setMoveInTurns(10 + random.nextInt() % 5);
            }
            if (alien.getPosX() < player.getPosX() + player.getWidth()
                    && alien.getPosX() + alien.getWidth() > player.getPosX()
                    && alien.getPosY() + alien.getHeight() > player.getPosY()
            ) {
                player.setDestroyed(true);
                this.stopBGSfx();
                this.setVisible(false);
                LoserScreen loserscreen;
                try {
                    loserscreen = new LoserScreen();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                loserscreen.setBackground(new Color(255, 255, 255));
                loserscreen.setVisible(true);
            }

            if (!alien.isDestroyed())
                g.drawImage(alien.getPrimaryImage(), alien.getPosX(), alien.getPosY(), this);
            else {
                g.drawImage(destroyedImage, alien.getPosX(), alien.getPosY(), this);
                alien.setDestroyedTurns(alien.getDestroyedTurns() - 1);

                try {
                    File explosionSfxFile = new File("sfx/explosionsfxLESSLOUD.wav");
                    AudioInputStream explosionSfxStream = AudioSystem.getAudioInputStream(explosionSfxFile); // royalty free source -> https://pixabay.com/sound-effects/8-bit-explosion1wav-14656/
                    Clip explosionSfxClip = AudioSystem.getClip();
                    explosionSfxClip.open(explosionSfxStream);
                    explosionSfxClip.start();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    throw new RuntimeException(e);
                }

            }
            if (alien.getDestroyedTurns() < 0 || alien.getPosY() > 800)
                AlienArray.remove(i);
        }

        for (int i = BulletArray.size() - 1; i >= 1; i--) {
            Bullet bullet = BulletArray.get(i);
            g.fillRect(bullet.getPosX(), bullet.getPosY(), bullet.getWidth(), bullet.getHeight());
            bullet.setPosY(bullet.getPosY() - bullet.getVelocity());
            if (bullet.getPosY() + bullet.getHeight() < 0)
                BulletArray.remove(i);
        }
    }

    public void playSfxClip() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File sfxFile = new File("sfx/ingamemusic.wav");
        AudioInputStream sfxAudio = AudioSystem.getAudioInputStream(sfxFile);
        sfxClip = AudioSystem.getClip();
        sfxClip.open(sfxAudio);
        sfxClip.start();
        sfxClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopBGSfx() {
        if(sfxClip.isRunning())
            sfxClip.stop();
    }

    public void addBackground() {
        try {
            bg_game = ImageIO.read(new File("icons/Scenes/bg_game.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


