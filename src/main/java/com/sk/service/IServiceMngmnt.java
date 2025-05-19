package com.sk.service;

import java.util.Optional;

import com.sk.Entity.Student;

public interface IServiceMngmnt 
{
   public Iterable<Student> showAllValue(); // Select Operation
   
   public void registeredValue(Student s);// Insert Operation
   
   public Long countRecords();// Count how many record Avialable
   
   public Iterable<Student> saveMultipleData(Iterable<Student> e); //Insert Bulk Operation
   
   public String checkAvilable(Integer id);//Check the given id is avilable or not
   
   public Iterable<Student> checkMultipleIdAtATime(Iterable<Integer> i);//check multiple id avilable or not at a time
   
   public String updateRecord(Student s); //Update One record 
   
   public Optional<Student> findById(Integer id); //get the record by help of id
   
   public String removeByStudentID(Integer id); // remove record by id
   
   public String removeAllStudent();
} 
