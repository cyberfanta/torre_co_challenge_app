package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

public class MembersItem{
	private String professionalHeadline;
	private boolean manager;
	private String name;
	private boolean member;
	private double weight;
	private boolean poster;
	private String subjectId;
	private String picture;
	private String username;

	public void setProfessionalHeadline(String professionalHeadline){
		this.professionalHeadline = professionalHeadline;
	}

	public String getProfessionalHeadline(){
		return professionalHeadline;
	}

	public void setManager(boolean manager){
		this.manager = manager;
	}

	public boolean isManager(){
		return manager;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMember(boolean member){
		this.member = member;
	}

	public boolean isMember(){
		return member;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	public void setPoster(boolean poster){
		this.poster = poster;
	}

	public boolean isPoster(){
		return poster;
	}

	public void setSubjectId(String subjectId){
		this.subjectId = subjectId;
	}

	public String getSubjectId(){
		return subjectId;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"MembersItem{" + 
			"professionalHeadline = '" + professionalHeadline + '\'' + 
			",manager = '" + manager + '\'' + 
			",name = '" + name + '\'' + 
			",member = '" + member + '\'' + 
			",weight = '" + weight + '\'' + 
			",poster = '" + poster + '\'' + 
			",subjectId = '" + subjectId + '\'' + 
			",picture = '" + picture + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
