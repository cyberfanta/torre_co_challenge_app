package com.cyberfanta.torre_co_challenge_app.models.opportunities;

public class OrganizationsItem{
	private String name;
	private int id;
	private String picture;

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

	@Override
 	public String toString(){
		return 
			"OrganizationsItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",picture = '" + picture + '\'' + 
			"}";
		}
}
