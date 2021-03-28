package com.cyberfanta.torre_co_challenge_app.models.bio;

public class GroupsItem{
	private double median;
	private String id;
	private double stddev;
	private int order;

	public void setMedian(double median){
		this.median = median;
	}

	public double getMedian(){
		return median;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStddev(double stddev){
		this.stddev = stddev;
	}

	public double getStddev(){
		return stddev;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public int getOrder(){
		return order;
	}

	@Override
 	public String toString(){
		return 
			"GroupsItem{" + 
			"median = '" + median + '\'' + 
			",id = '" + id + '\'' + 
			",stddev = '" + stddev + '\'' + 
			",order = '" + order + '\'' + 
			"}";
		}
}
