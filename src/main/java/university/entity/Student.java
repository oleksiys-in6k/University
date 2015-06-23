package university.entity;

import javax.persistence.*;

@Entity(name = "student")
public class Student extends User {

    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    public Student(String name, Faculty faculty) {
        super(name);
        this.faculty = faculty;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    public int getStudentId() {
        return studentId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
