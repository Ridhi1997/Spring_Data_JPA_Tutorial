package com.springbootProject.springdatajpatutorial.repository;

import com.springbootProject.springdatajpatutorial.entity.Guardian;
import com.springbootProject.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private  StudentRepository studentRepository;
    @Test
    public void  saveStudent(){
        Student student = Student.builder()
                .emailId("rid123@gmail.com")
                .firstName("Ridhi")
                .lastName("Mishra")
//                .guardianName("Deo")
//                .guardianEmail("de0123@gmail.com")
//                .guardianMobile("9999999999")
                .build();
        studentRepository.save(student);

    }

    @Test
    public  void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Deo")
                .email("de0123@gmail.com")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Nidhi")
                .lastName("Mishra")
                .emailId("nidhi1234@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }
    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("StudentList "+studentList);
    }

   @Test
    public  void printStudentByFirstName(){
        List<Student>  student = studentRepository.findByFirstName("Nidhi");
       System.out.println("First Name  : "+ student);
    }

    @Test
    public  void printStudentByFirstNameContain(){
        List<Student> student = studentRepository.findByFirstNameContaining("dhi");
        System.out.println("Print first name  which contain dhi :" +student);
    }

    @Test
    public  void  printStudentBasedOnGuardianName(){
        List<Student> student = studentRepository.findByGuardianName("Deo");
        System.out.println(" Students =  "+student);

    }

    @Test
    public  void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("nidhi1234@gmail.com");
        System.out.println("Students :"+student);
    }

    @Test
    public  void  printGetStudentFirstNameByEmailAddress(){
        String firstName = studentRepository
                .getStudentFirstNameByEmailAddress("nidhi1234@gmail.com");
        System.out.println("First Name : "+firstName);
    }

    @Test
    public  void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("nidhi1234@gmail.com");
        System.out.println("Student = "+student);
    }

    @Test
    public  void  printGetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNative("nidhi1234@gmail.com");
        System.out.println("Student = "+student);
    }
    @Test
    public  void  updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId(
                "Nidhi Mishra",
                "nidhi1234@gmail.com");
    }



}