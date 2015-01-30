package org.usfirst.frc.team3464.robot;

public enum RobotMode {
	CALIBRATE_ENCODER,   // Calibrate an encoder connected to DIO 0
	DRIVE_ONLY,          // Enable the drive train code only
	ARMS_ONLY,           // Enable the arms only
	COMPETITION,         // The complete
}