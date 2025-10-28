package com.example.Course.Registration.System.controller;

import com.example.Course.Registration.System.model.Course;
import com.example.Course.Registration.System.model.CourseRegistry;
import com.example.Course.Registration.System.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Course> availableCourses(){
        return courseService.availableCourses();
    }

    @GetMapping("courses/enrolled")
    public List<CourseRegistry> enrolledStudents(){
        return courseService.enrolledStudents();
    }

    @PostMapping("/courses/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("regno") String regno,
                               @RequestParam("dept") String dept,
                               @RequestParam("batch") String batch,
                               @RequestParam("emailId") String emailId,
                               @RequestParam("courseName") String courseName
                               ){
        courseService.enrollCourse(name,regno,dept,batch,emailId,courseName);
        return "Congratulations! "+name+" Enrollment Successful for "+courseName;

    }
}