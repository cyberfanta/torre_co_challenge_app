package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class LanguagesItem{

	@SerializedName("code")
	private String code;

	@SerializedName("fluency")
	private String fluency;

	@SerializedName("language")
	private String language;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setFluency(String fluency){
		this.fluency = fluency;
	}

	public String getFluency(){
		return fluency;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"LanguagesItem{" + 
			"code = '" + code + '\'' + 
			",fluency = '" + fluency + '\'' + 
			",language = '" + language + '\'' + 
			"}";
		}
}