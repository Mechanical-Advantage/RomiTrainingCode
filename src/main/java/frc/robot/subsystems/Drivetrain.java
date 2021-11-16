// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.DrivetrainIO.DrivetrainIOInputs;

public class Drivetrain extends SubsystemBase {
  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    double left = xaxisSpeed + zaxisRotate;
    double right = xaxisSpeed - zaxisRotate;
    io.setOutputs(left, right);
  }

  public void resetEncoders() {
    io.resetEncoders();
  }
  public double getLeftDistanceInch() {}
  public double getRightDistanceInch() {}
  public double getAverageDistanceInch() {}
  public double getGyroAngleZ() {}
  public void resetGyro() {
    io.resetGyro();
  }
  private final DrivetrainIO io;
  /** Creates a new Drivetrain. */
  public Drivetrain(DrivetrainIO io) {
    this.io = io;
  }

  private DrivetrainIOInputs inputs = new DrivetrainIOInputs();

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
