package com.springbootProject.springdatajpatutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name ="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
     @GeneratedValue(
             strategy = GenerationType.SEQUENCE,
             generator = "course_sequence"
     )
    private Long courseID;
    private  String title;
    private  Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_ID",
            referencedColumnName = "teacherID"
    )
    private  Teacher teacher;

    @ManyToMany

  @JoinTable(name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
          inverseJoinColumns = @JoinColumn(
                  name = "student_id",
                  referencedColumnName = "studentId"
          )

  )
    private List<Student> students;

    public void addStudents(Student student){
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
}