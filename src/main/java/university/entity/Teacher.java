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
    private Course course;

    @Column(name = "name", unique = true)
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_user",
            joinColumns = @JoinColumn(name = "teacherId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private User user;

    public Teacher(String name, Course course, String login, String password) {
        this.name = name;
        this.course = course;
        this.user = new User(login, password);
    }

    public Teacher() {
    }

    public Teacher(String name, Course course, String login, String password, UserRole userRoleUser) {
        this.name = name;
        this.course = course;
        this.user = new User(login, password, userRoleUser);
    }

    public Teacher(String name, Course course, User teacherUser) {
        this.name = name;
        this.course = course;
        this.user = teacherUser;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String name) {
        this.name = name;
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
                !(course != null ? !course.equals(teacher.course) : teacher.course != null) &&
                        !(name != null ? !name.equals(teacher.name) : teacher.name != null);
    }

    @Override
    public int hashCode() {
        int result = course != null ? course.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + "(" + course + ")" + " Teacher ID: " + teacherId + "" + "\n";
    }
}