package com.cyberfanta.torre_co_challenge_app.models.job;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class SerpTags{

	@SerializedName("identifier")
	private Identifier identifier;

	@SerializedName("validThrough")
	private String validThrough;

	@SerializedName("employmentType")
	private List<String> employmentType;

	@SerializedName("@type")
	private String type;

	@SerializedName("baseSalary")
	private BaseSalary baseSalary;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("@context")
	private String context;

	@SerializedName("jobLocationType")
	private String jobLocationType;

	@SerializedName("experienceInPlaceOfEducation")
	private boolean experienceInPlaceOfEducation;

	@SerializedName("hiringOrganization")
	private HiringOrganization hiringOrganization;

	@SerializedName("educationRequirements")
	private EducationRequirements educationRequirements;

	@SerializedName("datePosted")
	private String datePosted;

	@SerializedName("experienceRequirements")
	private ExperienceRequirements experienceRequirements;

	@SerializedName("applicantLocationRequirements")
	private List<ApplicantLocationRequirementsItem> applicantLocationRequirements;

	public void setIdentifier(Identifier identifier){
		this.identifier = identifier;
	}

	public Identifier getIdentifier(){
		return identifier;
	}

	public void setValidThrough(String validThrough){
		this.validThrough = validThrough;
	}

	public String getValidThrough(){
		return validThrough;
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

	public void setContext(String context){
		this.context = context;
	}

	public String getContext(){
		return context;
	}

	public void setJobLocationType(String jobLocationType){
		this.jobLocationType = jobLocationType;
	}

	public String getJobLocationType(){
		return jobLocationType;
	}

	public void setExperienceInPlaceOfEducation(boolean experienceInPlaceOfEducation){
		this.experienceInPlaceOfEducation = experienceInPlaceOfEducation;
	}

	public boolean isExperienceInPlaceOfEducation(){
		return experienceInPlaceOfEducation;
	}

	public void setHiringOrganization(HiringOrganization hiringOrganization){
		this.hiringOrganization = hiringOrganization;
	}

	public HiringOrganization getHiringOrganization(){
		return hiringOrganization;
	}

	public void setEducationRequirements(EducationRequirements educationRequirements){
		this.educationRequirements = educationRequirements;
	}

	public EducationRequirements getEducationRequirements(){
		return educationRequirements;
	}

	public void setDatePosted(String datePosted){
		this.datePosted = datePosted;
	}

	public String getDatePosted(){
		return datePosted;
	}

	public void setExperienceRequirements(ExperienceRequirements experienceRequirements){
		this.experienceRequirements = experienceRequirements;
	}

	public ExperienceRequirements getExperienceRequirements(){
		return experienceRequirements;
	}

	public void setApplicantLocationRequirements(List<ApplicantLocationRequirementsItem> applicantLocationRequirements){
		this.applicantLocationRequirements = applicantLocationRequirements;
	}

	public List<ApplicantLocationRequirementsItem> getApplicantLocationRequirements(){
		return applicantLocationRequirements;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"SerpTags{" + 
			"identifier = '" + identifier + '\'' + 
			",validThrough = '" + validThrough + '\'' + 
			",employmentType = '" + employmentType + '\'' + 
			",@type = '" + type + '\'' + 
			",baseSalary = '" + baseSalary + '\'' + 
			",description = '" + description + '\'' + 
			",title = '" + title + '\'' + 
			",@context = '" + context + '\'' + 
			",jobLocationType = '" + jobLocationType + '\'' + 
			",experienceInPlaceOfEducation = '" + experienceInPlaceOfEducation + '\'' + 
			",hiringOrganization = '" + hiringOrganization + '\'' + 
			",educationRequirements = '" + educationRequirements + '\'' + 
			",datePosted = '" + datePosted + '\'' + 
			",experienceRequirements = '" + experienceRequirements + '\'' + 
			",applicantLocationRequirements = '" + applicantLocationRequirements + '\'' + 
			"}";
		}
}