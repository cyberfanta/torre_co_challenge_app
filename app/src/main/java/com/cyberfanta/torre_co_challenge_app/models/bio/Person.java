package com.cyberfanta.torre_co_challenge_app.models.bio;

import java.util.List;

public class Person{
	private String professionalHeadline;
	private int completion;
	private boolean showPhone;
	private String created;
	private boolean verified;
	private Flags flags;
	private int weight;
	private String locale;
	private int subjectId;
	private String picture;
	private boolean hasEmail;
	private boolean isTest;
	private String name;
	private List<LinksItem> links;
	private Location location;
	private String theme;
	private String id;
	private String pictureThumbnail;
	private boolean claimant;
	private String summaryOfBio;
	private String weightGraph;
	private String publicId;

	public void setProfessionalHeadline(String professionalHeadline){
		this.professionalHeadline = professionalHeadline;
	}

	public String getProfessionalHeadline(){
		return professionalHeadline;
	}

	public void setCompletion(int completion){
		this.completion = completion;
	}

	public int getCompletion(){
		return completion;
	}

	public void setShowPhone(boolean showPhone){
		this.showPhone = showPhone;
	}

	public boolean isShowPhone(){
		return showPhone;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
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

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setSubjectId(int subjectId){
		this.subjectId = subjectId;
	}

	public int getSubjectId(){
		return subjectId;
	}

	public void setPicture(String picture){
		this.picture = picture;
	}

	public String getPicture(){
		return picture;
	}

	public void setHasEmail(boolean hasEmail){
		this.hasEmail = hasEmail;
	}

	public boolean isHasEmail(){
		return hasEmail;
	}

	public void setIsTest(boolean isTest){
		this.isTest = isTest;
	}

	public boolean isIsTest(){
		return isTest;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLinks(List<LinksItem> links){
		this.links = links;
	}

	public List<LinksItem> getLinks(){
		return links;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setTheme(String theme){
		this.theme = theme;
	}

	public String getTheme(){
		return theme;
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

	public void setClaimant(boolean claimant){
		this.claimant = claimant;
	}

	public boolean isClaimant(){
		return claimant;
	}

	public void setSummaryOfBio(String summaryOfBio){
		this.summaryOfBio = summaryOfBio;
	}

	public String getSummaryOfBio(){
		return summaryOfBio;
	}

	public void setWeightGraph(String weightGraph){
		this.weightGraph = weightGraph;
	}

	public String getWeightGraph(){
		return weightGraph;
	}

	public void setPublicId(String publicId){
		this.publicId = publicId;
	}

	public String getPublicId(){
		return publicId;
	}

	@Override
 	public String toString(){
		return 
			"Person{" + 
			"professionalHeadline = '" + professionalHeadline + '\'' + 
			",completion = '" + completion + '\'' + 
			",showPhone = '" + showPhone + '\'' + 
			",created = '" + created + '\'' + 
			",verified = '" + verified + '\'' + 
			",flags = '" + flags + '\'' + 
			",weight = '" + weight + '\'' + 
			",locale = '" + locale + '\'' + 
			",subjectId = '" + subjectId + '\'' + 
			",picture = '" + picture + '\'' + 
			",hasEmail = '" + hasEmail + '\'' + 
			",isTest = '" + isTest + '\'' + 
			",name = '" + name + '\'' + 
			",links = '" + links + '\'' + 
			",location = '" + location + '\'' + 
			",theme = '" + theme + '\'' + 
			",id = '" + id + '\'' + 
			",pictureThumbnail = '" + pictureThumbnail + '\'' + 
			",claimant = '" + claimant + '\'' + 
			",summaryOfBio = '" + summaryOfBio + '\'' + 
			",weightGraph = '" + weightGraph + '\'' + 
			",publicId = '" + publicId + '\'' + 
			"}";
		}
}