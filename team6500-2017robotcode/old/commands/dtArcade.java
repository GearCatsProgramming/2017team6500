package org.usfirst.frc.team6500.robot.commands;

import org.usfirst.frc.team6500.robot.JoystickPair;
import org.usfirst.frc.team6500.robot.Blargh;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class dtArcade extends Command {
	
	public XboxController controllerX;
	
	public JoystickPair controllers;
	public Joystick controllerR;

    @SuppressWarnings("static-access")
	public dtArcade() {
    	System.out.println("creating");
    	requires(Blargh.control);
    	requires(Blargh.drive);
    	if (Blargh.control.getCurrentCT() == "Joystick"){
    		this.controllers = Blargh.control.getJoysticks();
        	this.controllerR = controllers.rightJoy;
    	}else{
    		System.out.println("ERROR: XBox Control is no longer supported");
    	}
    	System.out.println("created");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("init");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("exec");
    	double multiplier = controllerR.getThrottle() + 1;
    	multiplier = multiplier / 2;
    	multiplier = 1 - multiplier;
		multiplier = multiplier * 0.75;
		double boost = 0.0;
		if (controllerR.getTrigger()) { boost = 0.05; }
    	Blargh.drive.arcadeDrive(controllerR.getY(), -controllerR.getX(), multiplier + boost);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("ending");
    	Blargh.drive.brakeStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("interrupted");
    	end();
    }
}
