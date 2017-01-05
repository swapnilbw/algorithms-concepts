package com.example;

public enum MySingleToneClass {

	INSTANCE;
	
	public String pleaseCallMe(){
		return "Hello There";
	}
}
