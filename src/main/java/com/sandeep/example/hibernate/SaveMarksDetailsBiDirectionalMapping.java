package com.sandeep.example.hibernate;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.sandeep.example.hibernate.entity.Employee;
import com.sandeep.example.hibernate.entity.MarksDetails;
import com.sandeep.example.hibernate.entity.Student;

/**
 * 
 * @author sandeep
 *
 */
public class SaveMarksDetailsBiDirectionalMapping {

	  public static void main(String[] args) {
	    Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();

	      Student s2 = new Student("James2", "Goslin2", "s@s.com", "1235");
	      
	      //save student
	      session.save(s2);
	      MarksDetails m1 = new MarksDetails("s3", "100", "100", "pass");
	      m1.setStudent(s2);

	      session.save(m1);
	      
	      //update
	      m1.setSubject("s_n");
	      session.update(m1);
	      
	      // get persistent object
	      Student s3 = (Student) session.get(Student.class, 12l);
	      System.out.println(s3.toString());

	      session.getTransaction().commit();
	       
	      session.close();

	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (session != null) {
	        session.close();
	      }
	    }

	    HibernateUtil.shutdown();
	  }
	}
