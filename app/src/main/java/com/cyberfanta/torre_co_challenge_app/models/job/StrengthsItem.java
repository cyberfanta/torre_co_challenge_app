package com.cyberfanta.torre_co_challenge_app.models.job;

public class StrengthsItem{
	private int code;
	private String name;
	private String id;
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
