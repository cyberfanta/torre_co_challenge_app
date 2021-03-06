package com.cyberfanta.torre_co_challenge_app.models.opportunities;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Context{
	private List<Object> signaled;

	public void setSignaled(List<Object> signaled){
		this.signaled = signaled;
	}

	public List<Object> getSignaled(){
		return signaled;
	}

	@NotNull
    @Override
 	public String toString(){
		return 
			"Context{" + 
			"signaled = '" + signaled + '\'' + 
			"}";
		}
}