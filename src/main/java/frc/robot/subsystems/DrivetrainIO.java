// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

/** Defines the interface for communicating with drivetrain hardware. */
public interface DrivetrainIO {
    /** Contains all of the input data received from drivetrain hardware. */
    public class DrivetrainIOInputs {
        public double leftPositionRadians = 0.0;
        public double rightPositionRadians = 0.0;
        public double gyroPositionRadians = 0.0;
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