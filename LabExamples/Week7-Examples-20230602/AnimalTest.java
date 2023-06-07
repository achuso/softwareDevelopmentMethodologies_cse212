
public class AnimalTest {
	
	public static void main(String[] args) {
		
		Animal cat = new Cat();
		Animal dog = new Dog();
		
		//Animal an = new Animal(); //cannot instantiate an interface
		
		cat.speak();
		dog.speak();
		
	}

}
