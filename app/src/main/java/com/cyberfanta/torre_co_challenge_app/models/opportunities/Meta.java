package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import java.util.List;

public class Meta{
	private Object filter;
	private Scorer scorer;
	private List<String> boosters;
	private double rank;

	public void setFilter(Object filter){
		this.filter = filter;
	}

	public Object getFilter(){
		return filter;
	}

	public void setScorer(Scorer scorer){
		this.scorer = scorer;
	}

	public Scorer getScorer(){
		return scorer;
	}

	public void setBoosters(List<String> boosters){
		this.boosters = boosters;
	}

	public List<String> getBoosters(){
		return boosters;
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
			"Meta{" + 
			"filter = '" + filter + '\'' + 
			",scorer = '" + scorer + '\'' + 
			",boosters = '" + boosters + '\'' + 
			",rank = '" + rank + '\'' + 
			"}";
		}
}