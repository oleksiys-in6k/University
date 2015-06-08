package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "course")
public class Course {

    @Id
    @Column(name = "courseId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List <Mark> marks = new ArrayList<Mark>();

    public Course(Faculty faculty, String title) {
        this.faculty = faculty;
        this.title = title;
    }

    public Course() {
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "\n" +
                courseId + "\t\t" +
                faculty.getTitle() + "\t\t" +
                title;
    }
}
