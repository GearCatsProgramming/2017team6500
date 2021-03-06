package org.usfirst.frc.team6500.robot.subsystems;

import org.usfirst.frc.team6500.robot.commands.checkPOV;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Servo pan, tilt;
	public double panpos, tiltpos;
	
	public void initServos(int pan, int tilt, double dpan, double dtilt) {
		this.pan = new Servo(pan);
		this.tilt = new Servo(tilt);
		
		this.panpos = dpan;
		this.tiltpos = dtilt;
		
		this.pan.set(panpos);
		this.tilt.set(tiltpos);
	}
	
	public void updatePosition() {
		this.pan.set(this.panpos);
		this.tilt.set(this.tiltpos);
	}
	
	public void panLeft() {
		if (this.panpos > 0.02) {
			this.panpos = this.panpos - 0.02;
		}
		updatePosition();
	}
	
	public void panRight() {
		if (this.panpos < 0.98) {
			this.panpos = this.panpos + 0.02;
		}
		updatePosition();
	}
	
	public void tiltUp() {
		if (this.tiltpos < 0.98) {
			this.tiltpos = this.tiltpos + 0.02;
		}
		updatePosition();
	}
	
	public void tiltDown() {
		if (this.tiltpos > 0.29) {
			this.tiltpos = this.tiltpos - 0.02;
		}
		updatePosition();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new checkPOV());
    }

	public void movecam(double newpan, double newtilt) {
		this.panpos = newpan;
		this.tiltpos = newtilt;
		updatePosition();
	}
}

