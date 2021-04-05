package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class BaseSalary{

	@SerializedName("@type")
	private String type;

	@SerializedName("currency")
	private String currency;

	@SerializedName("value")
	private Value value;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setValue(Value value){
		this.value = value;
	}

	public Value getValue(){
		return value;
	}

	@Override
	@NotNull
 	public String toString(){
		return 
			"BaseSalary{" + 
			"@type = '" + type + '\'' + 
			",currency = '" + currency + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}