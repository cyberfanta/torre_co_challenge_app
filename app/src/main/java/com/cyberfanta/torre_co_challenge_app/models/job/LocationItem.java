package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class LocationItem{

	@SerializedName("serpData")
	private String serpData;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("id")
	private String id;

	@SerializedName("longitude")
	private double longitude;

	public void setSerpData(String serpData){
		this.serpData = serpData;
	}

	public String getSerpData(){
		return serpData;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"LocationItem{" + 
			"serpData = '" + serpData + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",id = '" + id + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}