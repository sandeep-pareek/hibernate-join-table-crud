package com.sandeep.example.hibernate;


import org.hibernate.Session;

import com.sandeep.example.hibernate.entity.Address;
import com.sandeep.example.hibernate.entity.Employee;

/**
 * 
 * @author sandeep
 *
 */
public class SaveAddressAndMapping {

	  public static void main(String[] args) {
	    Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      
	      Employee e = (Employee) session.get(Employee.class, 1l);
	      	     
	      Address a = new Address();
	      a.setId(3l);
	      a.setName("C galli");
	      a.setEmployee(e);

	      session.save(a);
	      
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
