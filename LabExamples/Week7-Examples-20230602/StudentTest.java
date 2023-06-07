import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 1001, 3.5));
        students.add(new Student("Bob", 1002, 3.2));
        students.add(new Student("Charlie", 1003, 3.8));

        // Sort students by GPA in descending order
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });

        // Print sorted list of students
        for (Student student : students) {
            System.out.println(student.getName() + " - " + student.getGpa());
        }
    }
}
