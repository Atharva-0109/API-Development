package com.example.API.Development.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/studentdata")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentData> getStudents()
    {
        return studentService.studentData();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody StudentData studentData)
    {
        studentService.addNewStudent(studentData);
    }

    @DeleteMapping(path = "{studemtId}")
    public void deleteStudent(@PathVariable("studentId") Long id)
    {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "studentId")
    public void updateStudent(@PathVariable  Long studentId,@RequestParam(required = false) String name,@RequestParam(required = false) String email)
    {
        studentService.updateStudent(studentId,name,email);
    }
}
