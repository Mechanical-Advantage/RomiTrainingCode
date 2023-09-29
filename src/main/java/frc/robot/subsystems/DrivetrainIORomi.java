// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.romi.RomiGyro;

/** Defines the interface for communicating with drivetrain hardware. */
public interface DrivetrainIORomi {
    /** Contains all of the input data received from drivetrain hardware. */
    public class DrivetrainIOInputs {
        public double leftPositionRadians = 0.0;
        public double rightPositionRadians = 0.0;
        public double gyroPositionRadians = 0.0;
    }

    /**
     * Updates an instance of "DrivetrainIOInputs" using sensor data.
     */

    public static int getLeftEncoderCount() {
        return m_leftEncoder.get();
    }

    public static int getRightEncoderCount() {
        return m_rightEncoder.get();
    }

    public default void updateInputs(DrivetrainIOInputs inputs) {
        getLeftEncoderCount();
        getRightEncoderCount();
        m_gyro.getAngleX();
    }

    /** Drives the robot at the specified percentages (from -1 to 1). */
    public default void setOutputs(double leftPercent, double rightPercent) {
        leftPercent = 1;
        rightPercent = 1;
    }

    /** Resets the encoder values to 0. */
    final Encoder m_leftEncoder = new Encoder(4, 5);
    final Encoder m_rightEncoder = new Encoder(6, 7);

    public default void resetEncoders() {
        m_leftEncoder.reset();
        m_rightEncoder.reset();
    }

    /** Resets the gyro angle to 0. */
    public final RomiGyro m_gyro = new RomiGyro();

    public default void resetGyro() {
        m_gyro.reset();
    }
}
