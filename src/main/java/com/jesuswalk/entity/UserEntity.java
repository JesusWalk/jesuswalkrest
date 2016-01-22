package com.jesuswalk.entity;

import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

public abstract class UserEntity extends BaseEntity {

	protected String firstName;
	protected String lastName;
	protected int age;
	protected Date birthdate;
	protected String sex;
	protected Date registerDate;
	protected String shirtSize;
	protected String dormNumber;
	protected String dormKey;
	
	@Embedded
	protected Profile profile;
	
	@Embedded
	protected Address address;
	
	@Reference
	protected ChurchEntity church;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getShirtSize() {
		return shirtSize;
	}

	public void setShirtSize(String shirtSize) {
		this.shirtSize = shirtSize;
	}

	public String getDormNumber() {
		return dormNumber;
	}

	public void setDormNumber(String dormNumber) {
		this.dormNumber = dormNumber;
	}

	public String getDormKey() {
		return dormKey;
	}

	public void setDormKey(String dormKey) {
		this.dormKey = dormKey;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ChurchEntity getChurch() {
		return church;
	}

	public void setChurch(ChurchEntity church) {
		this.church = church;
	}
	
}
