// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.DrivetrainIO.DrivetrainIOInputs;

public class Drivetrain extends SubsystemBase {
  private final DrivetrainIO io;
  private final DrivetrainIOInputs inputs = new DrivetrainIOInputs();
  private static final double kWheelRadiusInch = 1.377955;

  /** Creates a new Drivetrain. */
  public Drivetrain(DrivetrainIO io) {
    this.io = io;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    io.updateInputs(inputs);
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
  }

  public void resetEncoders() {
    io.resetEncoders();
  }

  public double getLeftDistanceInch() {
    return inputs.leftPositionRadians * kWheelRadiusInch;
  }

  public double getRightDistanceInch() {
    return inputs.rightPositionRadians * kWheelRadiusInch;
  }

  public double getAverageDistanceInch() {
    return 0.0;
  }

  public double getGyroAngleZ() {
    return Math.toDegrees(inputs.gyroPositionRadians);
  }

  public void resetGyro() {
  }
}
