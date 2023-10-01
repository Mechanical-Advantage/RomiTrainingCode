// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.romi.RomiGyro;

/** Defines the interface for communicating with drivetrain hardware. */
public class DrivetrainIORomi implements DrivetrainIO {
    /** Contains all of the input data received from drivetrain hardware. */
    public class DrivetrainIOInputs {
        public double leftPositionRadians = 0.0;
        public double rightPositionRadians = 0.0;
        public double gyroPositionRadians = 0.0;
    }

    private DrivetrainIOInputs m_DrivetrainIOInputs;
    private Encoder m_gyro;

    /** Updates an instance of "DrivetrainIOInputs" using sensor data. */
    public void updateInputs(DrivetrainIOInputs inputs) {
        m_DrivetrainIOInputs.leftPositionRadians = inputs.leftPositionRadians;
        m_DrivetrainIOInputs.rightPositionRadians = inputs.rightPositionRadians;
        m_DrivetrainIOInputs.gyroPositionRadians = inputs.gyroPositionRadians;
    }

    /** Drives the robot at the specified percentages (from -1 to 1). */
    public void setOutputs(double leftPercent, double rightPercent) {
        leftPercent = 1;
        rightPercent = 1;
    }

    /**
     * Resets the encoder values to 0.
     * 
     * @param m_leftEncoder
     * @param m_rightEncoder
     */
    public void resetEncoders(Encoder m_leftEncoder, Encoder m_rightEncoder) {
        m_leftEncoder.reset();
        m_rightEncoder.reset();
    }

    /** Resets the gyro angle to 0. */
    public void resetGyro() {
        m_gyro.reset();
    }
}