package beans;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pupil {
    @Id
    @Column(name="Id")
    private int id;
    @Column(name="Name")
    private String name;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="enrollment",
            joinColumns = {@JoinColumn(name="PupilId")},
            inverseJoinColumns = {@JoinColumn(name="CourseId")}
    )
    private List<Course> courses;

    public Pupil() {
    }

    public Pupil(int id, String name,List<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses=courses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
