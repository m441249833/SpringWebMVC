package com.mk.Controller;

import com.mk.Entity.Student;
import com.mk.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Object getStudentById(@PathVariable("id") int id){
        if (studentService.getStudentById(id) == null) {
            return "student not found";
        }
        return studentService.getStudentById(id);
    }
}
