package com.cyberfanta.torre_co_challenge_app.models.peoples;

import org.jetbrains.annotations.NotNull;

public class AndItem{
	private Object score;
	private Input input;
	private String scorer;
	private String type;
	private double rank;

	public void setScore(Object score){
		this.score = score;
	}

	public Object getScore(){
		return score;
	}

	public void setInput(Input input){
		this.input = input;
	}

	public Input getInput(){
		return input;
	}

	public void setScorer(String scorer){
		this.scorer = scorer;
	}

	public String getScorer(){
		return scorer;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setRank(double rank){
		this.rank = rank;
	}

	public double getRank(){
		return rank;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"AndItem{" + 
			"score = '" + score + '\'' + 
			",input = '" + input + '\'' + 
			",scorer = '" + scorer + '\'' + 
			",@type = '" + type + '\'' + 
			",rank = '" + rank + '\'' + 
			"}";
		}
}
