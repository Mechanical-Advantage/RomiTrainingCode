// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.OnBoardIO;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ToggleLightsBasedOnGyro extends CommandBase {
  private final OnBoardIO m_io;

  /** Creates a new ToggleLightsBasedOnGyro. */
  public ToggleLightsBasedOnGyro(OnBoardIO io) {
    m_io = io;
    addRequirements(io);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  private void addRequirements(OnBoardIO io) {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double gyroAngle = m_io.m_drivetrain.m_gyro.getAngleZ();

    if (Math.abs(gyroAngle) < 5) {
      setLightsGreen();
    }

    else {
      setLightsRed();
    }
  }

  private void setLightsGreen() {
    m_io.setGreenLed(true);
    m_io.setRedLed(false);
  }

  private void setLightsRed() {
    m_io.setGreenLed(false);
    m_io.setRedLed(true);
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
