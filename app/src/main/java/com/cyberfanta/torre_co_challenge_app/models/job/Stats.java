package com.cyberfanta.torre_co_challenge_app.models.job;

public class Stats{
	private int finishedApplications;

	public void setFinishedApplications(int finishedApplications){
		this.finishedApplications = finishedApplications;
	}

	public int getFinishedApplications(){
		return finishedApplications;
	}

	@Override
 	public String toString(){
		return 
			"Stats{" + 
			"finishedApplications = '" + finishedApplications + '\'' + 
			"}";
		}
}
