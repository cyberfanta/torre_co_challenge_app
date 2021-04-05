package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Agreement{

	@SerializedName("type")
	private String type;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"Agreement{" + 
			"type = '" + type + '\'' + 
			"}";
		}
}