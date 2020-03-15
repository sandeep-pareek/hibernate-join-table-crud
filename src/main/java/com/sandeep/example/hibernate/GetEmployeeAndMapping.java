package com.sandeep.example.hibernate;


import org.hibernate.Session;

import com.sandeep.example.hibernate.entity.Employee;

/**
 * 
 * @author sandeep
 *
 */
public class GetEmployeeAndMapping {

	  public static void main(String[] args) {
	    Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      	     
	      Employee e = (Employee) session.get(Employee.class, 2l);
	      System.out.println(e);
	       
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
