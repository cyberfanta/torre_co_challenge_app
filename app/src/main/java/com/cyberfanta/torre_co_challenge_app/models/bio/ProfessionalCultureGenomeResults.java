package com.cyberfanta.torre_co_challenge_app.models.bio;

import java.util.List;

public class ProfessionalCultureGenomeResults{
	private List<AnalysesItem> analyses;
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

	@Override
 	public String toString(){
		return 
			"ProfessionalCultureGenomeResults{" + 
			"analyses = '" + analyses + '\'' + 
			",groups = '" + groups + '\'' + 
			"}";
		}
}