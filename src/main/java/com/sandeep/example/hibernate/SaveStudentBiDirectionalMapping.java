package com.sandeep.example.hibernate;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.sandeep.example.hibernate.entity.MarksDetails;
import com.sandeep.example.hibernate.entity.Student;

/**
 * 
 * @author sandeep
 *
 */
public class SaveStudentBiDirectionalMapping {

	  public static void main(String[] args) {
	    Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();

	      Student s2 = new Student("Sandeep", "pareek", "s@s.com", "1234");
	      MarksDetails m1 = new MarksDetails("s1", "100", "30", "fail");
	      m1.setStudent(s2);
	      MarksDetails m2 = new MarksDetails("s2", "100", "45", "pass");
	      m2.setStudent(s2);
	      Set<MarksDetails> md = new HashSet<>();
	      md.add(m1);
	      md.add(m2);
	      s2.setMarksDetails(md);
	      session.save(s2);
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
