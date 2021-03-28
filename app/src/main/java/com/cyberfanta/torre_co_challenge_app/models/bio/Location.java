package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Location{

	@SerializedName("country")
	private String country;

	@SerializedName("timezoneOffSet")
	private int timezoneOffSet;

	@SerializedName("timezone")
	private String timezone;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("name")
	private String name;

	@SerializedName("longitude")
	private double longitude;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setTimezoneOffSet(int timezoneOffSet){
		this.timezoneOffSet = timezoneOffSet;
	}

	public int getTimezoneOffSet(){
		return timezoneOffSet;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"Location{" + 
			"country = '" + country + '\'' + 
			",timezoneOffSet = '" + timezoneOffSet + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",name = '" + name + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}