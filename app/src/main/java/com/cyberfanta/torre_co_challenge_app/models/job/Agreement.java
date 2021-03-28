package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Agreement{

	@SerializedName("currencyTaxes")
	private String currencyTaxes;

	@SerializedName("type")
	private String type;

	public void setCurrencyTaxes(String currencyTaxes){
		this.currencyTaxes = currencyTaxes;
	}

	public String getCurrencyTaxes(){
		return currencyTaxes;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@NotNull
	@Override
 	public String toString(){
		return 
			"Agreement{" + 
			"currencyTaxes = '" + currencyTaxes + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}