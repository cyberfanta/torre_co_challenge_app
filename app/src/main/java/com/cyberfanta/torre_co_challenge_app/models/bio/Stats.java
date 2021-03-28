package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Stats{

	@SerializedName("education")
	private int education;

	@SerializedName("projects")
	private int projects;

	@SerializedName("strengths")
	private int strengths;

	@SerializedName("jobs")
	private int jobs;

	@SerializedName("interests")
	private int interests;

	@SerializedName("publications")
	private int publications;

	public void setEducation(int education){
		this.education = education;
	}

	public int getEducation(){
		return education;
	}

	public void setProjects(int projects){
		this.projects = projects;
	}

	public int getProjects(){
		return projects;
	}

	public void setStrengths(int strengths){
		this.strengths = strengths;
	}

	public int getStrengths(){
		return strengths;
	}

	public void setJobs(int jobs){
		this.jobs = jobs;
	}

	public int getJobs(){
		return jobs;
	}

	public void setInterests(int interests){
		this.interests = interests;
	}

	public int getInterests(){
		return interests;
	}

	public void setPublications(int publications){
		this.publications = publications;
	}

	public int getPublications(){
		return publications;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"Stats{" + 
			"education = '" + education + '\'' + 
			",projects = '" + projects + '\'' + 
			",strengths = '" + strengths + '\'' + 
			",jobs = '" + jobs + '\'' + 
			",interests = '" + interests + '\'' + 
			",publications = '" + publications + '\'' + 
			"}";
		}
}