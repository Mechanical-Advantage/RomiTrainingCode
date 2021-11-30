// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DrivePID extends CommandBase {
  /** Creates a new DrivePID. */
  private final double pidTolerance = 1;
  private static final double kP = 0.7;
  private static final double kI = 0;
  private static final double kD = 0;
  private final Drivetrain drive;
  private final PIDController pid = new PIDController(kP, kI, kD);
  public DrivePID(Drivetrain drive, double distanceInInches) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
    this.drive = drive;
    pid.setTolerance(pidTolerance);
    pid.setSetpoint(distanceInInches);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pid.reset();
    drive.resetEncoders();
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double percentOut = pid.calculate(drive.getAverageDistanceInch());
    drive.arcadeDrive(percentOut, 0);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pid.atSetpoint();
  }
}
