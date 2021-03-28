package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class DetailsItem{

	@SerializedName("code")
	private String code;

	@SerializedName("content")
	private String content;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"DetailsItem{" + 
			"code = '" + code + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}