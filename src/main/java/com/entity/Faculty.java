package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "faculty")
public class Faculty {

    @Id
    @Column(name = "facultyId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer facultyId;

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

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        return !(title != null ? !title.equals(faculty.title) : faculty.title != null);

    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return title + " Faculty ID: " + facultyId ;
    }
}
