package com.cyberfanta.torre_co_challenge_app.models.job;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Place{

	@SerializedName("timezone")
	private boolean timezone;

	@SerializedName("location")
	private List<Object> location;

	@SerializedName("remote")
	private boolean remote;

	@SerializedName("anywhere")
	private boolean anywhere;

	public void setTimezone(boolean timezone){
		this.timezone = timezone;
	}

	public boolean isTimezone(){
		return timezone;
	}

	public void setLocation(List<Object> location){
		this.location = location;
	}

	public List<Object> getLocation(){
		return location;
	}

	public void setRemote(boolean remote){
		this.remote = remote;
	}

	public boolean isRemote(){
		return remote;
	}

	public void setAnywhere(boolean anywhere){
		this.anywhere = anywhere;
	}

	public boolean isAnywhere(){
		return anywhere;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"Place{" + 
			"timezone = '" + timezone + '\'' + 
			",location = '" + location + '\'' + 
			",remote = '" + remote + '\'' + 
			",anywhere = '" + anywhere + '\'' + 
			"}";
		}
}