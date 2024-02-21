package com.springbootProject.springdatajpatutorial.repository;

import com.springbootProject.springdatajpatutorial.entity.Course;
import com.springbootProject.springdatajpatutorial.entity.Student;
import com.springbootProject.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private  CourseRepository courseRepository;

    @Test
    public  void printAllCourses(){
        List<Course> course = courseRepository.findAll();
        System.out.println("Course"+course);
    }
    @Test
    public  void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Golu")
                .lastName("Thakur")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);

    }
    @Test
    public  void findAllPagination(){
        Pageable firstPageWithThreeRecord = PageRequest.of(0,3);
//        Pageable secondPageWithTwoRecord = PageRequest.of(0,2);

        List<Course> course = courseRepository.findAll(firstPageWithThreeRecord).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecord).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecord).getTotalPages();
        System.out.println("totalPages  = "+totalPages);
        System.out.println("totalElements  = "+totalElements);
        System.out.println("Course  = "+course);

    }

    @Test
    public  void findAllSorting(){
        Pageable sortByTitle = PageRequest
                .of(0,2,Sort.by("title") );

        Pageable sortByCredit = PageRequest
                .of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title").descending().and(Sort.by("credit")));

       List<Course>  courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses"+courses);
    }

    @Test
    public  void  getFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords).getContent();

    }
    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }

}