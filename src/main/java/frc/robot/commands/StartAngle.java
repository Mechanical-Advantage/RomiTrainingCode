// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OnBoardIO;

public class StartAngle extends CommandBase {
  Drivetrain drivetrain;
  OnBoardIO io;

  /** Creates a new StartAngle. */
  public StartAngle(Drivetrain drivetrain, OnBoardIO io) {
    this.drivetrain = drivetrain;
    this.io = io; 
    addRequirements(drivetrain);
    addRequirements(io);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double angle = drivetrain.getGyroAngleZ();
    if (Math.abs(angle) < 5) {
      io.setGreenLed(false);
      io.setRedLed(true);
    }
    else {
      io.setRedLed(false);
      io.setGreenLed(true);
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
