package com.example.springboot;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;
    //Define @PostConstruct to load the student data…. Only once.
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("DD", "Singh"));
        theStudents.add(new Student("Dev", "Singh"));
        theStudents.add(new Student("Shweta", "Singh"));
        System.out.println("-----------load data--------");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        System.out.println("---getting all students---");
        return  theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        System.out.println("---get one student---");
        if((studentId >= theStudents.size()) || (studentId < 0)  )
        {
           throw new StudentNotFoundException("Student Id Not Found --- " +studentId);
            //throw new RuntimeException();
        }

        return  theStudents.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus. BAD_REQUEST);
    }


}
