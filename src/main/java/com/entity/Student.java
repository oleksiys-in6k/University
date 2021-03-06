package com.entity;

import javax.persistence.*;


@Entity(name = "student")
public class Student {

    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facultyId")
    private Faculty faculty;

    private String name;

    public Student(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student() {
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

        return !(faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) && !(name != null ? !name.equals(student.name) : student.name != null);

    }

    @Override
    public int hashCode() {
        int result = faculty != null ? faculty.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + "(" + faculty + ")" + " Student ID: " + studentId + "\n";
    }
}
