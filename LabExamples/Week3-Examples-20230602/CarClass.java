
public enum CarClass {
	SEDAN("Sedan"),
	HATCHBACK("Hatchback"),
	SUV("SUV"),
	TRUCK("Truck"),
	VAN("VAN"),
	SPORTS("Sports"),
	MUSCLE("Muscle"),
	CROSSOVER("Crossover"),
	CONVERTIBLE("Convertible"),
	COUPE("Coupe"),
	PICKUP("Pickup");
	
	private String description;

    private CarClass(String option)
    {
        this.description = option;
    }

    public String getMeaning()
    {
        return description;
    }
    
    public void setMeaning(String description)
    {
        this.description = description;
    }
}
