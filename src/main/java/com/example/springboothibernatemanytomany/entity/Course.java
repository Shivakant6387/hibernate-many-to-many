package com.example.springboothibernatemanytomany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;
    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    //@JsonManagedReference
    private Set<Student> students;
}
