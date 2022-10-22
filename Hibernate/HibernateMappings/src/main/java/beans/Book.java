package beans;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @Column(name="Id")
    private int id;
    @Column(name="Subject")
    private String subject;
    @Column(name = "Author")
    private String author;

    @ManyToOne
    @JoinColumn(name="StudentId")
    private Student student;

    public Book() {
    }

    public Book(int id, String subject, String author,Student student) {
        this.id = id;
        this.subject = subject;
        this.author = author;
        this.student=student;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    public Student getStudent() {
        return student;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", author='" + author + '\'' +
                ", student=" + student +
                '}';
    }
}
