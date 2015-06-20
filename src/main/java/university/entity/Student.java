package university.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "student")
public class Student {

    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    private String name;

    private String login;
    private String password;


    private boolean enabled;

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @OneToMany(mappedBy = "student")
    private Set<UserRole> userRole = new HashSet<UserRole>(0);


    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return !(faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) && !(name != null ? !name.equals(student.name) : student.name != null);

    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + "(" + faculty + ")" + " Student ID: " + studentId + "\n";
    }
}
