package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class OrganizationsItem{

	@SerializedName("size")
	private int size;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("picture")
	private String picture;

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"OrganizationsItem{" + 
			"size = '" + size + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",picture = '" + picture + '\'' + 
			"}";
		}
}