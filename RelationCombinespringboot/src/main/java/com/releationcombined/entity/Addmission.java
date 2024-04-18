package com.releationcombined.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addmission")
public class Addmission {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	private int roll_number;
	
	private int fee;

	public Addmission(int id, int roll_number, int fee) {
		super();
		this.id = id;
		this.roll_number = roll_number;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(int roll_number) {
		this.roll_number = roll_number;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Addmission() {
		super();
	}

}
