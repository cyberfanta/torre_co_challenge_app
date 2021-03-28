package com.cyberfanta.torre_co_challenge_app.models.bio;

public class Flags{
	private boolean benefits;
	private boolean canary;
	private boolean firstSignalSent;
	private boolean signalsOnboardingCompleted;
	private boolean genomeCompletionAcknowledged;
	private boolean importingLinkedin;
	private boolean featureDiscovery;
	private boolean getSignaledBenefitsViewed;
	private boolean importingLinkedinRecommendations;
	private boolean signalsFeatureDiscovery;
	private boolean onBoarded;
	private boolean remoter;
	private boolean signedInToOpportunities;
	private boolean enlauSource;
	private boolean fake;
	private boolean appContactsImported;
	private boolean contactsImported;

	public void setBenefits(boolean benefits){
		this.benefits = benefits;
	}

	public boolean isBenefits(){
		return benefits;
	}

	public void setCanary(boolean canary){
		this.canary = canary;
	}

	public boolean isCanary(){
		return canary;
	}

	public void setFirstSignalSent(boolean firstSignalSent){
		this.firstSignalSent = firstSignalSent;
	}

	public boolean isFirstSignalSent(){
		return firstSignalSent;
	}

	public void setSignalsOnboardingCompleted(boolean signalsOnboardingCompleted){
		this.signalsOnboardingCompleted = signalsOnboardingCompleted;
	}

	public boolean isSignalsOnboardingCompleted(){
		return signalsOnboardingCompleted;
	}

	public void setGenomeCompletionAcknowledged(boolean genomeCompletionAcknowledged){
		this.genomeCompletionAcknowledged = genomeCompletionAcknowledged;
	}

	public boolean isGenomeCompletionAcknowledged(){
		return genomeCompletionAcknowledged;
	}

	public void setImportingLinkedin(boolean importingLinkedin){
		this.importingLinkedin = importingLinkedin;
	}

	public boolean isImportingLinkedin(){
		return importingLinkedin;
	}

	public void setFeatureDiscovery(boolean featureDiscovery){
		this.featureDiscovery = featureDiscovery;
	}

	public boolean isFeatureDiscovery(){
		return featureDiscovery;
	}

	public void setGetSignaledBenefitsViewed(boolean getSignaledBenefitsViewed){
		this.getSignaledBenefitsViewed = getSignaledBenefitsViewed;
	}

	public boolean isGetSignaledBenefitsViewed(){
		return getSignaledBenefitsViewed;
	}

	public void setImportingLinkedinRecommendations(boolean importingLinkedinRecommendations){
		this.importingLinkedinRecommendations = importingLinkedinRecommendations;
	}

	public boolean isImportingLinkedinRecommendations(){
		return importingLinkedinRecommendations;
	}

	public void setSignalsFeatureDiscovery(boolean signalsFeatureDiscovery){
		this.signalsFeatureDiscovery = signalsFeatureDiscovery;
	}

	public boolean isSignalsFeatureDiscovery(){
		return signalsFeatureDiscovery;
	}

	public void setOnBoarded(boolean onBoarded){
		this.onBoarded = onBoarded;
	}

	public boolean isOnBoarded(){
		return onBoarded;
	}

	public void setRemoter(boolean remoter){
		this.remoter = remoter;
	}

	public boolean isRemoter(){
		return remoter;
	}

	public void setSignedInToOpportunities(boolean signedInToOpportunities){
		this.signedInToOpportunities = signedInToOpportunities;
	}

	public boolean isSignedInToOpportunities(){
		return signedInToOpportunities;
	}

	public void setEnlauSource(boolean enlauSource){
		this.enlauSource = enlauSource;
	}

	public boolean isEnlauSource(){
		return enlauSource;
	}

	public void setFake(boolean fake){
		this.fake = fake;
	}

	public boolean isFake(){
		return fake;
	}

	public void setAppContactsImported(boolean appContactsImported){
		this.appContactsImported = appContactsImported;
	}

	public boolean isAppContactsImported(){
		return appContactsImported;
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
			"benefits = '" + benefits + '\'' + 
			",canary = '" + canary + '\'' + 
			",firstSignalSent = '" + firstSignalSent + '\'' + 
			",signalsOnboardingCompleted = '" + signalsOnboardingCompleted + '\'' + 
			",genomeCompletionAcknowledged = '" + genomeCompletionAcknowledged + '\'' + 
			",importingLinkedin = '" + importingLinkedin + '\'' + 
			",featureDiscovery = '" + featureDiscovery + '\'' + 
			",getSignaledBenefitsViewed = '" + getSignaledBenefitsViewed + '\'' + 
			",importingLinkedinRecommendations = '" + importingLinkedinRecommendations + '\'' + 
			",signalsFeatureDiscovery = '" + signalsFeatureDiscovery + '\'' + 
			",onBoarded = '" + onBoarded + '\'' + 
			",remoter = '" + remoter + '\'' + 
			",signedInToOpportunities = '" + signedInToOpportunities + '\'' + 
			",enlauSource = '" + enlauSource + '\'' + 
			",fake = '" + fake + '\'' + 
			",appContactsImported = '" + appContactsImported + '\'' + 
			",contactsImported = '" + contactsImported + '\'' + 
			"}";
		}
}
