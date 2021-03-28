package com.cyberfanta.torre_co_challenge_app.models.opportunities;

public class Opportunity{
	private double completion;

	public void setCompletion(double completion){
		this.completion = completion;
	}

	public double getCompletion(){
		return completion;
	}

	@Override
 	public String toString(){
		return 
			"Opportunity{" + 
			"completion = '" + completion + '\'' + 
			"}";
		}
}
