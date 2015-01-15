package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SpeedController;

public class SwerveDrive {
	private SwerveModule[] modules;

	public SwerveDrive(SpeedController[] drives, SpeedController[] pivots, int[] sensors)
	{
		if (drives.length != pivots.length || pivots.length != sensors.length)
			try {
				throw new WhatAreYouRetardedException("Arrays passed to SwerveDrive() are the wrong length.");
			} catch (WhatAreYouRetardedException e) {
				e.printStackTrace();
			}

		this.modules = new SwerveModule[drives.length];
		for (int i = 0; i < drives.length; ++i)
			this.modules[i] = new SwerveModule(drives[i],pivots[i],sensors[i]);
	}
	
	public void setAngle(float angle)
	{
		for (SwerveModule m : modules)
			m.setAngle(angle);
	}
	
	public void adjust()
	{
		for (SwerveModule m : modules)
			m.adjust();
	}
	
	public void adjust(float angle)
	{
		this.setAngle(angle);
		this.adjust();
	}
	
	public void setSpeed(float speed)
	{
		for (SwerveModule m : modules)
			m.setSpeed(speed);
	}
	
	public void drive(float speed, float angle)
	{
		this.adjust(angle);
		this.setSpeed(speed);
	}
}