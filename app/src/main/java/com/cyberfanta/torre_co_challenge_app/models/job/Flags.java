package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Flags{

	@SerializedName("membersBenefitsViewed")
	private boolean membersBenefitsViewed;

	@SerializedName("firstSignalSent")
	private boolean firstSignalSent;

	@SerializedName("matchAndRankDisclaimerViewed")
	private boolean matchAndRankDisclaimerViewed;

	@SerializedName("earlyAccess")
	private boolean earlyAccess;

	@SerializedName("experiencesVerificationsSurvey")
	private boolean experiencesVerificationsSurvey;

	@SerializedName("notificationsPhrasesSarcastic")
	private boolean notificationsPhrasesSarcastic;

	@SerializedName("opportunityCrawler")
	private boolean opportunityCrawler;

	@SerializedName("torreMatchAcknowledged")
	private boolean torreMatchAcknowledged;

	@SerializedName("veiled")
	private boolean veiled;

	@SerializedName("automatedMessagesFeatureDiscovery")
	private boolean automatedMessagesFeatureDiscovery;

	@SerializedName("opportunitiesBenefitsViewed")
	private boolean opportunitiesBenefitsViewed;

	@SerializedName("firstGetSignalBenefitsViewed")
	private boolean firstGetSignalBenefitsViewed;

	@SerializedName("opportunityOperator")
	private boolean opportunityOperator;

	@SerializedName("signedInToOpportunities")
	private boolean signedInToOpportunities;

	@SerializedName("firstSignalOnBoarded")
	private boolean firstSignalOnBoarded;

	@SerializedName("referredMatchUnderstood")
	private boolean referredMatchUnderstood;

	@SerializedName("enlauSource")
	private boolean enlauSource;

	@SerializedName("contactsImported")
	private boolean contactsImported;

	public void setMembersBenefitsViewed(boolean membersBenefitsViewed){
		this.membersBenefitsViewed = membersBenefitsViewed;
	}

	public boolean isMembersBenefitsViewed(){
		return membersBenefitsViewed;
	}

	public void setFirstSignalSent(boolean firstSignalSent){
		this.firstSignalSent = firstSignalSent;
	}

	public boolean isFirstSignalSent(){
		return firstSignalSent;
	}

	public void setMatchAndRankDisclaimerViewed(boolean matchAndRankDisclaimerViewed){
		this.matchAndRankDisclaimerViewed = matchAndRankDisclaimerViewed;
	}

	public boolean isMatchAndRankDisclaimerViewed(){
		return matchAndRankDisclaimerViewed;
	}

	public void setEarlyAccess(boolean earlyAccess){
		this.earlyAccess = earlyAccess;
	}

	public boolean isEarlyAccess(){
		return earlyAccess;
	}

	public void setExperiencesVerificationsSurvey(boolean experiencesVerificationsSurvey){
		this.experiencesVerificationsSurvey = experiencesVerificationsSurvey;
	}

	public boolean isExperiencesVerificationsSurvey(){
		return experiencesVerificationsSurvey;
	}

	public void setNotificationsPhrasesSarcastic(boolean notificationsPhrasesSarcastic){
		this.notificationsPhrasesSarcastic = notificationsPhrasesSarcastic;
	}

	public boolean isNotificationsPhrasesSarcastic(){
		return notificationsPhrasesSarcastic;
	}

	public void setOpportunityCrawler(boolean opportunityCrawler){
		this.opportunityCrawler = opportunityCrawler;
	}

	public boolean isOpportunityCrawler(){
		return opportunityCrawler;
	}

	public void setTorreMatchAcknowledged(boolean torreMatchAcknowledged){
		this.torreMatchAcknowledged = torreMatchAcknowledged;
	}

	public boolean isTorreMatchAcknowledged(){
		return torreMatchAcknowledged;
	}

	public void setVeiled(boolean veiled){
		this.veiled = veiled;
	}

	public boolean isVeiled(){
		return veiled;
	}

	public void setAutomatedMessagesFeatureDiscovery(boolean automatedMessagesFeatureDiscovery){
		this.automatedMessagesFeatureDiscovery = automatedMessagesFeatureDiscovery;
	}

	public boolean isAutomatedMessagesFeatureDiscovery(){
		return automatedMessagesFeatureDiscovery;
	}

	public void setOpportunitiesBenefitsViewed(boolean opportunitiesBenefitsViewed){
		this.opportunitiesBenefitsViewed = opportunitiesBenefitsViewed;
	}

	public boolean isOpportunitiesBenefitsViewed(){
		return opportunitiesBenefitsViewed;
	}

	public void setFirstGetSignalBenefitsViewed(boolean firstGetSignalBenefitsViewed){
		this.firstGetSignalBenefitsViewed = firstGetSignalBenefitsViewed;
	}

	public boolean isFirstGetSignalBenefitsViewed(){
		return firstGetSignalBenefitsViewed;
	}

	public void setOpportunityOperator(boolean opportunityOperator){
		this.opportunityOperator = opportunityOperator;
	}

	public boolean isOpportunityOperator(){
		return opportunityOperator;
	}

	public void setSignedInToOpportunities(boolean signedInToOpportunities){
		this.signedInToOpportunities = signedInToOpportunities;
	}

	public boolean isSignedInToOpportunities(){
		return signedInToOpportunities;
	}

	public void setFirstSignalOnBoarded(boolean firstSignalOnBoarded){
		this.firstSignalOnBoarded = firstSignalOnBoarded;
	}

	public boolean isFirstSignalOnBoarded(){
		return firstSignalOnBoarded;
	}

	public void setReferredMatchUnderstood(boolean referredMatchUnderstood){
		this.referredMatchUnderstood = referredMatchUnderstood;
	}

	public boolean isReferredMatchUnderstood(){
		return referredMatchUnderstood;
	}

	public void setEnlauSource(boolean enlauSource){
		this.enlauSource = enlauSource;
	}

	public boolean isEnlauSource(){
		return enlauSource;
	}

	public void setContactsImported(boolean contactsImported){
		this.contactsImported = contactsImported;
	}

	public boolean isContactsImported(){
		return contactsImported;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"Flags{" + 
			"membersBenefitsViewed = '" + membersBenefitsViewed + '\'' + 
			",firstSignalSent = '" + firstSignalSent + '\'' + 
			",matchAndRankDisclaimerViewed = '" + matchAndRankDisclaimerViewed + '\'' + 
			",earlyAccess = '" + earlyAccess + '\'' + 
			",experiencesVerificationsSurvey = '" + experiencesVerificationsSurvey + '\'' + 
			",notificationsPhrasesSarcastic = '" + notificationsPhrasesSarcastic + '\'' + 
			",opportunityCrawler = '" + opportunityCrawler + '\'' + 
			",torreMatchAcknowledged = '" + torreMatchAcknowledged + '\'' + 
			",veiled = '" + veiled + '\'' + 
			",automatedMessagesFeatureDiscovery = '" + automatedMessagesFeatureDiscovery + '\'' + 
			",opportunitiesBenefitsViewed = '" + opportunitiesBenefitsViewed + '\'' + 
			",firstGetSignalBenefitsViewed = '" + firstGetSignalBenefitsViewed + '\'' + 
			",opportunityOperator = '" + opportunityOperator + '\'' + 
			",signedInToOpportunities = '" + signedInToOpportunities + '\'' + 
			",firstSignalOnBoarded = '" + firstSignalOnBoarded + '\'' + 
			",referredMatchUnderstood = '" + referredMatchUnderstood + '\'' + 
			",enlauSource = '" + enlauSource + '\'' + 
			",contactsImported = '" + contactsImported + '\'' + 
			"}";
		}
}