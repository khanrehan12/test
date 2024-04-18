package com.releationcombined.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	public Student() {
		super();
	}

	public Student(int id, String name, int age, Addmission addmission, List<Address> address,
			List<Teacher> teacher) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addmission = addmission;
		this.address = address;
		this.teacher = teacher;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	
	@OneToOne
	private Addmission addmission;
	
	@OneToMany
	private List<Address> address;
	
	@ManyToMany
	private List<Teacher> teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public Addmission getAddmission() {
		return addmission;
	}

	public void setAddmission(Addmission addmission) {
		this.addmission = addmission;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}
	
}
