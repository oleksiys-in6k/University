package university.entity;

import javax.persistence.*;

@Entity(name = "teacher")
public class Teacher {

    @Id
    @Column(name = "teacherId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    @Column(name = "name", unique = true)
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_user",
            joinColumns = @JoinColumn(name = "teacherId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private User user;

    public Teacher(String name, Faculty faculty, String login, String password) {
        this.name = name;
        this.faculty = faculty;
        this.user = new User(login,password);
    }

    public Teacher() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public int getStudentId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return
                !(faculty != null ? !faculty.equals(teacher.faculty) : teacher.faculty != null) &&
                        !(name != null ? !name.equals(teacher.name) : teacher.name != null);
    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + "(" + faculty + ")" + " Teacher ID: " + teacherId + "" + "\n";
    }
}