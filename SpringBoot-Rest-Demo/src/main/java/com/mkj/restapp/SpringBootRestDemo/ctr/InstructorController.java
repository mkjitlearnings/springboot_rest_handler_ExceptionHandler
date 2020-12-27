package com.mkj.restapp.SpringBootRestDemo.ctr;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.restapp.SpringBootRestDemo.bean.Instructor;
import com.mkj.restapp.SpringBootRestDemo.dao.InstructorDAO;
import com.mkj.restapp.SpringBootRestDemo.execptions.DuplicateInstructorIdException;

@RestController
public class InstructorController {

	@Autowired
	InstructorDAO dao;
	
	public InstructorController() {
		super();
		System.out.println(" Inside default contructor called ...");
		// TODO Auto-generated constructor stub
	}

	public InstructorController(InstructorDAO dao) {
		super();
		this.dao = dao;
		System.out.println(" --- REST Controller dao "+dao);
	}
	
	@GetMapping("/")
	public String  abd()
	{
		return "ytftydftyd";
	}

	@GetMapping("/instructor/name")
	public List<String> getInstructor()
	{
		System.out.println(" get Mapping called ");
		return dao.getAllInstructors();
	}

	@GetMapping("/instructor/info")
	public List<Instructor> getInstructorInfo()
	{
		System.out.println(" get Mapping called ");
		return dao.getAllInstructorsInfo();
	}

	
	@PostMapping("/instructor")
	public String addInstructor(@RequestBody Instructor instructor)throws DuplicateInstructorIdException
	{
		System.out.println(" Saving Instructor "+instructor);
		try {
			Instructor ins = dao.saveInstructor(instructor);
			return ins.getName()+" "+ins.getInstructorcode()+" -  "+"Saved";
		} catch (Exception e) {
			throw new DuplicateInstructorIdException(e.getMessage());
		}
	}

	
	
	
	
}
