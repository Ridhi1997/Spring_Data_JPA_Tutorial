package com.springbootProject.springdatajpatutorial.repository;

import com.springbootProject.springdatajpatutorial.entity.Course;
import com.springbootProject.springdatajpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;

    @Test
    public  void saveCourseMaterial(){
        Course course = Course.builder()
                .title(".net")
                .credit(6)
                .build();
        CourseMaterial courseMaterial1 =
                CourseMaterial.builder()
                        .url("https://www.baeldung.com/")
                        .course(course)
                        .build();
        courseMaterialRepository.save(courseMaterial1);
    }
    @Test
    public  void  printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials =  courseMaterialRepository.findAll();
        System.out.println("Course Materials"+courseMaterials);

    }

}