package com.springbootProject.springdatajpatutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString(exclude = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private  Long courseMaterialId;
    private  String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_ID",
            referencedColumnName = "courseID"

    )
    private  Course course;
}
