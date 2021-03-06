package org.usfirst.frc.team6500.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flaps extends Subsystem {
	
	public Servo leftFlap, rightFlap;
	boolean flaps;

    public void initServos(int left, int right, boolean defaultPos) {
    	this.leftFlap = new Servo(left);
    	this.rightFlap = new Servo(right);
    	this.flaps = defaultPos;
    }
    
    public void flapsUp() {
    	this.leftFlap.set(0.4);
    	this.rightFlap.set(0.0);
    	this.flaps = true;
    }
    
    public void flapsDown() {
    	this.leftFlap.set(0.0);
    	this.rightFlap.set(0.4);
    	this.flaps = false;
    }
    
    public void toggleFlaps() {
    	if (this.flaps) {
			this.leftFlap.set(0.5);
			this.rightFlap.set(0);
			this.flaps = false;
		}else{
			this.leftFlap.set(0);
			this.rightFlap.set(0.4);
			this.flaps = true;
		}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}