package com.cyberfanta.torre_co_challenge_app.models.peoples;

import java.util.List;

public class Ranker{
	private Object score;
	private String type;
	private List<AndItem> and;
	private double rank;

	public void setScore(Object score){
		this.score = score;
	}

	public Object getScore(){
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

	public void setRank(double rank){
		this.rank = rank;
	}

	public double getRank(){
		return rank;
	}

	@Override
 	public String toString(){
		return 
			"Ranker{" + 
			"score = '" + score + '\'' + 
			",@type = '" + type + '\'' + 
			",and = '" + and + '\'' + 
			",rank = '" + rank + '\'' + 
			"}";
		}
}