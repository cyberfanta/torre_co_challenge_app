package com.cyberfanta.torre_co_challenge_app.models.bio;

public class AnalysesItem{
	private String groupId;
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

	@Override
 	public String toString(){
		return 
			"AnalysesItem{" + 
			"groupId = '" + groupId + '\'' + 
			",analysis = '" + analysis + '\'' + 
			"}";
		}
}
