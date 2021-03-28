package com.cyberfanta.torre_co_challenge_app.models.job;

public class BaseSalary{
	private String type;
	private String currency;
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
 	public String toString(){
		return 
			"BaseSalary{" + 
			"@type = '" + type + '\'' + 
			",currency = '" + currency + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}
