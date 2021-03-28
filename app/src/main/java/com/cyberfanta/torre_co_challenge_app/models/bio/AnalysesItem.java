package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class AnalysesItem{

	@SerializedName("groupId")
	private String groupId;

	@SerializedName("analysis")
	private double analysis;

	public void setGroupId(String groupId){
		this.groupId = groupId;
	}

	public String getGroupId(){
		return groupId;
	}

	public void setAnalysis(double analysis){
		this.analysis = analysis;
	}

	public double getAnalysis(){
		return analysis;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"AnalysesItem{" + 
			"groupId = '" + groupId + '\'' + 
			",analysis = '" + analysis + '\'' + 
			"}";
		}
}