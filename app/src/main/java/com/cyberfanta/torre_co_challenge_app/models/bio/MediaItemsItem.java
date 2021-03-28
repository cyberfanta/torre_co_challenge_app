package com.cyberfanta.torre_co_challenge_app.models.bio;

public class MediaItemsItem{
	private String address;
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

	@Override
 	public String toString(){
		return 
			"MediaItemsItem{" + 
			"address = '" + address + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
