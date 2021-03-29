package com.cyberfanta.torre_co_challenge_app.models.peoples;

import org.jetbrains.annotations.NotNull;

public class Compensations{
	private Intern intern;
	private Employee employee;
	private Freelancer freelancer;

	public void setIntern(Intern intern){
		this.intern = intern;
	}

	public Intern getIntern(){
		return intern;
	}

	public void setEmployee(Employee employee){
		this.employee = employee;
	}

	public Employee getEmployee(){
		return employee;
	}

	public void setFreelancer(Freelancer freelancer){
		this.freelancer = freelancer;
	}

	public Freelancer getFreelancer(){
		return freelancer;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Compensations{" + 
			"intern = '" + intern + '\'' + 
			",employee = '" + employee + '\'' + 
			",freelancer = '" + freelancer + '\'' + 
			"}";
		}
}
