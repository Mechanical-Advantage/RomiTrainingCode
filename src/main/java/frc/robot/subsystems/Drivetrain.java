// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.DrivetrainIO.DrivetrainIOInputs;

public class Drivetrain extends SubsystemBase {
  private Drivetrain m_diffDrive;
  private DrivetrainIO m_drivetrainIO;
  private static DrivetrainIOInputs m_DrivetrainIOInputs = new DrivetrainIOInputs();

  /** Creates a new Drivetrain. */
  public Drivetrain(DrivetrainIO io) {
    m_drivetrainIO = io;
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {

  }

  public void resetEncoders() {

  }

  public double getLeftDistanceInch() {
    return 0.0;
  }

  public double getRightDistanceInch() {
    return 0.0;
  }

  public double getAverageDistanceInch() {
    return 0.0;
  }

  public double getGyroAngleZ() {
    return 0.0;
  }

  public void resetGyro() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
