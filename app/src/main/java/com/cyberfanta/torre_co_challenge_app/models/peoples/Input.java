package com.cyberfanta.torre_co_challenge_app.models.peoples;

import org.jetbrains.annotations.NotNull;

public class Input{
	private Object criteria;
	private Person person;

	public void setCriteria(Object criteria){
		this.criteria = criteria;
	}

	public Object getCriteria(){
		return criteria;
	}

	public void setPerson(Person person){
		this.person = person;
	}

	public Person getPerson(){
		return person;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Input{" + 
			"criteria = '" + criteria + '\'' + 
			",person = '" + person + '\'' + 
			"}";
		}
}
