package com.cyberfanta.torre_co_challenge_app.models.job;

public class Flags{
	private boolean membersBenefitsViewed;
	private boolean firstSignalSent;
	private boolean matchAndRankDisclaimerViewed;
	private boolean earlyAccess;
	private boolean experiencesVerificationsSurvey;
	private boolean notificationsPhrasesSarcastic;
	private boolean opportunityCrawler;
	private boolean torreMatchAcknowledged;
	private boolean veiled;
	private boolean automatedMessagesFeatureDiscovery;
	private boolean opportunitiesBenefitsViewed;
	private boolean firstGetSignalBenefitsViewed;
	private boolean opportunityOperator;
	private boolean signedInToOpportunities;
	private boolean firstSignalOnBoarded;
	private boolean referredMatchUnderstood;
	private boolean enlauSource;
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
