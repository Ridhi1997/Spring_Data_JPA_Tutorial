package com.springbootProject.springdatajpatutorial.repository;

import com.springbootProject.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student>  findByFirstName(String firstName);
    public  List<Student> findByFirstNameContaining(String name);
    public  List<Student> findByGuardianName(String name);

    /*JPQl--> is defined in a separate way rather than the native sql query. So basically JPQL  query is defined
    based on classes yoy have created ,not based on Database you have created(table_name or  and attribute*/
   //JPQl
    @Query("select s from   Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from   Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native SQL Query
    @Query(
            value = "select * from tbl_student s where s.email_address =?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native Named Param
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId);

     /*  Transactional and Modifying Annotation*/
   @Modifying
   @Transactional
   @Query(
           value = "update tbl_student  set first_name =?1 where email_address = ?2 ",
           nativeQuery = true
   )
   void updateStudentNameByEmailId(String firstName, String emailId);

}
