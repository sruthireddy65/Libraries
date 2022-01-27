package com.self.libraries.jpapractice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
    joinColumns = @JoinColumn(name = "STUDENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }
}
