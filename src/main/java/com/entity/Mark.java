package com.entity;

import javax.persistence.*;

@Entity(name = "Mark")
public class Mark {

    @Id
    @Column(name = "markId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int markId;

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

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }
}
