package com.cyberfanta.torre_co_challenge_app.models.job;

public class ApplicantLocationRequirementsItem{
	private String type;
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

	@Override
 	public String toString(){
		return 
			"ApplicantLocationRequirementsItem{" + 
			"@type = '" + type + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}
