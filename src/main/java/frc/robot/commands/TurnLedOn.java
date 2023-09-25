// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.OnBoardIO;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnLedOn extends CommandBase {
  private final OnBoardIO m_OnBoardIO;

  /** Creates a new TurnLedOn. */

  public TurnLedOn(OnBoardIO io) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_OnBoardIO = io;
    addRequirements(io);
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
    System.out.println("Executing LED ON");
    m_OnBoardIO.setGreenLed(true);
  }

  // Called once the command ends or is interrupted.
  @Override

  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
