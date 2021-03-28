package com.cyberfanta.torre_co_challenge_app.models.bio;

import java.util.List;

public class InterestsItem{
	private int code;
	private String created;
	private String name;
	private String id;
	private List<Object> media;
	private String additionalInfo;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMedia(List<Object> media){
		this.media = media;
	}

	public List<Object> getMedia(){
		return media;
	}

	public void setAdditionalInfo(String additionalInfo){
		this.additionalInfo = additionalInfo;
	}

	public String getAdditionalInfo(){
		return additionalInfo;
	}

	@Override
 	public String toString(){
		return 
			"InterestsItem{" + 
			"code = '" + code + '\'' + 
			",created = '" + created + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",media = '" + media + '\'' + 
			",additionalInfo = '" + additionalInfo + '\'' + 
			"}";
		}
}