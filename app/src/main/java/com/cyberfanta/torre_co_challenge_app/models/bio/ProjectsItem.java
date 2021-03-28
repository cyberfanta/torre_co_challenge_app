package com.cyberfanta.torre_co_challenge_app.models.bio;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class ProjectsItem{

	@SerializedName("toYear")
	private String toYear;

	@SerializedName("highlighted")
	private boolean highlighted;

	@SerializedName("toMonth")
	private String toMonth;

	@SerializedName("weight")
	private int weight;

	@SerializedName("media")
	private List<Object> media;

	@SerializedName("remote")
	private boolean remote;

	@SerializedName("verifications")
	private int verifications;

	@SerializedName("recommendations")
	private int recommendations;

	@SerializedName("contributions")
	private String contributions;

	@SerializedName("responsibilities")
	private List<String> responsibilities;

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

	public void setToYear(String toYear){
		this.toYear = toYear;
	}

	public String getToYear(){
		return toYear;
	}

	public void setHighlighted(boolean highlighted){
		this.highlighted = highlighted;
	}

	public boolean isHighlighted(){
		return highlighted;
	}

	public void setToMonth(String toMonth){
		this.toMonth = toMonth;
	}

	public String getToMonth(){
		return toMonth;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
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

	public void setContributions(String contributions){
		this.contributions = contributions;
	}

	public String getContributions(){
		return contributions;
	}

	public void setResponsibilities(List<String> responsibilities){
		this.responsibilities = responsibilities;
	}

	public List<String> getResponsibilities(){
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
			"ProjectsItem{" + 
			"toYear = '" + toYear + '\'' + 
			",highlighted = '" + highlighted + '\'' + 
			",toMonth = '" + toMonth + '\'' + 
			",weight = '" + weight + '\'' + 
			",media = '" + media + '\'' + 
			",remote = '" + remote + '\'' + 
			",verifications = '" + verifications + '\'' + 
			",recommendations = '" + recommendations + '\'' + 
			",contributions = '" + contributions + '\'' + 
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