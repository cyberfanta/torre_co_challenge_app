package com.cyberfanta.torre_co_challenge_app.models.job;

public class Owner{
	private String professionalHeadline;
	private boolean hasEmail;
	private String name;
	private boolean verified;
	private int weight;
	private boolean hasBio;
	private String id;
	private String pictureThumbnail;
	private String picture;
	private int subjectId;
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

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
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
 	public String toString(){
		return 
			"Owner{" + 
			"professionalHeadline = '" + professionalHeadline + '\'' + 
			",hasEmail = '" + hasEmail + '\'' + 
			",name = '" + name + '\'' + 
			",verified = '" + verified + '\'' + 
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
