// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnPID extends CommandBase {
  private final double targetAngleDegrees;
  private final double pidTolerance = 2;
  private static final double kP = 0.01;
  private static final double kI = 0;
  private static final double kD = 0.0007;
  private final Drivetrain drive;
  private final PIDController pid = new PIDController(kP, kI, kD);

  /** Creates a new TurnPID. */
  public TurnPID(Drivetrain drive, double targetAngleDegrees) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.targetAngleDegrees = targetAngleDegrees;
    this.drive = drive;
    addRequirements(drive);
    pid.setSetpoint(targetAngleDegrees);
    pid.setTolerance(pidTolerance);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double percentOut = pid.calculate(drive.getGyroAngleZ());
    drive.arcadeDrive(0,percentOut);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pid.atSetpoint();
  }
}
