package com.cyberfanta.torre_co_challenge_app.models.opportunities;

public class Data{
	private double minAmount;
	private String code;
	private String periodicity;
	private String currency;
	private double maxAmount;

	public void setMinAmount(double minAmount){
		this.minAmount = minAmount;
	}

	public double getMinAmount(){
		return minAmount;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
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

	public void setMaxAmount(double maxAmount){
		this.maxAmount = maxAmount;
	}

	public double getMaxAmount(){
		return maxAmount;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"minAmount = '" + minAmount + '\'' + 
			",code = '" + code + '\'' + 
			",periodicity = '" + periodicity + '\'' + 
			",currency = '" + currency + '\'' + 
			",maxAmount = '" + maxAmount + '\'' + 
			"}";
		}
}
