import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void removeSpecialChars() {
        String s = "1234 3rd Ave.,";
        s= Application.removeSpecialChars(s);
        assertFalse(s.contains("."));
    }

    @Test
    void sortByLastFirst() {
        List<Person> people = new ArrayList<>();

        Person one = new Person("Anny", "Bagel", 55);
        Person two = new Person("Joe", "Anne", 33);
        Person three = new Person("Connie", "May", 30);
        Person four = new Person("Tom", "Bagel", 18);

        people.add(one);
        people.add(two);
        people.add(three);
        people.add(four);

        Application.sortByLastFirst(people);
        assertEquals("Joe", people.get(0).getFirstName());
    }
}