public class Student {

    int id;
    String name;
    static String college = "Yeditepe University";

    public Student(int i, String n){
        id = i;
        name = n;

    }

    void displayInfo(){
        System.out.println(id + " " + name + " " + college);
    }

}
