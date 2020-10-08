package md.cernev.springmvc.dao;

import md.cernev.springmvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = Arrays.asList(new Person(++PEOPLE_COUNT, "John Wick"), new Person(++PEOPLE_COUNT, "Dima Cernev"), new Person(++PEOPLE_COUNT, "Hitman"));

    }

    public List<Person> getAllPeople() {
        return people;
    }

    public Person getPerson(int id) {
        return people.stream().filter(person -> person.id() == id).findAny().orElse(null);
    }
}
