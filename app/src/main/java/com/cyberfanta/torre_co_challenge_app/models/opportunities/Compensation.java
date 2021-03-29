package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

public class Compensation{
	private boolean visible;
	private Data data;

	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public boolean isVisible(){
		return visible;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Compensation{" + 
			"visible = '" + visible + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}
