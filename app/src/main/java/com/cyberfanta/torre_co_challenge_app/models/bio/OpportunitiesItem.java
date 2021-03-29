package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class OpportunitiesItem{

	@SerializedName("field")
	private String field;

	@SerializedName("data")
//	private List<DataItem> data;
	private Object data;

	@SerializedName("interest")
	private String interest;

	@SerializedName("id")
	private String id;

	public void setField(String field){
		this.field = field;
	}

	public String getField(){
		return field;
	}

//	public void setData(Class<T> data){
//		if (data.getDeclaringClass() = boolean.class) {
//
//		}
//		this.data = data;
//	}
//	public void setData(List<DataItem> data){
//		this.data = data;
//	}

//	public List<DataItem> getData(){
//		return data;
//	}

	public void setInterest(String interest){
		this.interest = interest;
	}

	public String getInterest(){
		return interest;
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
			"OpportunitiesItem{" + 
			"field = '" + field + '\'' + 
			",data = '" + data + '\'' + 
			",interest = '" + interest + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}