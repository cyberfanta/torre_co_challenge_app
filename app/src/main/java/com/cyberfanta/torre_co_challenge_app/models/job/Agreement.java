package com.cyberfanta.torre_co_challenge_app.models.job;

public class Agreement{
	private String currencyTaxes;
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

	@Override
 	public String toString(){
		return 
			"Agreement{" + 
			"currencyTaxes = '" + currencyTaxes + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
