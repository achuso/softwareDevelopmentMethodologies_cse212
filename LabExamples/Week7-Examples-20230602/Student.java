public class Student {
    private String name;
    private int id;
    private double gpa;

    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }
}