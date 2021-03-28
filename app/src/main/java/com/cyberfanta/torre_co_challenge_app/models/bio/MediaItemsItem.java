package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class MediaItemsItem{

	@SerializedName("address")
	private String address;

	@SerializedName("id")
	private String id;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"MediaItemsItem{" + 
			"address = '" + address + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}