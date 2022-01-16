import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Person {

    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //tostring
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}


public class PersonTest {

    // Test all properties
    // of class Person
    @Test
    public void testPerson() {
        Person person = new Person(1, "John", "");

        assertEquals(1, person.getId());
        assertEquals("John", person.getName());
        assertEquals("", person.getEmail());
    }
}
