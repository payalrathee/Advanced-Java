package beans;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name="Name")
    private String name;
    @OneToMany(mappedBy = "student",cascade= CascadeType.ALL)
    private List<Book> books;

    public Student() {
    }

    public Student(int id, String name,List<Book> books) {
        this.id = id;
        this.name = name;
        this.books=books;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
