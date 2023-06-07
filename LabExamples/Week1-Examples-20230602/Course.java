import java.util.Scanner;


public class Course {
	String courseName;
	String courseCode;
	public Course()
	{
		Scanner myScanner=new Scanner(System.in);
		System.out.printf("%s\n","Enter course name");
		courseName=myScanner.nextLine();
		System.out.printf("%s\n","Enter course code");
		courseCode=myScanner.nextLine();
	}
	public void displayCourseInformation()
	{
		System.out.println();
		System.out.println("course name:"+courseName);		
		System.out.println("course code:"+courseCode+"\n");
	}
}
