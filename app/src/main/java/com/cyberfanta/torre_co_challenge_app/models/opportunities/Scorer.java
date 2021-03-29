package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Scorer{
	private double score;
	private String type;
	private List<AndItem> and;

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

	public void setAnd(List<AndItem> and){
		this.and = and;
	}

	public List<AndItem> getAnd(){
		return and;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Scorer{" + 
			"score = '" + score + '\'' + 
			",@type = '" + type + '\'' + 
			",and = '" + and + '\'' + 
			"}";
		}
}