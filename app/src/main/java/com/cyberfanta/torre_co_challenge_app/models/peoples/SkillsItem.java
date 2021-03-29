package com.cyberfanta.torre_co_challenge_app.models.peoples;

import org.jetbrains.annotations.NotNull;

public class SkillsItem{
	private String name;
	private double weight;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"SkillsItem{" + 
			"name = '" + name + '\'' + 
			",weight = '" + weight + '\'' + 
			"}";
		}
}
