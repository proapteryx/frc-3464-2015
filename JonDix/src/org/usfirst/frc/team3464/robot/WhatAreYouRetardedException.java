package org.usfirst.frc.team3464.robot;

public class WhatAreYouRetardedException extends Exception {
	private String errorMessage;
	public WhatAreYouRetardedException(String msg)
	{
		this.errorMessage = msg;
		super.printStackTrace();
	}
	public void printStackTrace()
	{
		System.out.println("Are you retarded?");
		System.out.println(this.errorMessage);
		super.printStackTrace();
	}
}
