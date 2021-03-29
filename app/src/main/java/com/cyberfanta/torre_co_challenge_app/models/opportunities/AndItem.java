package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

public class AndItem{
	private Input input;
	private double score;
	private String type;
	private String id;

	public void setInput(Input input){
		this.input = input;
	}

	public Input getInput(){
		return input;
	}

	public void setScore(double score){
		this.score = score;
	}

	public double getScore(){
		return score;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"AndItem{" + 
			"input = '" + input + '\'' + 
			",score = '" + score + '\'' + 
			",@type = '" + type + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
