public class Assignment {

    private String studentName;
    private int studentId;
    private double points;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        String assignmentInfo = "Student name: " + getStudentName() + "Student ID: " + getStudentId() + "Student Points: " + getPoints();
        return assignmentInfo;
    }
}
