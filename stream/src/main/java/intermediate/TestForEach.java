package intermediate;

import java.util.ArrayList;
import java.util.List;

public class TestForEach {
    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person(Person.Sex.FEMALE, "Lisa"));
        roster.add(new Person(Person.Sex.MALE, "King"));
        roster.add(new Person(Person.Sex.MALE, "Jake"));
        // JDK 8
        roster.stream().filter(p -> p.gender == Person.Sex.MALE)
                       .forEach(p -> System.out.println(p.name));
        // JDK 7
        for (Person p : roster) {
            if(p.gender == Person.Sex.MALE){
                System.out.println(p.name);
            }
        }
    }
}

class Person {
    Sex gender;
    String name;
    public enum Sex { MALE, FEMALE }
    public Person(Sex gender, String name) {
        this.gender = gender;
        this.name = name;
    }
}