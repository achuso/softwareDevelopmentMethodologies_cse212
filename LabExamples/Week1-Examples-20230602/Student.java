import java.util.Scanner;


public class Student {
	String name;
	String id;
	String department;
	public Student()
	{
		Scanner myScanner=new Scanner(System.in);
		System.out.printf("%s\n","Enter name");
		name=myScanner.nextLine();
		System.out.printf("%s\n","Enter id");
		id=myScanner.nextLine();
		System.out.printf("%s","Enter department\n");
		department=myScanner.nextLine();
	}
	public void displayStudentInformation()
	{
		System.out.printf("%s","\n");
		System.out.printf("name:%s\n",name);
		System.out.printf("id:%s\n",id);
		System.out.printf("department:%s\n\n",department);
	}
}
