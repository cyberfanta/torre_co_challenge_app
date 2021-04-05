package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Person{

	@SerializedName("professionalHeadline")
	private String professionalHeadline;

	@SerializedName("hasEmail")
	private boolean hasEmail;

	@SerializedName("name")
	private String name;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("flags")
	private Flags flags;

	@SerializedName("weight")
	private double weight;

	@SerializedName("hasBio")
	private boolean hasBio;

	@SerializedName("id")
	private String id;

	@SerializedName("pictureThumbnail")
	private String pictureThumbnail;

	@SerializedName("picture")
	private String picture;

	@SerializedName("subjectId")
	private int subjectId;

	@SerializedName("username")
	private String username;

	public void setProfessionalHeadline(String professionalHeadline){
		this.professionalHeadline = professionalHeadline;
	}

	public String getProfessionalHeadline(){
		return professionalHeadline;
	}

	public void setHasEmail(boolean hasEmail){
		this.hasEmail = hasEmail;
	}

	public boolean isHasEmail(){
		return hasEmail;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setVerified(boolean verified){
		this.verified = verified;
	}

	public boolean isVerified(){
		return verified;
	}

	public void setFlags(Flags flags){
		this.flags = flags;
	}

	public Flags getFlags(){
		return flags;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	public void setHasBio(boolean hasBio){
		this.hasBio = hasBio;
	}

	public boolean isHasBio(){
		return hasBio;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPictureThumbnail(String pictureThumbnail){
		this.pictureThumbnail = pictureThumbnail;
	}

	public String getPictureThumbnail(){
		return pictureThumbnail;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	public void setSubjectId(int subjectId){
		this.subjectId = subjectId;
	}

	public int getSubjectId(){
		return subjectId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"Person{" + 
			"professionalHeadline = '" + professionalHeadline + '\'' + 
			",hasEmail = '" + hasEmail + '\'' + 
			",name = '" + name + '\'' + 
			",verified = '" + verified + '\'' + 
			",flags = '" + flags + '\'' + 
			",weight = '" + weight + '\'' + 
			",hasBio = '" + hasBio + '\'' + 
			",id = '" + id + '\'' + 
			",pictureThumbnail = '" + pictureThumbnail + '\'' + 
			",picture = '" + picture + '\'' + 
			",subjectId = '" + subjectId + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}