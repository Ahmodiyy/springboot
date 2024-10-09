package com.example.springboot;

import com.example.springboot.dao.StudentDAO;
import com.example.springboot.entity.Students;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"component", "com.example.springboot", "config"})
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		System.out.println("hello to spring boot");
	}

	@Bean
	public CommandLineRunner runner(StudentDAO studentDAO){
		return args -> {
			//createStudent(studentDAO);
			getAll(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO){
		//Create the student object
		System.out.println("Creating student object...");
		Students tempStudent=new
				Students("Singh","Aurin","Singh@gmail.com");
		//Save the student object.
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);
		//Display id of the saved student.
		System.out.println("Saved Student Generated id is "+tempStudent.getId());
		System.out.println(studentDAO.findById(tempStudent.getId()));

	}
	void getAll(StudentDAO studentDAO){
		for (Students s : studentDAO.findAll()){
			System.out.println(s);
		}
	}
	void updateStudent(StudentDAO studentDAO){
		Students students = studentDAO.findById(1);
		students.setEmail("kapor@gmail.com");
		studentDAO.update(students);
	}
	void deleteStudent(StudentDAO studentDAO){
		studentDAO.delete(1);
	}


}
