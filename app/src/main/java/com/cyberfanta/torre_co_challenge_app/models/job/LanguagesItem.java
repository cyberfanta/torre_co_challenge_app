package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class LanguagesItem{

	@SerializedName("fluency")
	private String fluency;

	@SerializedName("language")
	private Language language;

	public void setFluency(String fluency){
		this.fluency = fluency;
	}

	public String getFluency(){
		return fluency;
	}

	public void setLanguage(Language language){
		this.language = language;
	}

	public Language getLanguage(){
		return language;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"LanguagesItem{" + 
			"fluency = '" + fluency + '\'' + 
			",language = '" + language + '\'' + 
			"}";
		}
}