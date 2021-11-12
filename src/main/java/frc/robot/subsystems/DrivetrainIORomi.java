// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.sensors.RomiGyro;

/** Add your docs here. */
public class DrivetrainIORomi implements DrivetrainIO {  
    private final Spark m_leftMotor = new Spark(0);
    private final Spark m_rightMotor = new Spark(1);
    private final RomiGyro m_gyro = new RomiGyro();
    private final Encoder m_leftEncoder = new Encoder(4, 5);
    private final Encoder m_rightEncoder = new Encoder(6, 7);

    public void updateInputs(DrivetrainIOInputs inputs) {
        inputs.leftPositionRadians = m_leftEncoder.get();
        inputs.rightPositionRadians = m_rightEncoder.get();
        inputs.gyroPositionRadians = m_gyro.getAngleZ();
    }

    public void setOutputs(double leftPercent, double rightPercent) {
        m_leftMotor.set(leftPercent);
        m_rightMotor.set(rightPercent);
    }
  
    public void resetEncoders() {
        m_leftEncoder.reset();
        m_rightEncoder.reset();
    }
  
    public void resetGyro() {
        m_gyro.reset();
    }
}
