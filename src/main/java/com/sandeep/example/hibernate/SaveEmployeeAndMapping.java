package com.sandeep.example.hibernate;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.sandeep.example.hibernate.entity.Address;
import com.sandeep.example.hibernate.entity.Employee;

/**
 * 
 * @author sandeep
 *
 */
public class SaveEmployeeAndMapping {

	  public static void main(String[] args) {
	    Session session = null;
	    try {
	      session = HibernateUtil.getSessionFactory().openSession();
	      session.beginTransaction();
	      	     
	      Address a = new Address();
	      a.setId(4l);
	      a.setName("D galli");
	      
	      Address b = new Address();
	      b.setId(5l);
	      b.setName("E gali");
	      List<Address> listAddr = new ArrayList<>();
	      listAddr.add(b);
	      listAddr.add(a);
	      Employee e = new Employee();
	      e.setId(2l);
	      e.setName("Deepak");
	      e.setAddresses(listAddr);

	      session.save(e);
	      
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
