// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.crypto.spec.DHGenParameterSpec;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnPID extends CommandBase {
  private PIDController m_pid = new PIDController(P, I, D);
  private final Drivetrain m_drive;
  private final double m_degrees;
  private static final double P = .01;
  private static final double I = 0;
  private static final double D = .001;

  /** Creates a new TurnPID. */
  public TurnPID(double degrees, Drivetrain drive) {
    m_degrees = degrees;
    m_drive = drive;
    m_pid.setTolerance(2);
    m_pid.setSetpoint(degrees);
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
    double output = m_pid.calculate(m_drive.getGyroAngleZ(), m_degrees);
    m_drive.arcadeDrive(0, output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_pid.atSetpoint();
  }
}
