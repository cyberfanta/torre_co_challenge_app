package com.cyberfanta.torre_co_challenge_app.models.job;

public class Identifier{
	private String type;
	private String name;
	private String value;

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

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Identifier{" + 
			"@type = '" + type + '\'' + 
			",name = '" + name + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}
