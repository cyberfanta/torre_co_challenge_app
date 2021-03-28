package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class ExperienceRequirements{

	@SerializedName("@type")
	private String type;

	@SerializedName("monthsOfExperience")
	private int monthsOfExperience;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setMonthsOfExperience(int monthsOfExperience){
		this.monthsOfExperience = monthsOfExperience;
	}

	public int getMonthsOfExperience(){
		return monthsOfExperience;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"ExperienceRequirements{" + 
			"@type = '" + type + '\'' + 
			",monthsOfExperience = '" + monthsOfExperience + '\'' + 
			"}";
		}
}