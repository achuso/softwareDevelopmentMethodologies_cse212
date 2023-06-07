public class AssignmentTest {

    public static void main(String[] args) {

        Assignment assignment = new Assignment();
        assignment.setStudentName("Alice");
        assignment.setStudentId(101);
        assignment.setPoints(70.5);


        System.out.println(assignment.toString());

    }
}
