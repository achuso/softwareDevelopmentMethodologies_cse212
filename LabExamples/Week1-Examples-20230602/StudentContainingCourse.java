import java.util.Scanner;


public class StudentContainingCourse {
	String name;
	String id;
	String department;
	Course myCourse;
	public StudentContainingCourse()
	{
		Scanner myScanner=new Scanner(System.in);
		System.out.printf("%s\n","Enter name");
		name=myScanner.nextLine();
		System.out.printf("%s\n","Enter id");
		id=myScanner.nextLine();
		System.out.printf("%s\n","Enter department");
		department=myScanner.nextLine();
		myCourse=new Course();
	}
	public void displayInformation()
	{
		System.out.println();
		System.out.printf("name:%s\n",name);
		System.out.printf("id:%s\n",id);
		System.out.printf("department:%s\n\n",department);
		myCourse.displayCourseInformation();
	}
}
