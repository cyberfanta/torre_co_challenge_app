package com.cyberfanta.torre_co_challenge_app.models.bio;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OpportunitiesItem{

	@SerializedName("field")
	private String field;

	@SerializedName("data")
	private Object data;
	private List<DataItem> dataList = null;

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

//	@SuppressWarnings("unchecked")
//	private static <T extends List<DataItem>> T castToList(Object obj) {
//		return (T) obj;
//	}

	public void setData(Object data) {
		this.data = data;

//		Bio bio;
//		for (int j = 0; ((List<DataItem>)(bio.getOpportunities().get(i).data)).size(); j++)

//		if (!(data instanceof Boolean))
//			this.dataList = castToList(data);
	}

	public Object getData() {
		return data;
	}

	public List<DataItem> getDataList() {
		return dataList;
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