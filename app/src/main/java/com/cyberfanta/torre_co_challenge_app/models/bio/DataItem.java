package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class DataItem{

	@SerializedName("code")
	private int code;

	@SerializedName("name")
	private String name;

	@SerializedName("locale")
	private String locale;

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

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"code = '" + code + '\'' + 
			",name = '" + name + '\'' + 
			",locale = '" + locale + '\'' + 
			"}";
		}
}