package com.cyberfanta.torre_co_challenge_app.models.bio;

public class DataItem{
	private int code;
	private String name;
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
