package university.entity;

import javax.persistence.*;

@Entity(name = "mark")
public class Mark {

    @Id
    @Column(name = "markId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer markId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseId")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private Student student;

    private int rating;

    public Mark(Student student, Course course, int rating) {
        this.rating = rating;
        this.student = student;
        this.course = course;
    }

    public Mark() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (rating != mark1.rating) return false;
        return !(course != null ?
                !course.equals(mark1.course) : mark1.course != null) &&
                !(student != null ? !student.equals(mark1.student) : mark1.student != null);

    }

    @Override
    public int hashCode() {
        int result = course != null ? course.hashCode() : 0;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        return "\n" +
                markId +
                course +
                student +
                rating;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getRating() {
        return rating;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public Integer getMarkId() {
        return markId;
    }

}
