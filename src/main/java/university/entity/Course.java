package university.entity;

import javax.persistence.*;

@Entity(name = "course")
public class Course {

    @Id
    @Column(name = "courseId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    public Course(Faculty faculty, String title) {
        this.faculty = faculty;
        this.title = title;
    }

    public Course() {
    }

    public String getTitle() {
        return title;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (title != null ? !title.equals(course.title) : course.title != null) return false;
        return !(faculty != null ? !faculty.equals(course.faculty) : course.faculty != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return title + courseId + faculty;
    }
}
