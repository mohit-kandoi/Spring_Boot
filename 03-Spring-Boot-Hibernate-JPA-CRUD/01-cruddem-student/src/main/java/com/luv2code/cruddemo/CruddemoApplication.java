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
				// createStudent(studentDAO);

				createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Aman","Kandoi","Amankandoi@gmail.com");
		Student tempStudent2 = new Student("Rishabh","Agarwal","Rishabhagarwal@gmail.com");
		Student tempStudent3 = new Student("Mukul","Tiwari","Mukultiwari@gmail.com");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("mohit","kandoi","mohitkandoi65@gamil.com");

		System.out.println("Saving the Student..");
		studentDAO.save(tempStudent);

		System.out.println("Saved Student id: "+tempStudent.getId());

	}
}
