package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class StrengthsItem{

	@SerializedName("code")
	private int code;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("experience")
	private String experience;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setExperience(String experience){
		this.experience = experience;
	}

	public String getExperience(){
		return experience;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"StrengthsItem{" + 
			"code = '" + code + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",experience = '" + experience + '\'' + 
			"}";
		}
}