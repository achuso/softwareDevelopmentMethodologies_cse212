import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class PersonTest {

    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe", 25);
        Person person2 = new Person("Jane", "Doe", 30);
        Person person3 = new Person("James", "Brown", 15);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        
        Collections.sort(people, new AgeComparator());
        
        //Sort people by age in ascending order
        for(Person p: people) {
        	
        	System.out.printf("%s %s %d\n", p.getFirstName(), p.getLastName(), p.getAge());
        	
        }
        
        //Sort people by first name in descending order
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getFirstName().compareTo(p1.getFirstName());
                
            }
        });
        
        System.out.println();
        for(Person p: people) {
        	
        	System.out.printf("%s %s %d\n", p.getFirstName(), p.getLastName(), p.getAge());
        	
        }
        
    }
}
