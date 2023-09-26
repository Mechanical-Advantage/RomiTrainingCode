// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.OnBoardIO;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ToggleLightsBasedOnGyro extends CommandBase {
  private final OnBoardIO m_io;

  /** Creates a new ToggleLightsBasedOnGyro. */
  public ToggleLightsBasedOnGyro(OnBoardIO io) {
    m_io = io;
    addRequirements(io);
    if (getRequirements().contains(io)) {
      System.out.println("Subsystem found");
    } else {
      System.out.println("Subsystem.not found");
    }
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double gyroAngle = m_io.getDrivetrain().getGyroAngleZ();

    if (Math.abs(gyroAngle) < Constants.IS_ORIENTED_STRAIGHT_DEGREE_THRESHOLD) {
      setLightsGreen();
    }

    else {
      setLightsRed();
    }
  }

  private void setLightsGreen() {
    System.out.println("in set light green");
    m_io.setGreenLed(true);
    m_io.setRedLed(false);
  }

  private void setLightsRed() {
    System.out.println("in set light red");
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
