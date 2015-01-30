package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SpeedController;

import static org.usfirst.frc.team3464.robot.Config.*;

public class SwerveModule {
	private MA3Encoder enc;
	private SpeedController drive, pivot;

	private float angle = 0.0f;

	public SwerveModule(SpeedController drive,
			SpeedController pivot, int encoderPin)
	{
		this.drive = drive;
		this.pivot = pivot;
		enc = new MA3Encoder(encoderPin);
	}

	public float getActualAngle()
	{
		return enc.getAngle();
	}
	
	public float getAngle()
	{
		return angle;
	}

	public void setAngle(float angle)
	{
		this.angle = angle;
	}
	
	public void adjust()
	{
		float speed;
		float diff = angle - this.getActualAngle();
		diff = diff < 0 ? diff + (float) Math.PI * 2 : diff;
		speed = diff < Math.PI ? SWERVE_PIVOT_SPEED : -SWERVE_PIVOT_SPEED;

		pivot.set(speed);
		while (Math.abs(angle - this.getActualAngle()) < SWERVE_TOLERANCE)
			try { Thread.sleep(SWERVE_ADJUSTMENT_PERIOD); }
			catch (InterruptedException e) {}
		pivot.set(0.0f);
	}
	
	public void setSpeed(float speed)
	{
		drive.set(speed);
	}
}
