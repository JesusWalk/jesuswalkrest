package com.jesuswalk.entity;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

@Entity("Church")
public class ChurchEntity extends BaseEntity {

	private String name;
	private String seniorPastorFirstName;
	private String seniorPastorLastName;
	private String youthPastorFirstName;
	private String youthPastorLastName;
	
	@Embedded
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeniorPastorFirstName() {
		return seniorPastorFirstName;
	}

	public void setSeniorPastorFirstName(String seniorPastorFirstName) {
		this.seniorPastorFirstName = seniorPastorFirstName;
	}

	public String getSeniorPastorLastName() {
		return seniorPastorLastName;
	}

	public void setSeniorPastorLastName(String seniorPastorLastName) {
		this.seniorPastorLastName = seniorPastorLastName;
	}

	public String getYouthPastorFirstName() {
		return youthPastorFirstName;
	}

	public void setYouthPastorFirstName(String youthPastorFirstName) {
		this.youthPastorFirstName = youthPastorFirstName;
	}

	public String getYouthPastorLastName() {
		return youthPastorLastName;
	}

	public void setYouthPastorLastName(String youthPastorLastName) {
		this.youthPastorLastName = youthPastorLastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
