package org.usfirst.frc.team3464.robot;

public class MA3Encoder {
	private PWMIn in;

	public MA3Encoder(int pin)
	{
		in = new PWMIn(pin);
	}
	
	public float getAngle()
	{
		return 2 * (float) Math.PI * in.get();
	}
}