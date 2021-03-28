package com.cyberfanta.torre_co_challenge_app.models.peoples;

import java.util.List;

public class Peoples{
	private Aggregators aggregators;
	private int total;
	private int offset;
	private int size;
	private List<ResultsItem> results;

	public void setAggregators(Aggregators aggregators){
		this.aggregators = aggregators;
	}

	public Aggregators getAggregators(){
		return aggregators;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"Peoples{" + 
			"aggregators = '" + aggregators + '\'' + 
			",total = '" + total + '\'' + 
			",offset = '" + offset + '\'' + 
			",size = '" + size + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}