package com.cyberfanta.torre_co_challenge_app.models.bio;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class StrengthsItem{

	@SerializedName("code")
	private int code;

	@SerializedName("created")
	private String created;

	@SerializedName("name")
	private String name;

	@SerializedName("weight")
	private int weight;

	@SerializedName("id")
	private String id;

	@SerializedName("media")
	private List<Object> media;

	@SerializedName("recommendations")
	private int recommendations;

	@SerializedName("additionalInfo")
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

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
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

	public void setRecommendations(int recommendations){
		this.recommendations = recommendations;
	}

	public int getRecommendations(){
		return recommendations;
	}

	public void setAdditionalInfo(String additionalInfo){
		this.additionalInfo = additionalInfo;
	}

	public String getAdditionalInfo(){
		return additionalInfo;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"StrengthsItem{" + 
			"code = '" + code + '\'' + 
			",created = '" + created + '\'' + 
			",name = '" + name + '\'' + 
			",weight = '" + weight + '\'' + 
			",id = '" + id + '\'' + 
			",media = '" + media + '\'' + 
			",recommendations = '" + recommendations + '\'' + 
			",additionalInfo = '" + additionalInfo + '\'' + 
			"}";
		}
}