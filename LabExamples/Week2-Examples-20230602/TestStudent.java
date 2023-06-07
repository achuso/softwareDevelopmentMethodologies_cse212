public class TestStudent {

    public static void main(String[] args) {
        Student s1 = new Student(100, "Alice");
        Student s2 = new Student(101, "Bob");

        s1.displayInfo();
        s2.displayInfo();

        Student.college = "OZU";
        Student s3 = new Student(200, "Paul");
        s3.displayInfo();

        s2.displayInfo();

    }
}
