
class Animal {
	
	protected int age; // the protected access modifier is accessible within package and outside the package but through inheritance only
	
	public Animal() {
		
		this.age = 0;
		
	}
	
	void eat() {
		
		System.out.println("Eating...");
	}
	
}

class Dog extends Animal {
	
	public Dog() { // Default constructor
		
		super.age = 7;
		
	}
	
	public Dog(int age) {
		
		super.age = age; // can use instead of this.age = age
		
	}
	
	void bark() {
		
		System.out.println("Barking...");
		
	}
	
}

class Puppy extends Dog {
	
	public Puppy(int age) {
		
		super(age); // call superclass's(Dog) constructor using super()
		
	}
	
	void bark() {
		
		System.out.println("Barking pretty cute...");
		
	}
	
}


public class MultiLevelInheritance {
	
	public static int accessAge() {
		
		Dog dog = new Dog();
		return dog.age; // protected instance variable can be accessed by any class in the same package and by subclasses even if they are in another packages
		
	}
	
	public static void main(String[] args) {
		
		Animal animal = new Animal();
		
		Dog dog = new Dog(5);
		
		Puppy puppy = new Puppy(1);
		
		animal.eat();
		dog.eat();
		puppy.eat();
		
		dog.bark();
		puppy.bark();
		
		System.out.println("Age: " + animal.age);
		System.out.println("Age: " + dog.age);
		System.out.println("Age: " + puppy.age);
		
		System.out.println(MultiLevelInheritance.accessAge());
		
	}
	
}

 