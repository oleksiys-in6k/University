package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "faculty")
public class Faculty {

    @Id
    @Column(name = "facultyId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int facultyId;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
    private List <Student> students;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
    private List <Course> courses ;


    public Faculty (List<Student> students, String title) {
        this.students = students;
        this.title = title;
    }

    public Faculty (String title) {
        this.title = title;
    }

    public Faculty() {
    }

    public int getFacultyId() {
        return facultyId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "\n" +
                facultyId + "\t\t" +
                title;
    }
}
