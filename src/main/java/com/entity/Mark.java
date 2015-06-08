package com.entity;

import javax.persistence.*;

@Entity(name = "Mark")
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

    private int mark;

    public Mark(Student student, Course course, int mark) {
        this.mark = mark;
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

        if (mark != mark1.mark) return false;
        if (course != null ? !course.equals(mark1.course) : mark1.course != null) return false;
        return !(student != null ? !student.equals(mark1.student) : mark1.student != null);

    }

    @Override
    public int hashCode() {
        int result = course != null ? course.hashCode() : 0;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + mark;
        return result;
    }

    @Override
    public String toString() {
        return "\n" +
                markId + "\t\t" +
                course.getTitle() + "\t\t" +
                student.getName() + "\t\t" +
                mark;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getMark() {
        return mark;
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
