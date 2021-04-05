package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Address{

	@SerializedName("addressCountry")
	private String addressCountry;

	@SerializedName("streetAddress")
	private String streetAddress;

	@SerializedName("@type")
	private String type;

	@SerializedName("postalCode")
	private String postalCode;

	@SerializedName("addressLocality")
	private String addressLocality;

	@SerializedName("addressRegion")
	private String addressRegion;

	public void setAddressCountry(String addressCountry){
		this.addressCountry = addressCountry;
	}

	public String getAddressCountry(){
		return addressCountry;
	}

	public void setStreetAddress(String streetAddress){
		this.streetAddress = streetAddress;
	}

	public String getStreetAddress(){
		return streetAddress;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}

	public String getPostalCode(){
		return postalCode;
	}

	public void setAddressLocality(String addressLocality){
		this.addressLocality = addressLocality;
	}

	public String getAddressLocality(){
		return addressLocality;
	}

	public void setAddressRegion(String addressRegion){
		this.addressRegion = addressRegion;
	}

	public String getAddressRegion(){
		return addressRegion;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"Address{" + 
			"addressCountry = '" + addressCountry + '\'' + 
			",streetAddress = '" + streetAddress + '\'' + 
			",@type = '" + type + '\'' + 
			",postalCode = '" + postalCode + '\'' + 
			",addressLocality = '" + addressLocality + '\'' + 
			",addressRegion = '" + addressRegion + '\'' + 
			"}";
		}
}