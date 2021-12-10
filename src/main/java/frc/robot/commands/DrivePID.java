// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivePID extends CommandBase {
  private static final double KP = 0.05;
  private static final double KD = 0;
  private static final double LIMIT = 0.5;
  private static final double TOLERANCE = 0.25;
  private final Drivetrain m_drive;
  private final double m_distance;
  private final PIDController pid = new PIDController(KP, 0, KD);

  /** Creates a new DrivePID. */
  public DrivePID(double inches, Drivetrain drive) {
    m_drive = drive; 
    m_distance = inches;
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double output = pid.calculate(m_drive.getAverageDistanceInch(), m_distance);
    if (output > LIMIT){
      output = LIMIT;
    }
    if (output < -LIMIT){
      output = -LIMIT;
    }
    m_drive.arcadeDrive(output, 0);
    SmartDashboard.putNumber("PositionError", pid.getPositionError());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(m_drive.getAverageDistanceInch()) <= m_distance + TOLERANCE && Math.abs(m_drive.getAverageDistanceInch()) >= m_distance - TOLERANCE;
  }
}
