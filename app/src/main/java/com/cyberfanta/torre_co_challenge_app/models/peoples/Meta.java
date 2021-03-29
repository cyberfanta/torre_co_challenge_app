package com.cyberfanta.torre_co_challenge_app.models.peoples;

import org.jetbrains.annotations.NotNull;

public class Meta{
	private Object filter;
	private Ranker ranker;

	public void setFilter(Object filter){
		this.filter = filter;
	}

	public Object getFilter(){
		return filter;
	}

	public void setRanker(Ranker ranker){
		this.ranker = ranker;
	}

	public Ranker getRanker(){
		return ranker;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Meta{" + 
			"filter = '" + filter + '\'' + 
			",ranker = '" + ranker + '\'' + 
			"}";
		}
}
