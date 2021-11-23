// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DrivePID extends CommandBase {
  private PIDController m_pid = new PIDController(P, I, D);
  private Drivetrain m_drive;
  private double m_distance;
  private static final double P = .1;
  private static final double I = 0;
  private static final double D = 0;

  /** Creates a new DrivePID. */
  public DrivePID(Drivetrain drive, double distance) {
    m_distance = distance;
    m_drive = drive;
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double output = m_pid.calculate(m_drive.getAverageDistanceInch(), m_distance);
    m_drive.arcadeDrive(output, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
