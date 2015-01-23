
package org.usfirst.frc.team3464.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

import static org.usfirst.frc.team3464.robot.Config.*;

/**
 * This is a demo program showing the use of the RobotDrive class.
 * The SampleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
    SwerveDrive robotDrive;
    Joystick stick;

    public Robot() {
    	Talon[] driveMotors = new Talon[4];
    	Victor[] pivotMotors = new Victor[4];
    	for (int i = 0; i < 4; ++i) {
    		driveMotors[i] = new Talon(driveMotorPins[i]);
    		pivotMotors[i] = new Victor(pivotMotorPins[i]);
    	}
        robotDrive = new SwerveDrive(driveMotors, pivotMotors, sensorPins);
        stick = new Joystick(0);
    }

    /**
     * Drive left & right motors for 2 seconds then stop
     */
    public void autonomous() {
    }

    /**
     * Runs the motors with arcade steering.
     */
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
            robotDrive.drive((float)stick.getMagnitude(), (float)stick.getDirectionRadians());
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
