package university.entity;

import javax.persistence.*;
import java.util.*;

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
    private String password;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "userRole",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<UserRole> userRoles = new ArrayList<>();

    public Student(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public Student() {
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public String getPassword() {
        return password;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Student(String name) {
        this.name = name;
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

        return
                !(faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) &&
                        !(name != null ? !name.equals(student.name) : student.name != null);

    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + "(" + faculty + ")" + " Student ID: " + studentId + "" + "\n";
    }
}
