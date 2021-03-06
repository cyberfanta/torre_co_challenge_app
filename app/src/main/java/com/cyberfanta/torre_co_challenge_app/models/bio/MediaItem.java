package com.cyberfanta.torre_co_challenge_app.models.bio;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class MediaItem{

	@SerializedName("mediaItems")
	private List<MediaItemsItem> mediaItems;

	@SerializedName("description")
	private String description;

	@SerializedName("mediaType")
	private String mediaType;

	@SerializedName("group")
	private String group;

	public void setMediaItems(List<MediaItemsItem> mediaItems){
		this.mediaItems = mediaItems;
	}

	public List<MediaItemsItem> getMediaItems(){
		return mediaItems;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setMediaType(String mediaType){
		this.mediaType = mediaType;
	}

	public String getMediaType(){
		return mediaType;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"MediaItem{" + 
			"mediaItems = '" + mediaItems + '\'' + 
			",description = '" + description + '\'' + 
			",mediaType = '" + mediaType + '\'' + 
			",group = '" + group + '\'' + 
			"}";
		}
}