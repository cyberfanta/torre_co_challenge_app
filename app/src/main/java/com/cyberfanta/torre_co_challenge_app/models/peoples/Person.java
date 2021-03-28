package com.cyberfanta.torre_co_challenge_app.models.peoples;

public class Person{
	private double grammar;
	private double completion;
	private double weight;

	public void setGrammar(double grammar){
		this.grammar = grammar;
	}

	public double getGrammar(){
		return grammar;
	}

	public void setCompletion(double completion){
		this.completion = completion;
	}

	public double getCompletion(){
		return completion;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	@Override
 	public String toString(){
		return 
			"Person{" + 
			"grammar = '" + grammar + '\'' + 
			",completion = '" + completion + '\'' + 
			",weight = '" + weight + '\'' + 
			"}";
		}
}
