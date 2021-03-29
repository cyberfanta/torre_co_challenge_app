package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

public class SkillsItem{
	private String name;
	private String experience;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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
			"SkillsItem{" + 
			"name = '" + name + '\'' + 
			",experience = '" + experience + '\'' + 
			"}";
		}
}
