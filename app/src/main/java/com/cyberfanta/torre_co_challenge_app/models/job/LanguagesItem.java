package com.cyberfanta.torre_co_challenge_app.models.job;

public class LanguagesItem{
	private String fluency;
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
 	public String toString(){
		return 
			"LanguagesItem{" + 
			"fluency = '" + fluency + '\'' + 
			",language = '" + language + '\'' + 
			"}";
		}
}
