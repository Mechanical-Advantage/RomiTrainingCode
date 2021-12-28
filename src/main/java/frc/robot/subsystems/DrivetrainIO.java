// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

/** Defines the interface for communicating with drivetrain hardware. */
public interface DrivetrainIO {
  /** Contains all of the input data received from drivetrain hardware. */
  public class DrivetrainIOInputs implements LoggableInputs {
    public double leftPositionRadians = 0.0;
    public double rightPositionRadians = 0.0;
    public double gyroPositionRadians = 0.0;

    @Override
    public void toLog(LogTable table) {
      // TODO Auto-generated method 
      table.put("LeftPositionRadians", leftPositionRadians);
      table.put("RightPositionRadians", rightPositionRadians);
      table.put("GyroPositionRadians", gyroPositionRadians);

    }

    @Override
    public void fromLog(LogTable table) {
      // TODO Auto-generated method stub
      leftPositionRadians = table.getDouble("LeftPositionRadians", leftPositionRadians);
      rightPositionRadians = table.getDouble("RightPositionRadians", rightPositionRadians);
      gyroPositionRadians = table.getDouble("GyroPositionRadians", gyroPositionRadians);

    }
  }

  /** Updates an instance of "DrivetrainIOInputs" using sensor data. */
  public default void updateInputs(DrivetrainIOInputs inputs) {
  }

  /** Drives the robot at the specified percentages (from -1 to 1). */
  public default void setOutputs(double leftPercent, double rightPercent) {
  }

  /** Resets the encoder values to 0. */
  public default void resetEncoders() {
  }

  /** Resets the gyro angle to 0. */
  public default void resetGyro() {
  }
}