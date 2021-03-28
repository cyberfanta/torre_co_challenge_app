package com.cyberfanta.torre_co_challenge_app.models.job;

import java.util.List;

public class Place{
	private boolean timezone;
	private List<Object> location;
	private boolean remote;
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