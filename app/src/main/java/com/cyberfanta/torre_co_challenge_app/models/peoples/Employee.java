package com.cyberfanta.torre_co_challenge_app.models.peoples;

import org.jetbrains.annotations.NotNull;

public class Employee{
	private double amount;
	private String periodicity;
	private String currency;

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setPeriodicity(String periodicity){
		this.periodicity = periodicity;
	}

	public String getPeriodicity(){
		return periodicity;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Employee{" + 
			"amount = '" + amount + '\'' + 
			",periodicity = '" + periodicity + '\'' + 
			",currency = '" + currency + '\'' + 
			"}";
		}
}
