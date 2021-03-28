package com.cyberfanta.torre_co_challenge_app.models.job;

public class AttachmentsItem{
	private String path;
	private String address;
	private String resource;
	private String caption;

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setResource(String resource){
		this.resource = resource;
	}

	public String getResource(){
		return resource;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	@Override
 	public String toString(){
		return 
			"AttachmentsItem{" + 
			"path = '" + path + '\'' + 
			",address = '" + address + '\'' + 
			",resource = '" + resource + '\'' + 
			",caption = '" + caption + '\'' + 
			"}";
		}
}
