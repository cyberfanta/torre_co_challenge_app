package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Commitment{

	@SerializedName("hours")
	private int hours;

	@SerializedName("code")
	private String code;

	public void setHours(int hours){
		this.hours = hours;
	}

	public int getHours(){
		return hours;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"Commitment{" + 
			"hours = '" + hours + '\'' + 
			",code = '" + code + '\'' + 
			"}";
		}
}