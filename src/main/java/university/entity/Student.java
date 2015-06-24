package university.entity;

import javax.persistence.*;

@Entity(name = "student")
public class Student {

    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "student_user",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private User user;

    public Student(String name, Faculty faculty,String login,String password) {
        this.name = name;
        this.faculty = faculty;
        this.user = new User(login, password);
    }

    public Student() {
        super();
    }

    public Student(String name, Faculty faculty,String login,String password, UserRole userRoleUser) {
        this.name = name;
        this.faculty = faculty;
        this.user = new User(login, password,userRoleUser);

    }

    public Student(String name, Faculty faculty, User studentUser) {
        this.name = name;
        this.faculty = faculty;
        this.user = studentUser;
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
        return name + "(" + faculty + ")" + " Student ID: " + studentId +
                " userInfo" + user + "\n";
    }
}