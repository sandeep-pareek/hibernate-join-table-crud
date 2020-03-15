package com.sandeep.example.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author sandeep
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
  @Id
  @Column(name = "EMP_ID")
  private Long id;

  @Column(name = "EMP_NAME")
  private String name;

  @OneToMany(cascade=CascadeType.ALL)
  @JoinTable(name = "EMP_ADDR", joinColumns = {@JoinColumn(name = "EMP_ID")},
  inverseJoinColumns = {@JoinColumn(name="ADDR_ID")})
  List<Address> addresses;
  
  public List<Address> getAddresses() {
	return addresses;
}

public void setAddresses(List<Address> addresses) {
	this.addresses = addresses;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
