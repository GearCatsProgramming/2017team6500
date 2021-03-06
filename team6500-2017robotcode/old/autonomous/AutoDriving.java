package org.usfirst.frc.team6500.robot.autonomous;

import org.usfirst.frc.team6500.robot.Blargh;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriving extends Command {
	
	double leftpower;
	double rightpower;
	double seconds;

    public AutoDriving(double left, double right, double seconds) {
    	this.leftpower = left;
    	this.rightpower = right;
    	this.seconds = seconds;
    	setTimeout(seconds);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Blargh.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Blargh.drive.tankDrive(leftpower, rightpower, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Blargh.drive.brakeStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
