package com.mkj.restapp.SpringBootRestDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkj.restapp.SpringBootRestDemo.bean.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {
	
	@Autowired
	EntityManager entityManager;
	
	public InstructorDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
		System.out.println(" inside entity manager Impl constructor ");
		
	}
	public InstructorDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public List<String> getAllInstructors() {
		Session session = entityManager.unwrap(Session.class);
		System.out.println(" Session Build "+session);
		
		Query<String> query = session.createQuery("select name from Instructor");
		
		System.out.println(" Query executed "+query);
		return query.getResultList();
		
	}
	
	@Override
	@Transactional
	public List<Instructor> getAllInstructorsInfo() {
		Session session = entityManager.unwrap(Session.class);
		System.out.println(" Session Build "+session);
		
		Query<Instructor> query = session.createQuery("from Instructor",Instructor.class);
		
		System.out.println(" Query executed "+query);
		return query.getResultList();
		
	}
	
	@Override
	@Transactional
	public Instructor saveInstructor(Instructor instructor)throws Exception {
		
		Session session = entityManager.unwrap(Session.class);
		try
		{
			session.save(instructor);
		}
		catch(Exception e)
		{
			throw e;
		}
		return instructor;
		
		
	}
	

}
