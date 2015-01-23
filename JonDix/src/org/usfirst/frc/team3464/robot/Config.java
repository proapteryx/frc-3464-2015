package org.usfirst.frc.team3464.robot;

// #define CONST public static final
// if only...

public class Config {
	public static final int[] driveMotorPins = {0, 1, 2, 3};
	public static final int[] pivotMotorPins = {4, 5, 6, 7};
	public static final int[] sensorPins = {0, 1, 2, 3};
	
	public static final float SWERVE_TOLERANCE = 0.05f;
	public static final float SWERVE_PIVOT_SPEED = 0.7f;
	public static final long SWERVE_CALIBRATION_PERIOD = 10;
}
