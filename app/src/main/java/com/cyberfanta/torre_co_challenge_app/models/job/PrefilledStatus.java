package com.cyberfanta.torre_co_challenge_app.models.job;

public class PrefilledStatus{
	private String status;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"PrefilledStatus{" + 
			"status = '" + status + '\'' + 
			"}";
		}
}
