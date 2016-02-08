package com.jesuswalk.entity;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;

@Entity("Income")
public class IncomeEntity extends BaseEntity {
	
	private String incomeType;
	private Date dateReceived;
	private String incomeDescription;
	private double amount;
	private Date depositDate;
	private String notes;
	
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}
	public String getIncomeDescription() {
		return incomeDescription;
	}
	public void setIncomeDescription(String incomeDescription) {
		this.incomeDescription = incomeDescription;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDepositDate() {
		return depositDate;
	}
	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
