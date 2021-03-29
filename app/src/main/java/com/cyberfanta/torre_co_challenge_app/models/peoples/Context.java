package com.cyberfanta.torre_co_challenge_app.models.peoples;

import org.jetbrains.annotations.NotNull;

public class Context{
	private Object signaled;

	public void setSignaled(Object signaled){
		this.signaled = signaled;
	}

	public Object getSignaled(){
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
