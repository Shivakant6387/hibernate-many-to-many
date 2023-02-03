package com.example.springboothibernatemanytomany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String dept;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",joinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName = "id")
    },inverseJoinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "id")
    })
    //git remote add origin git@github.com:Shivakant6387/hibernate-many-to-many.git
    //git push -u origin master@JsonManagedReference
    private Set<Course>courses;

}
