package beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    private int id;
    private Name name;

    public Person() {
    }

    public Person(int id, Name name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
