package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Language{

	@SerializedName("code")
	private String code;

	@SerializedName("name")
	private String name;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
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
			"Language{" + 
			"code = '" + code + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}