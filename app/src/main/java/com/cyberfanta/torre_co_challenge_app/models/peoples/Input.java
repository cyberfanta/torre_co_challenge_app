package com.cyberfanta.torre_co_challenge_app.models.peoples;

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

	@Override
 	public String toString(){
		return 
			"Input{" + 
			"criteria = '" + criteria + '\'' + 
			",person = '" + person + '\'' + 
			"}";
		}
}
