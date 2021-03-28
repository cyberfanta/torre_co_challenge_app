package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class ApplicantLocationRequirementsItem{

	@SerializedName("@type")
	private String type;

	@SerializedName("name")
	private String name;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"ApplicantLocationRequirementsItem{" + 
			"@type = '" + type + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}