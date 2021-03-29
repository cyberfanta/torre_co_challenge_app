package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ResultsItem{
	private String created;
	private List<Object> questions;
	private Meta meta;
	private String type;
	private boolean remote;
	private String objective;
	private List<SkillsItem> skills;
	private boolean external;
	private List<MembersItem> members;
	private List<OrganizationsItem> organizations;
	private Context context;
	private List<String> locations;
	private Compensation compensation;
	private String id;
	private String deadline;
	private String status;

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setQuestions(List<Object> questions){
		this.questions = questions;
	}

	public List<Object> getQuestions(){
		return questions;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setRemote(boolean remote){
		this.remote = remote;
	}

	public boolean isRemote(){
		return remote;
	}

	public void setObjective(String objective){
		this.objective = objective;
	}

	public String getObjective(){
		return objective;
	}

	public void setSkills(List<SkillsItem> skills){
		this.skills = skills;
	}

	public List<SkillsItem> getSkills(){
		return skills;
	}

	public void setExternal(boolean external){
		this.external = external;
	}

	public boolean isExternal(){
		return external;
	}

	public void setMembers(List<MembersItem> members){
		this.members = members;
	}

	public List<MembersItem> getMembers(){
		return members;
	}

	public void setOrganizations(List<OrganizationsItem> organizations){
		this.organizations = organizations;
	}

	public List<OrganizationsItem> getOrganizations(){
		return organizations;
	}

	public void setContext(Context context){
		this.context = context;
	}

	public Context getContext(){
		return context;
	}

	public void setLocations(List<String> locations){
		this.locations = locations;
	}

	public List<String> getLocations(){
		return locations;
	}

	public void setCompensation(Compensation compensation){
		this.compensation = compensation;
	}

	public Compensation getCompensation(){
		return compensation;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setDeadline(String deadline){
		this.deadline = deadline;
	}

	public String getDeadline(){
		return deadline;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"created = '" + created + '\'' + 
			",questions = '" + questions + '\'' + 
			",_meta = '" + meta + '\'' + 
			",type = '" + type + '\'' + 
			",remote = '" + remote + '\'' + 
			",objective = '" + objective + '\'' + 
			",skills = '" + skills + '\'' + 
			",external = '" + external + '\'' + 
			",members = '" + members + '\'' + 
			",organizations = '" + organizations + '\'' + 
			",context = '" + context + '\'' + 
			",locations = '" + locations + '\'' + 
			",compensation = '" + compensation + '\'' + 
			",id = '" + id + '\'' + 
			",deadline = '" + deadline + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}