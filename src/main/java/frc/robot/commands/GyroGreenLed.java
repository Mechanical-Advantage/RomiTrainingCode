// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OnBoardIO;

public class GyroGreenLed extends CommandBase {
  private final OnBoardIO io;
  private final Drivetrain drivetrain;
  /** Creates a new GyroGreenLed. */
  public GyroGreenLed(OnBoardIO io, Drivetrain drivetrain) {
    this.io = io;
    this.drivetrain = drivetrain;
    addRequirements(io);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Math.abs(drivetrain.getGyroAngleZ()% 360.0) < 5){
      io.setGreenLed(true);
      io.setRedLed(false);
    }
    else{
      io.setRedLed(true);
      io.setGreenLed(false);
      
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
