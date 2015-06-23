package university.entity;

import javax.persistence.*;

@Entity(name = "teacher")
public class Teacher extends User {
    @Id
    @Column(name = "teacherId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")
    private Course course;

    public Teacher(String name, Course course) {
        super(name);
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
