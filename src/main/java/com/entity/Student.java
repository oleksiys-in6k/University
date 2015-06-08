package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "student")
public class Student {

    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private List <Course> course = new ArrayList<Course>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "markId")
    private List <Mark> marks = new ArrayList<Mark>();

    private String name;

    public Student(String name, Faculty faculty) {
        this.faculty = faculty;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n" + studentId + "\t\t" +
                getFaculty().getTitle() + "\t\t" +
                name;
    }
}
