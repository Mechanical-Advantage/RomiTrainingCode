// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.sensors.RomiGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark; 


/** Add your docs here. */
public class DrivetrainIORomi implements DrivetrainIO {
    private final RomiGyro m_gyro = new RomiGyro();
    private final Encoder m_leftEncoder = new Encoder(4, 5);
    private final Encoder m_rightEncoder = new Encoder(6, 7);
    private final Spark m_leftMotor = new Spark(0);
    private final Spark m_rightMotor = new Spark(1);

    public DrivetrainIORomi()
    /** Updates an instance of "DrivetrainIOInputs" using sensor data. */
    public void updateInputs(DrivetrainIOInputs inputs) {
        inputs.gyroPositionRadians = Math.toRadians(m_gyro.getAngleZ()); 
        inputs.rightPositionRadians = (m_rightEncoder.getDistance() / 1440) * 2 * Math.PI; 
        inputs.leftPositionRadians = (m_leftEncoder.getDistance() / 1440) * 2 * Math.PI;
    }

    /** Drives the robot at the specified percentages (from -1 to 1). */
    public void setOutputs(double leftPercent, double rightPercent) {
        
    }

    /** Resets the encoder values to 0. */
    public void resetEncoders() {
        m_rightEncoder.reset();
        m_leftEncoder.reset();
    }

    /** Resets the gyro angle to 0. */
    public void resetGyro() {
        m_gyro.reset();
    }
}