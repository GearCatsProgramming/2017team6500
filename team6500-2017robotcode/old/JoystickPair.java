package org.usfirst.frc.team6500.robot;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickPair {
	
	public Joystick leftJoy, rightJoy;
	
	public JoystickPair(Joystick leftJoystick, Joystick rightJoystick) {
		this.leftJoy = leftJoystick;
		this.rightJoy = rightJoystick;
	}

}
