package com.sk.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sk.BootJpaProj02StudentApplication;
import com.sk.Entity.Student;
import com.sk.repository.IStudentRepository;

@Service("stService")
public class ServiceImplClass implements IServiceMngmnt
{

    private final BootJpaProj02StudentApplication bootJpaProj02StudentApplication;
	   @Autowired
       private IStudentRepository docRepo;

    ServiceImplClass(BootJpaProj02StudentApplication bootJpaProj02StudentApplication) {
        this.bootJpaProj02StudentApplication = bootJpaProj02StudentApplication;
    }
	
    // Select Quries
	@Override
	public Iterable<Student> showAllValue() {
	  
		Iterable<Student> all = docRepo.findAll();
		
		return all;
		
	}
   //Insert Values
	@Override
	public void registeredValue(Student s) {

		
		     Student save = docRepo.save(s);
		     System.out.println("Student Value Inserted Successfully.......");
	}
  //Count All records
	@Override
	public Long countRecords() {
		System.out.println("All avialable method  "+Arrays.toString(docRepo.getClass().getDeclaredMethods()));
		Long value = docRepo.count();
		return value;
	}

	@Override
	public Iterable<Student> saveMultipleData(Iterable<Student> e) {

		      Iterable<Student> AllData = docRepo.saveAll(e);
		      
		      return AllData;
	}

	@Override
	public String checkAvilable(Integer id) {
        boolean flag = docRepo.existsById(id);
        if(flag)
        {
        	return "Id is avilable "+id;
        }
        else return "Id is not avilable "+id ;
	}

	@Override
	public Iterable<Student> checkMultipleIdAtATime(Iterable<Integer> i) {
		
		   return   docRepo.findAllById(i);
		   
	}

	@Override
	public String updateRecord(Student s) {
		 
		Student save = docRepo.save(s);
		
		return "The value Update Successfullly";
	}

	@Override
	public Optional<Student> findById(Integer id) {
		
		Optional<Student> byId = docRepo.findById(id);		
		return byId;
	}

	@Override
	public String removeByStudentID(Integer id) {
      
		boolean flag = docRepo.existsById(id);
		
		if(flag)
		{
	         docRepo.deleteById(id);
	         return "Id sucessfully Deleted";
		}
		
		return "ID not found" ;
	}
	
	public String removeAllStudent()
	{
		long num = docRepo.count();
		docRepo.deleteAll();
		
		return num+ " Record are deleted";
		
	}

}
