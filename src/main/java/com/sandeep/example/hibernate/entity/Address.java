package com.sandeep.example.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author sandeep
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address {
  @Id
  @Column(name = "ADDR_ID")
  private Long id;

  @Column(name = "ADDR_NAME")
  private String name;

  @OneToOne(cascade=CascadeType.ALL)
  @JoinTable(name="EMP_ADDR", joinColumns = {@JoinColumn(name="ADDR_ID")},
  inverseJoinColumns = {@JoinColumn(name="EMP_ID")})
  private Employee employee;
  
  public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
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
