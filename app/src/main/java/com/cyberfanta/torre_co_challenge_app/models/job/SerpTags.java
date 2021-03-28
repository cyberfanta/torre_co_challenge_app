package com.cyberfanta.torre_co_challenge_app.models.job;

import java.util.List;

public class SerpTags{
	private Identifier identifier;
	private String jobLocationType;
	private String validThrough;
	private HiringOrganization hiringOrganization;
	private List<String> employmentType;
	private String type;
	private BaseSalary baseSalary;
	private String description;
	private String title;
	private String datePosted;
	private String context;
	private List<ApplicantLocationRequirementsItem> applicantLocationRequirements;

	public void setIdentifier(Identifier identifier){
		this.identifier = identifier;
	}

	public Identifier getIdentifier(){
		return identifier;
	}

	public void setJobLocationType(String jobLocationType){
		this.jobLocationType = jobLocationType;
	}

	public String getJobLocationType(){
		return jobLocationType;
	}

	public void setValidThrough(String validThrough){
		this.validThrough = validThrough;
	}

	public String getValidThrough(){
		return validThrough;
	}

	public void setHiringOrganization(HiringOrganization hiringOrganization){
		this.hiringOrganization = hiringOrganization;
	}

	public HiringOrganization getHiringOrganization(){
		return hiringOrganization;
	}

	public void setEmploymentType(List<String> employmentType){
		this.employmentType = employmentType;
	}

	public List<String> getEmploymentType(){
		return employmentType;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setBaseSalary(BaseSalary baseSalary){
		this.baseSalary = baseSalary;
	}

	public BaseSalary getBaseSalary(){
		return baseSalary;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDatePosted(String datePosted){
		this.datePosted = datePosted;
	}

	public String getDatePosted(){
		return datePosted;
	}

	public void setContext(String context){
		this.context = context;
	}

	public String getContext(){
		return context;
	}

	public void setApplicantLocationRequirements(List<ApplicantLocationRequirementsItem> applicantLocationRequirements){
		this.applicantLocationRequirements = applicantLocationRequirements;
	}

	public List<ApplicantLocationRequirementsItem> getApplicantLocationRequirements(){
		return applicantLocationRequirements;
	}

	@Override
 	public String toString(){
		return 
			"SerpTags{" + 
			"identifier = '" + identifier + '\'' + 
			",jobLocationType = '" + jobLocationType + '\'' + 
			",validThrough = '" + validThrough + '\'' + 
			",hiringOrganization = '" + hiringOrganization + '\'' + 
			",employmentType = '" + employmentType + '\'' + 
			",@type = '" + type + '\'' + 
			",baseSalary = '" + baseSalary + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",datePosted = '" + datePosted + '\'' + 
			",@context = '" + context + '\'' + 
			",applicantLocationRequirements = '" + applicantLocationRequirements + '\'' + 
			"}";
		}
}