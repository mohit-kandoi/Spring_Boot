package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.StudentDAO;
import com.luv2code.cruddemo.DAO.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
				createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("mohit","kandoi","mohitkandoi65@gamil.com");

		System.out.println("Saving the Student..");
		studentDAO.save(tempStudent);

		System.out.println("Saved Student id: "+tempStudent.getId());

	}
}
