// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OnBoardIO;

public class GyroOnBoardIOCommand extends CommandBase {
  private final OnBoardIO m_io;
  private final Drivetrain m_drive;

  /** Creates a new GyroOnBoardIOCommand. */
  public GyroOnBoardIOCommand(OnBoardIO io, Drivetrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_io = io;
    m_drive = drive;
    addRequirements(io);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double low = m_drive.getGyroAngleZ();
    if (Math.abs(low) > 5) {
      m_io.setRedLed(true);
      m_io.setGreenLed(false);
    } else {
      m_io.setRedLed(false);
      m_io.setGreenLed(true);
    }
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
