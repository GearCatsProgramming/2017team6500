package org.usfirst.frc.team6500.robot;

import org.usfirst.frc.team6500.robot.autonomous.DriveBaseline;
import org.usfirst.frc.team6500.robot.subsystems.*;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	Command autonomousCommand;
	
	public static OI oi;
	
	//Subsystems
	public static DriveTrain drive;
	public static Control control;
	public static Elevator elevator;
	public static Flaps gearFlaps;
	public static Camera pantilt;
	public static Dumper dumper;
	public static Gyro gyroscope;

	boolean nitro = false;
	
	//The @Override tag means we are overriding the method that was defined in the superclass (IterativeRobot in this case)
	//The robotInit method happens once when the RoboRio starts up and never again.
	//We need to define everything that we will use later now
	@Override
	public void robotInit() {
		drive = new DriveTrain();
		control = new Control();
		elevator = new Elevator();
		gearFlaps = new Flaps();
		pantilt = new Camera();
		dumper = new Dumper();
		gyroscope = new Gyro();
		
		drive.initMotors(Ports.rightfront, Ports.rightrear, Ports.leftfront, Ports.leftrear);
		//drive.initDefaultCommand();
		control.initSticks(Ports.joystickid2, Ports.joystickid);
		oi = new OI();
		elevator.initMotor(Ports.elevator);
		gearFlaps.initServos(Ports.leftGear, Ports.rightGear, false);
		pantilt.initServos(Ports.pan, Ports.tilt, 0.0, 0.3);
		dumper.initActuator(Ports.actuator);
		gyroscope.initGyro();
		
		CameraServer.getInstance().startAutomaticCapture();
	}
	
	@Override
	public void autonomousInit(){
		autonomousCommand = new DriveBaseline();
		autonomousCommand.start();
	}
	
	//This code runs when the autonomous portion of the match is happening,
	//and it (should) only runs once (see the autonomous variable)
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit(){
		if (false) {
			if (autonomousCommand.isRunning()) {
				autonomousCommand.cancel();
			}
		}
	}
	
	//This method loops as fast as possible while the robot is in
	@SuppressWarnings({ "static-access" })
	//the teleoperated (controlled by driver) period of the match
	@Override
	public void teleopPeriodic() {
		System.out.println("running");
		
		Scheduler.getInstance().run();
		
		if (control.controllerR.getRawButton(12)) {
			nitro = true;
		}else{
			nitro = false;
		}
		
		//Putting values to the SmartDashboard
		SmartDashboard.putData("SchedulerData", Scheduler.getInstance());
		SmartDashboard.putNumber("Gyroscope Angle", gyroscope.gyroAngle());
		SmartDashboard.putNumber("Pan Position", pantilt.panpos);
		SmartDashboard.putNumber("Tilt Position", pantilt.tiltpos);
		SmartDashboard.putBoolean("Zoom Zoom!", nitro);
	}

	@Override
	public void testPeriodic() {

	}
}
