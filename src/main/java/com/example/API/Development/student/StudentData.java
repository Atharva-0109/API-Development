package com.example.API.Development.student;
import javax.persistence.*;//Always Import this package
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
@Entity
@Table
public class StudentData
{
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String email;
    private String name;
    private LocalDate dob;
    @Transient
    private Integer age;

    public StudentData() {
    }

    public StudentData(Long id, String email, String name, LocalDate dob) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.dob = dob;
        //this.age = age;
    }

    public StudentData(String email, String name, LocalDate dob) {
        this.email = email;
        this.name = name;
        this.dob = dob;
        //this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "StudentData{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
