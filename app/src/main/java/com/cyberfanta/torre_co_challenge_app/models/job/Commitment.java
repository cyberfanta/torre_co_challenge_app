package com.cyberfanta.torre_co_challenge_app.models.job;

public class Commitment{
	private int hours;
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

	@Override
 	public String toString(){
		return 
			"Commitment{" + 
			"hours = '" + hours + '\'' + 
			",code = '" + code + '\'' + 
			"}";
		}
}
