
package org.usfirst.frc.team3464.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

import static org.usfirst.frc.team3464.robot.Config.*;
import static org.usfirst.frc.team3464.robot.RobotMode.*;

public class Robot extends SampleRobot {
    SwerveDrive robotDrive;
    Joystick driveStick;
    RobotMode mode = DRIVE_ONLY;

    public Robot() {
    	Talon[] driveMotors = new Talon[4];
    	Victor[] pivotMotors = new Victor[4];
    	for (int i = 0; i < 4; ++i) {
    		driveMotors[i] = new Talon(DRIVE_MOTOR_PINS[i]);
    		pivotMotors[i] = new Victor(PIVOT_MOTOR_PINS[i]);
    	}
        robotDrive = new SwerveDrive(driveMotors, pivotMotors, SENSOR_PINS);
        driveStick = new Joystick(DRIVE_STICK_ID);
    }


    public void autonomous() {
    }

    // Drive the robot using input from the drive stick
    public void driveRobot() {
    	robotDrive.drive((float)driveStick.getMagnitude(),
    			(float)driveStick.getDirectionRadians());
    }
    
    public void operatorControl() {
    	while (isOperatorControl() && isEnabled()) {
    		switch (mode) {
    		case CALIBRATE_ENCODER:
    			break;
    		case DRIVE_ONLY:
    			driveRobot();
    			break;
    		case ARMS_ONLY:
    			break;
    		case COMPETITION:
    			break;
    		}
    		try {
    			Thread.sleep(20);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }

    public void test() {
    }
}
