package com.cyberfanta.torre_co_challenge_app.models.job;

public class Language{
	private String code;
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

	@Override
 	public String toString(){
		return 
			"Language{" + 
			"code = '" + code + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}
