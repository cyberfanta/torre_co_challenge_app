package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

public class Input{
	private Object criteria;
	private Opportunity opportunity;

	public void setCriteria(Object criteria){
		this.criteria = criteria;
	}

	public Object getCriteria(){
		return criteria;
	}

	public void setOpportunity(Opportunity opportunity){
		this.opportunity = opportunity;
	}

	public Opportunity getOpportunity(){
		return opportunity;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Input{" + 
			"criteria = '" + criteria + '\'' + 
			",opportunity = '" + opportunity + '\'' + 
			"}";
		}
}
