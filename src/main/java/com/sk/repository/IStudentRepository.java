package com.sk.repository;

import org.springframework.data.repository.CrudRepository;

import com.sk.Entity.Student;

public interface IStudentRepository extends CrudRepository<Student, Integer>
{

}
