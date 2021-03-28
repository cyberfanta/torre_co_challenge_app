package com.cyberfanta.torre_co_challenge_app.models.job;

public class DetailsItem{
	private String code;
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

	@Override
 	public String toString(){
		return 
			"DetailsItem{" + 
			"code = '" + code + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}
