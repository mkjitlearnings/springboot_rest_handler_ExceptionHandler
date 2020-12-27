package com.mkj.restapp.SpringBootRestDemo.dao;

import java.util.List;

import com.mkj.restapp.SpringBootRestDemo.bean.Instructor;

public interface InstructorDAO {
	
	public List<String> getAllInstructors();
	public List<Instructor> getAllInstructorsInfo();
	
	public Instructor saveInstructor(Instructor instructor)throws Exception;

}
