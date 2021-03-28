package com.cyberfanta.torre_co_challenge_app.models.peoples;

import java.util.List;

public class ResultsItem{
	private String professionalHeadline;
	private Compensations compensations;
	private String locationName;
	private List<String> openTo;
	private boolean verified;
	private Meta meta;
	private double weight;
	private String picture;
	private String subjectId;
	private List<SkillsItem> skills;
	private Context context;
	private String name;
	private boolean remoter;
	private String username;

	public void setProfessionalHeadline(String professionalHeadline){
		this.professionalHeadline = professionalHeadline;
	}

	public String getProfessionalHeadline(){
		return professionalHeadline;
	}

	public void setCompensations(Compensations compensations){
		this.compensations = compensations;
	}

	public Compensations getCompensations(){
		return compensations;
	}

	public void setLocationName(String locationName){
		this.locationName = locationName;
	}

	public String getLocationName(){
		return locationName;
	}

	public void setOpenTo(List<String> openTo){
		this.openTo = openTo;
	}

	public List<String> getOpenTo(){
		return openTo;
	}

	public void setVerified(boolean verified){
		this.verified = verified;
	}

	public boolean isVerified(){
		return verified;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	public void setSubjectId(String subjectId){
		this.subjectId = subjectId;
	}

	public String getSubjectId(){
		return subjectId;
	}

	public void setSkills(List<SkillsItem> skills){
		this.skills = skills;
	}

	public List<SkillsItem> getSkills(){
		return skills;
	}

	public void setContext(Context context){
		this.context = context;
	}

	public Context getContext(){
		return context;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRemoter(boolean remoter){
		this.remoter = remoter;
	}

	public boolean isRemoter(){
		return remoter;
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
			"ResultsItem{" + 
			"professionalHeadline = '" + professionalHeadline + '\'' + 
			",compensations = '" + compensations + '\'' + 
			",locationName = '" + locationName + '\'' + 
			",openTo = '" + openTo + '\'' + 
			",verified = '" + verified + '\'' + 
			",_meta = '" + meta + '\'' + 
			",weight = '" + weight + '\'' + 
			",picture = '" + picture + '\'' + 
			",subjectId = '" + subjectId + '\'' + 
			",skills = '" + skills + '\'' + 
			",context = '" + context + '\'' + 
			",name = '" + name + '\'' + 
			",remoter = '" + remoter + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}