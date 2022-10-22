package beans;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @Column(name="Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name="Duration")
    private int duration;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
    private List<Pupil> pupils;

    public Course() {
    }

    public Course(int id, String name, int duration,List<Pupil> pupils) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.pupils=pupils;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(List<Pupil> pupils) {
        this.pupils = pupils;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", pupils=" + pupils +
                '}';
    }
}
