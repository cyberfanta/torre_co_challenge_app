package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class EducationRequirements{

	@SerializedName("@type")
	private String type;

	@SerializedName("credentialCategory")
	private String credentialCategory;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setCredentialCategory(String credentialCategory){
		this.credentialCategory = credentialCategory;
	}

	public String getCredentialCategory(){
		return credentialCategory;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"EducationRequirements{" + 
			"@type = '" + type + '\'' + 
			",credentialCategory = '" + credentialCategory + '\'' + 
			"}";
		}
}