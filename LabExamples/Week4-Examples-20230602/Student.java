
class Person {
	
	protected String name = "John";
	protected String surname = "Doe";
	protected String email = "john@gmail.com";
	protected int age = 24;
}


class Student extends Person {
	
	private int graduationYear = 2018;
	
	public static void main(String[] args) {
		
		Student student = new Student();
		System.out.println("Name: " + student.name + " " + student.surname);
		System.out.println("Email: " + student.email);
		System.out.println("Age: " + student.age);
		System.out.println("Graduation Year: " + student.graduationYear);
  }
}

