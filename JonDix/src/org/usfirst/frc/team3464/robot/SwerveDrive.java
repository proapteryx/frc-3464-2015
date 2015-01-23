package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SpeedController;

public class SwerveDrive {
	private SwerveModule[] modules;

	public SwerveDrive(SpeedController[] drives, SpeedController[] pivots, int[] sensors)
	{
		int len = drives.length < pivots.length
				? (drives.length < sensors.length ? drives.length : sensors.length)
				: (pivots.length < sensors.length ? pivots.length : sensors.length);

		this.modules = new SwerveModule[len];
		for (int i = 0; i < len; ++i)
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