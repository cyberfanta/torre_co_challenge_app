package com.cyberfanta.torre_co_challenge_app.models.bio;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class EducationItem{

	@SerializedName("highlighted")
	private boolean highlighted;

	@SerializedName("weight")
	private float weight;

	@SerializedName("media")
	private List<Object> media;

	@SerializedName("remote")
	private boolean remote;

	@SerializedName("verifications")
	private int verifications;

	@SerializedName("recommendations")
	private int recommendations;

	@SerializedName("responsibilities")
	private List<Object> responsibilities;

	@SerializedName("fromYear")
	private String fromYear;

	@SerializedName("name")
	private String name;

	@SerializedName("organizations")
	private List<OrganizationsItem> organizations;

	@SerializedName("additionalInfo")
	private String additionalInfo;

	@SerializedName("fromMonth")
	private String fromMonth;

	@SerializedName("rank")
	private int rank;

	@SerializedName("id")
	private String id;

	@SerializedName("category")
	private String category;

	public void setHighlighted(boolean highlighted){
		this.highlighted = highlighted;
	}

	public boolean isHighlighted(){
		return highlighted;
	}

	public void setWeight(float weight){
		this.weight = weight;
	}

	public float getWeight(){
		return weight;
	}

	public void setMedia(List<Object> media){
		this.media = media;
	}

	public List<Object> getMedia(){
		return media;
	}

	public void setRemote(boolean remote){
		this.remote = remote;
	}

	public boolean isRemote(){
		return remote;
	}

	public void setVerifications(int verifications){
		this.verifications = verifications;
	}

	public int getVerifications(){
		return verifications;
	}

	public void setRecommendations(int recommendations){
		this.recommendations = recommendations;
	}

	public int getRecommendations(){
		return recommendations;
	}

	public void setResponsibilities(List<Object> responsibilities){
		this.responsibilities = responsibilities;
	}

	public List<Object> getResponsibilities(){
		return responsibilities;
	}

	public void setFromYear(String fromYear){
		this.fromYear = fromYear;
	}

	public String getFromYear(){
		return fromYear;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setOrganizations(List<OrganizationsItem> organizations){
		this.organizations = organizations;
	}

	public List<OrganizationsItem> getOrganizations(){
		return organizations;
	}

	public void setAdditionalInfo(String additionalInfo){
		this.additionalInfo = additionalInfo;
	}

	public String getAdditionalInfo(){
		return additionalInfo;
	}

	public void setFromMonth(String fromMonth){
		this.fromMonth = fromMonth;
	}

	public String getFromMonth(){
		return fromMonth;
	}

	public void setRank(int rank){
		this.rank = rank;
	}

	public int getRank(){
		return rank;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"EducationItem{" + 
			"highlighted = '" + highlighted + '\'' + 
			",weight = '" + weight + '\'' + 
			",media = '" + media + '\'' + 
			",remote = '" + remote + '\'' + 
			",verifications = '" + verifications + '\'' + 
			",recommendations = '" + recommendations + '\'' + 
			",responsibilities = '" + responsibilities + '\'' + 
			",fromYear = '" + fromYear + '\'' + 
			",name = '" + name + '\'' + 
			",organizations = '" + organizations + '\'' + 
			",additionalInfo = '" + additionalInfo + '\'' + 
			",fromMonth = '" + fromMonth + '\'' + 
			",rank = '" + rank + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}