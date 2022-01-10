//Service or Business Layer Of API

package com.example.API.Development.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<StudentData> studentData()
    {
        return studentRepo.findAll();
    }

    public void addNewStudent(StudentData studentData) {

        Optional<StudentData> studentDataByEmail = studentRepo.findStudentDataByEmail(studentData.getEmail());
        //System.out.println(studentData);
        if(studentDataByEmail.isPresent())
        {
            throw new IllegalStateException("Email saved");
        }
        studentRepo.save(studentData);
    }


    public void deleteStudent(Long id) {
        boolean existsById = studentRepo.existsById(id);
        if(!existsById)
        {
            throw new IllegalStateException("Student with student id "+id+" does not exists.");
        }
        studentRepo.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        StudentData byId = studentRepo.getById(studentId);
        if(!studentRepo.existsById(studentId))
        {
            throw new IllegalStateException("Student with student id "+studentId+" does not exists.");
        }
        if(name!=null && name.length()>0 && !Objects.equals(byId.getName(),name))
        {
            byId.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(byId.getEmail(),email))
        {
            Optional<StudentData> byEmail = studentRepo.findStudentDataByEmail(email);
            if(byEmail.isPresent())
            {
                throw new IllegalStateException("Email Already Taken");
            }
            byId.setEmail(email);
        }
    }
}
