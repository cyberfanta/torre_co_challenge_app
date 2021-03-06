package com.cyberfanta.torre_co_challenge_app.models.job;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Job{

	@SerializedName("attachments")
	private List<AttachmentsItem> attachments;

	@SerializedName("boardVersion")
	private int boardVersion;

	@SerializedName("prefilledStatus")
	private PrefilledStatus prefilledStatus;

	@SerializedName("locale")
	private String locale;

	@SerializedName("objective")
	private String objective;

	@SerializedName("stats")
	private Stats stats;

	@SerializedName("review")
	private String review;

	@SerializedName("draft")
	private Object draft;

	@SerializedName("members")
	private List<MembersItem> members;

	@SerializedName("details")
	private List<DetailsItem> details;

	@SerializedName("id")
	private String id;

	@SerializedName("place")
	private Place place;

	@SerializedName("deadline")
	private String deadline;

	@SerializedName("slug")
	private String slug;

	@SerializedName("serpTags")
	private SerpTags serpTags;

	@SerializedName("owner")
	private Owner owner;

	@SerializedName("completion")
	private double completion;

	@SerializedName("agreement")
	private Agreement agreement;

	@SerializedName("languages")
	private List<LanguagesItem> languages;

	@SerializedName("created")
	private String created;

	@SerializedName("crawled")
	private boolean crawled;

	@SerializedName("opportunity")
	private String opportunity;

	@SerializedName("active")
	private boolean active;

	@SerializedName("commitment")
	private Commitment commitment;

	@SerializedName("stableOn")
	private String stableOn;

	@SerializedName("strengths")
	private List<StrengthsItem> strengths;

	@SerializedName("organizations")
	private List<OrganizationsItem> organizations;

	@SerializedName("compensation")
	private Compensation compensation;

	@SerializedName("openGraph")
	private String openGraph;

	@SerializedName("status")
	private String status;

	public void setAttachments(List<AttachmentsItem> attachments){
		this.attachments = attachments;
	}

	public List<AttachmentsItem> getAttachments(){
		return attachments;
	}

	public void setBoardVersion(int boardVersion){
		this.boardVersion = boardVersion;
	}

	public int getBoardVersion(){
		return boardVersion;
	}

	public void setPrefilledStatus(PrefilledStatus prefilledStatus){
		this.prefilledStatus = prefilledStatus;
	}

	public PrefilledStatus getPrefilledStatus(){
		return prefilledStatus;
	}

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setObjective(String objective){
		this.objective = objective;
	}

	public String getObjective(){
		return objective;
	}

	public void setStats(Stats stats){
		this.stats = stats;
	}

	public Stats getStats(){
		return stats;
	}

	public void setReview(String review){
		this.review = review;
	}

	public String getReview(){
		return review;
	}

	public void setDraft(Object draft){
		this.draft = draft;
	}

	public Object getDraft(){
		return draft;
	}

	public void setMembers(List<MembersItem> members){
		this.members = members;
	}

	public List<MembersItem> getMembers(){
		return members;
	}

	public void setDetails(List<DetailsItem> details){
		this.details = details;
	}

	public List<DetailsItem> getDetails(){
		return details;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPlace(Place place){
		this.place = place;
	}

	public Place getPlace(){
		return place;
	}

	public void setDeadline(String deadline){
		this.deadline = deadline;
	}

	public String getDeadline(){
		return deadline;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setSerpTags(SerpTags serpTags){
		this.serpTags = serpTags;
	}

	public SerpTags getSerpTags(){
		return serpTags;
	}

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}

	public void setCompletion(double completion){
		this.completion = completion;
	}

	public double getCompletion(){
		return completion;
	}

	public void setAgreement(Agreement agreement){
		this.agreement = agreement;
	}

	public Agreement getAgreement(){
		return agreement;
	}

	public void setLanguages(List<LanguagesItem> languages){
		this.languages = languages;
	}

	public List<LanguagesItem> getLanguages(){
		return languages;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setCrawled(boolean crawled){
		this.crawled = crawled;
	}

	public boolean isCrawled(){
		return crawled;
	}

	public void setOpportunity(String opportunity){
		this.opportunity = opportunity;
	}

	public String getOpportunity(){
		return opportunity;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setCommitment(Commitment commitment){
		this.commitment = commitment;
	}

	public Commitment getCommitment(){
		return commitment;
	}

	public void setStableOn(String stableOn){
		this.stableOn = stableOn;
	}

	public String getStableOn(){
		return stableOn;
	}

	public void setStrengths(List<StrengthsItem> strengths){
		this.strengths = strengths;
	}

	public List<StrengthsItem> getStrengths(){
		return strengths;
	}

	public void setOrganizations(List<OrganizationsItem> organizations){
		this.organizations = organizations;
	}

	public List<OrganizationsItem> getOrganizations(){
		return organizations;
	}

	public void setCompensation(Compensation compensation){
		this.compensation = compensation;
	}

	public Compensation getCompensation(){
		return compensation;
	}

	public void setOpenGraph(String openGraph){
		this.openGraph = openGraph;
	}

	public String getOpenGraph(){
		return openGraph;
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
			"Job{" + 
			"attachments = '" + attachments + '\'' + 
			",boardVersion = '" + boardVersion + '\'' + 
			",prefilledStatus = '" + prefilledStatus + '\'' + 
			",locale = '" + locale + '\'' + 
			",objective = '" + objective + '\'' + 
			",stats = '" + stats + '\'' + 
			",review = '" + review + '\'' + 
			",draft = '" + draft + '\'' + 
			",members = '" + members + '\'' + 
			",details = '" + details + '\'' + 
			",id = '" + id + '\'' + 
			",place = '" + place + '\'' + 
			",deadline = '" + deadline + '\'' + 
			",slug = '" + slug + '\'' + 
			",serpTags = '" + serpTags + '\'' + 
			",owner = '" + owner + '\'' + 
			",completion = '" + completion + '\'' + 
			",agreement = '" + agreement + '\'' + 
			",languages = '" + languages + '\'' + 
			",created = '" + created + '\'' + 
			",crawled = '" + crawled + '\'' + 
			",opportunity = '" + opportunity + '\'' + 
			",active = '" + active + '\'' + 
			",commitment = '" + commitment + '\'' + 
			",stableOn = '" + stableOn + '\'' + 
			",strengths = '" + strengths + '\'' + 
			",organizations = '" + organizations + '\'' + 
			",compensation = '" + compensation + '\'' + 
			",openGraph = '" + openGraph + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}