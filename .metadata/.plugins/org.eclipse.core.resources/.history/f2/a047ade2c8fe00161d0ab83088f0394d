package org.usfirst.frc.team6500.robot.subsystems;

import org.usfirst.frc.team6500.robot.JoystickPair;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Control extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static String controlType = "Joystick";
	
	public static Joystick controllerL, controllerR;
	public XboxController controllerX;
	
	public void controlType(boolean isXbox){
		if (isXbox) {
			controlType = "XBox";
		}else{
			controlType = "Joystick";
		}
	}
	
	public String getCurrentCT(){
		return controlType;
	}
	
	public Joystick getLeftController() {
		return controllerL;
	}
	
	public Joystick getRightController() {
		return controllerR;
	}
	
	public XboxController getXboxController() {
		return controllerX;
	}
	
	public static JoystickPair getJoysticks() {
		return new JoystickPair(controllerL, controllerR);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

