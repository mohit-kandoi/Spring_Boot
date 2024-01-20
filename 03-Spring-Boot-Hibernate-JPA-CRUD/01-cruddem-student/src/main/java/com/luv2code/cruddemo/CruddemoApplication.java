package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			listOfStudent(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println(numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2;
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId =1;
		Student mystudent = studentDAO.findById(studentId);
		mystudent.setFirstName("Mohit");
		studentDAO.update(mystudent);
		System.out.println(mystudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.findByLastName("Kandoi");
		for(Student temp : theStudent){
			System.out.println(temp);
		}
	}

	private void listOfStudent(StudentDAO studentDAO) {
		List<Student> temp = studentDAO.findAll();
		for (Student e : temp){
			System.out.println(e);
		}
	}


	private void readStudent(StudentDAO studentDAO) {
		Student temp = new Student("x","Y","xy@gmail.com");
		studentDAO.save(temp);
		int theId = temp.getId();
		Student myStudent = studentDAO.findById(theId);
		System.out.println(myStudent);
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
