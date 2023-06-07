package myDowncasting;

class Cat extends Animal {

	public void goHunting() {
	
		System.out.println("Do Cat related Hunting");
	
	}

	/*
	Overridden eat() method
	*/

	public void eat() {
	
		System.out.println("Cat specific Eating");
	
	}

}