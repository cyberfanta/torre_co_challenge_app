package com.cyberfanta.torre_co_challenge_app.models.peoples;

public class Context{
	private Object signaled;

	public void setSignaled(Object signaled){
		this.signaled = signaled;
	}

	public Object getSignaled(){
		return signaled;
	}

	@Override
 	public String toString(){
		return 
			"Context{" + 
			"signaled = '" + signaled + '\'' + 
			"}";
		}
}
