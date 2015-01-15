package org.usfirst.frc.team3464.robot;

import edu.wpi.first.wpilibj.SpeedController;

public class SwerveModule {
	public static final float TOLERANCE = 0.05f;
	public static final float PIVOT_SPEED = 0.7f;
	public static final long CALIBRATION_PERIOD = 10;

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
		speed = diff < Math.PI ? PIVOT_SPEED : -PIVOT_SPEED;

		pivot.set(speed);
		while (Math.abs(angle - this.getActualAngle()) < TOLERANCE)
			try { Thread.sleep(CALIBRATION_PERIOD); }
			catch (InterruptedException e) {}
		pivot.set(0.0f);
	}
	
	public void setSpeed(float speed)
	{
		drive.set(speed);
	}
}
