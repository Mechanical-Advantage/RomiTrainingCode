// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.DrivetrainIO.DrivetrainIOInputs;

public class Drivetrain extends SubsystemBase {
  private static final double wheelRadiusInch = 2.9;
  private final DrivetrainIO drivetrainIO;
  private final DrivetrainIOInputs inputs = new DrivetrainIOInputs();
  /** Creates a new Drivetrain. */
  public Drivetrain(DrivetrainIO drivetrainIO) {
    this.drivetrainIO = drivetrainIO;

  }

  @Override
  public void periodic() {
    drivetrainIO.updateInputs(inputs);
    Logger.getInstance().processInputs("Drivetrain", inputs);
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    drivetrainIO.setOutputs(xaxisSpeed + zaxisRotate, xaxisSpeed - zaxisRotate);
  }

  public void resetEncoders() {
    drivetrainIO.resetEncoders();
  }

  public double getLeftDistanceInch() {
    return inputs.leftPositionRadians * wheelRadiusInch;
  }

  public double getRightDistanceInch() {
    return inputs.rightPositionRadians * wheelRadiusInch;
  }

  public double getAverageDistanceInch() {
    return ((inputs.leftPositionRadians + inputs.rightPositionRadians) / 2.0) * wheelRadiusInch;
  }

  public double getGyroAngleZ() {
    return Math.toDegrees(inputs.gyroPositionRadians);
  }

  public void resetGyro() {
    drivetrainIO.resetGyro();
  }

}
