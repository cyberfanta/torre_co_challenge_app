package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class GroupsItem{

	@SerializedName("median")
	private double median;

	@SerializedName("id")
	private String id;

	@SerializedName("stddev")
	private double stddev;

	@SerializedName("order")
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

	@NotNull
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