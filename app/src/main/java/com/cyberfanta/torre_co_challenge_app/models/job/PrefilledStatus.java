package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class PrefilledStatus{

	@SerializedName("status")
	private String status;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"PrefilledStatus{" + 
			"status = '" + status + '\'' + 
			"}";
		}
}