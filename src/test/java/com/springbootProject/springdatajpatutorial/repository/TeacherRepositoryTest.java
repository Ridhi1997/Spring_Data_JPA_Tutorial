package com.springbootProject.springdatajpatutorial.repository;

import com.springbootProject.springdatajpatutorial.entity.Course;
import com.springbootProject.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {
  @Autowired
private  TeacherRepository teacherRepository;

  @Test
    public  void saveTeacher(){
      Course courseDBA = Course.builder()
              .title("DBA")
              .credit(5)
              .build();
      Course courseJava = Course.builder()
              .title("Java")
              .credit(6)
              .build();
      Teacher teacher = Teacher.builder()
              .firstName("Yogesh")
              .lastName("Kumar")
//              .courses(List.of(courseDBA,courseJava))
              .build();

      teacherRepository.save(teacher);

  }

}