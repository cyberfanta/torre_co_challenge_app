package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Stats{

	@SerializedName("finishedApplications")
	private int finishedApplications;

	public void setFinishedApplications(int finishedApplications){
		this.finishedApplications = finishedApplications;
	}

	public int getFinishedApplications(){
		return finishedApplications;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"Stats{" + 
			"finishedApplications = '" + finishedApplications + '\'' + 
			"}";
		}
}