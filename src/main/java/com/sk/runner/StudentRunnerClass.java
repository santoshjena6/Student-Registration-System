package com.sk.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sk.BootJpaProj02StudentApplication;
import com.sk.Entity.Student;
import com.sk.service.IServiceMngmnt;

@Component
public class StudentRunnerClass implements CommandLineRunner
{

    private final BootJpaProj02StudentApplication bootJpaProj02StudentApplication;
	@Autowired
   private IServiceMngmnt docService;


    StudentRunnerClass(BootJpaProj02StudentApplication bootJpaProj02StudentApplication) {
        this.bootJpaProj02StudentApplication = bootJpaProj02StudentApplication;
    }
	
	
	

	@Override
	public void run(String... args) throws Exception {
	        Student st = new Student();
		st.setAddress("Odisha");
		st.setStudentName("Santosh");
		st.setNumber(799104819l);
		
		Student st1 = new Student("Sammer","Bls",9342049l);
		Student st2 = new Student("Litu","Jajur",993845l);
		Student st3 = new Student("Jacky","cuttack",46586554l);
		
		List<Student> of = List.of(st1,st2,st3);
	  
		try
		{
			docService.registeredValue(st); // Insert Operation
			
			Long countRecords = docService.countRecords();//Count How Many Record Avialable
			
			
			
			System.out.println("Number of Record is : "+countRecords);
			
			
			//Insert Bulk Values at a time
 			Iterable<Student> saveMultipleData = docService.saveMultipleData(of);
 		    
 		 saveMultipleData.forEach(Student -> System.out.println(Student.getSId()));
 		 
 		 //Check Whether the id is avialable or not
 		 String checkAvilable = docService.checkAvilable(1);
 		 System.err.println(checkAvilable);
 		 
 		 //Send Multiple Values at a time
 		 
 		 Iterable<Student> mv = docService.checkMultipleIdAtATime(List.of(10,20,1,2,52,51,102,101,103,1));
 		 mv.forEach(System.err::println);
 		 
 		 //Update one existing record
 		 Student s = new Student(1,"Sanrish","Bhubaneswar",9090909090l);
 		 String updateRecord  = docService.updateRecord(s);
 		 System.err.println(updateRecord);
 		 
 		 
 		 //Get the record by help of id
 		 Optional<Student> byId = docService.findById(1);
 		 if(byId.isPresent())
 		 {
 			 Student student10 = byId.get();
 			 System.err.println("The value you want \n"+student10);
 		 }
 		 
 		 
 		 
 		Iterable<Student> showAllValue = docService.showAllValue();
		showAllValue.forEach(System.out::println);
		
		System.out.println("================================");
		Iterable<Student> showAllValue2 = docService.showAllValue();
		showAllValue2.forEach(System.out::println);
        System.out.println("After delete one record"); 	
        
        String msg = docService.removeByStudentID(52);
        System.out.println(msg);
			
			
		Student updateStudent = new Student(502,"Sanrish","Hyderabad",209301l);
		String updateRecord1 = docService.updateRecord(updateStudent);
		System.out.println(updateRecord1);
		
		//Remove all Student Record
		String m = docService.removeAllStudent();
		System.err.println(m);
		
		}
		catch(Exception e)
		{
	      e.printStackTrace();		
		}
		
	}
	
	
}
