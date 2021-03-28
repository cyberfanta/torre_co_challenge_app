package com.cyberfanta.torre_co_challenge_app.models.bio;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class ProfessionalCultureGenomeResults{

	@SerializedName("analyses")
	private List<AnalysesItem> analyses;

	@SerializedName("groups")
	private List<GroupsItem> groups;

	public void setAnalyses(List<AnalysesItem> analyses){
		this.analyses = analyses;
	}

	public List<AnalysesItem> getAnalyses(){
		return analyses;
	}

	public void setGroups(List<GroupsItem> groups){
		this.groups = groups;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"ProfessionalCultureGenomeResults{" + 
			"analyses = '" + analyses + '\'' + 
			",groups = '" + groups + '\'' + 
			"}";
		}
}