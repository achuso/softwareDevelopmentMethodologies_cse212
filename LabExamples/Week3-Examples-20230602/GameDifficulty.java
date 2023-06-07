
public enum GameDifficulty {
	VERY_LIGHT("Explore and experience the story with a lighter combat challenge"),
	LIGHT("Resources are more common and enemies are less dangerous"),
	MODERATE("Provides a balanced experience. Resources are limited"),
	HARD("For those looking for a greater challenge. Resources are very limited and enemies are more dangerous"),
	SURVIVOR("An intense, demanding challenge. Resources are extremely scarce and enemies are deadly"),
	GROUNDED("The most realistic experience. Permadeath mode is enabled, there are no second chances; you must complete the entire game without dying");
	
	
    private String option;

    GameDifficulty(String option)
    {
        this.option = option;
    }

    public String getMeaning()
    {
        return option;
    }
}
