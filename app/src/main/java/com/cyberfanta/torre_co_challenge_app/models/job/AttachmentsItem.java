package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class AttachmentsItem{

	@SerializedName("path")
	private String path;

	@SerializedName("address")
	private String address;

	@SerializedName("resource")
	private String resource;

	@SerializedName("caption")
	private String caption;

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setResource(String resource){
		this.resource = resource;
	}

	public String getResource(){
		return resource;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"AttachmentsItem{" + 
			"path = '" + path + '\'' + 
			",address = '" + address + '\'' + 
			",resource = '" + resource + '\'' + 
			",caption = '" + caption + '\'' + 
			"}";
		}
}