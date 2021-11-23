// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnPID extends CommandBase {
  private static final double KP = 0.01;
  private static final double KD = 0;
  private static final double TOLERANCE = 2;
  private final Drivetrain m_drive;
  private final double m_degrees;
  private final PIDController pid = new PIDController(KP, 0, KD);

  /** Creates a new TurnPID. */
  public TurnPID(double degrees, Drivetrain drive) {
    m_degrees = degrees;
    m_drive = drive;
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    m_drive.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double output = pid.calculate(m_drive.getGyroAngleZ(), m_degrees);
    m_drive.arcadeDrive(0, output);
    System.out.println(output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double gyroAngle = m_drive.getGyroAngleZ();
    return Math.abs(gyroAngle) <= m_degrees + TOLERANCE && Math.abs(gyroAngle) >= m_degrees - TOLERANCE;
  }
}
