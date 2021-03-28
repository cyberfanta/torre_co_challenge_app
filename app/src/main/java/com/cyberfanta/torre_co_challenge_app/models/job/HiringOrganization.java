package com.cyberfanta.torre_co_challenge_app.models.job;

public class HiringOrganization{
	private String type;
	private String name;
	private String logo;

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

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	@Override
 	public String toString(){
		return 
			"HiringOrganization{" + 
			"@type = '" + type + '\'' + 
			",name = '" + name + '\'' + 
			",logo = '" + logo + '\'' + 
			"}";
		}
}
