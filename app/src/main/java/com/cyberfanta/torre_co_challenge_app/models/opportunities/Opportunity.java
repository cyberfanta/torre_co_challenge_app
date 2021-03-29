package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

public class Opportunity{
	private double completion;

	public void setCompletion(double completion){
		this.completion = completion;
	}

	public double getCompletion(){
		return completion;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Opportunity{" + 
			"completion = '" + completion + '\'' + 
			"}";
		}
}
