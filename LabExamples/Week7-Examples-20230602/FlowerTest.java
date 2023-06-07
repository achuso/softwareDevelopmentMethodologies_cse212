import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlowerTest {

    public static void main(String[] args) {
        List<Flower> flowers = new ArrayList<>();
        flowers.add(new Flower("Rose", "Red", 5));
        flowers.add(new Flower("Lily", "White", 7));
        flowers.add(new Flower("Sunflower", "Yellow", 12));

        Collections.sort(flowers);

        for (Flower flower : flowers) {
            System.out.println(flower.getName() + " has " + flower.getPetalCount() + " petals");
        }

    }
}
