package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

public class QuestionsItem{
	private String date;
	private String id;
	private String text;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"QuestionsItem{" + 
			"date = '" + date + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}
