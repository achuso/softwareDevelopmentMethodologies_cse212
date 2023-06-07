
public class GameDifficultyTest {

	public static void main(String[] args) {
		
		GameDifficulty firstGameSlotDiff = GameDifficulty.VERY_LIGHT;
		//System.out.println(GameDifficulty.VERY_LIGHT  + " " + firstGameSlotDiff.getMeaning());
		
		GameDifficulty secondGameSlotDiff = GameDifficulty.MODERATE;
		//System.out.println(secondGameSlotDiff.getMeaning());
		
		GameDifficulty thirdGameSlotDiff = GameDifficulty.GROUNDED;
		//System.out.println(thirdGameSlotDiff.getMeaning());
		
		
		/*
		GameDifficulty gd = GameDifficulty.VERY_LIGHT;
		//GameDifficulty gd = GameDifficulty.MODERATE;
		//GameDifficulty gd = GameDifficulty.GROUNDED;
		
		switch(gd) {
			case VERY_LIGHT:
				System.out.println(gd + ": " + gd.getMeaning());
				break;
				
			case LIGHT:
				System.out.println(gd + ": " + gd.getMeaning());
				break;
				
			case MODERATE:
				System.out.println(gd + ": " + gd.getMeaning());
				break;
				
			case HARD:
				System.out.println(gd + ": " + gd.getMeaning());
				break;
				
			case SURVIVOR:
				System.out.println(gd + ": " + gd.getMeaning());
				break;
				
			case GROUNDED:
				System.out.println(gd + ": " + gd.getMeaning());
				break;
				
			
		}
		*/
		
		// Printing all enum fields
		
		for(GameDifficulty diff: GameDifficulty.values()) {
			System.out.println(diff);
		}
		
	}

}
