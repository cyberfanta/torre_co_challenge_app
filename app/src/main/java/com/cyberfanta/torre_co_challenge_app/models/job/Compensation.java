package com.cyberfanta.torre_co_challenge_app.models.job;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Compensation{

	@SerializedName("minAmount")
	private int minAmount;

	@SerializedName("code")
	private String code;

	@SerializedName("visible")
	private boolean visible;

	@SerializedName("estimate")
	private boolean estimate;

	@SerializedName("periodicity")
	private String periodicity;

	@SerializedName("currency")
	private String currency;

	@SerializedName("maxAmount")
	private int maxAmount;

	public void setMinAmount(int minAmount){
		this.minAmount = minAmount;
	}

	public int getMinAmount(){
		return minAmount;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public boolean isVisible(){
		return visible;
	}

	public void setEstimate(boolean estimate){
		this.estimate = estimate;
	}

	public boolean isEstimate(){
		return estimate;
	}

	public void setPeriodicity(String periodicity){
		this.periodicity = periodicity;
	}

	public String getPeriodicity(){
		return periodicity;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setMaxAmount(int maxAmount){
		this.maxAmount = maxAmount;
	}

	public int getMaxAmount(){
		return maxAmount;
	}

	@Override
	@NotNull
	public String toString(){
		return 
			"Compensation{" + 
			"minAmount = '" + minAmount + '\'' + 
			",code = '" + code + '\'' + 
			",visible = '" + visible + '\'' + 
			",estimate = '" + estimate + '\'' + 
			",periodicity = '" + periodicity + '\'' + 
			",currency = '" + currency + '\'' + 
			",maxAmount = '" + maxAmount + '\'' + 
			"}";
		}
}