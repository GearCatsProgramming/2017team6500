package org.usfirst.frc.team6500.robot.commands;

import org.usfirst.frc.team6500.robot.JoystickPair;
import org.usfirst.frc.team6500.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class dtTank extends Command {
	
	public XboxController controllerX;
	
	public JoystickPair controllers;
	public Joystick controllerL, controllerR;
    
    @SuppressWarnings("static-access")
	public dtTank() {
    	requires(Robot.control);
    	requires(Robot.drive);
    	if (Robot.control.getCurrentCT() == "Joystick"){
    		this.controllers = Robot.control.getJoysticks();
        	this.controllerR = controllers.rightJoy;
        	this.controllerL = controllers.leftJoy;
    	}else{
    		System.out.println("ERROR: XBox Control is no longer supported");
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double multiplier = controllerR.getThrottle() + 1;
    	multiplier = multiplier / 2;
    	multiplier = 1 - multiplier;
		multiplier = multiplier * 0.75;
		double boost = 0.0;
		if (controllerL.getTrigger() && controllerR.getTrigger()) { boost = 0.05; }
		Robot.drive.tankDrive(controllerL.getY(), controllerR.getY(), multiplier + boost);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
