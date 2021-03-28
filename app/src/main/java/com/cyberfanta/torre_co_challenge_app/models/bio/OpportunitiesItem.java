package com.cyberfanta.torre_co_challenge_app.models.bio;

public class OpportunitiesItem{
	private String field;
	private List<DataItem> data;
	private String interest;
	private String id;

	public void setField(String field){
		this.field = field;
	}

	public String getField(){
		return field;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

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
