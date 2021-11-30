// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.opencv.core.Mat;

/** Add your docs here. */
public class DrivetrainIOSparkMAX implements DrivetrainIO {
    private final CANSparkMax m_leftLeaderMotor = new CANSparkMax(12, MotorType.kBrushless);
    private final CANSparkMax m_rightLeaderMotor = new CANSparkMax(15, MotorType.kBrushless);
    private final CANSparkMax m_leftFollowerMotor = new CANSparkMax(3, MotorType.kBrushless);
    private final CANSparkMax m_rightFollowerMotor = new CANSparkMax(16, MotorType.kBrushless);
    private double afterEncoderReduction = 1.0 / ((9.0 / 62.0) * (18.0 / 30.0));
    private final CANEncoder leftEncoder = m_leftLeaderMotor.getEncoder();
    private final CANEncoder rightEncoder = m_rightLeaderMotor.getEncoder();
   

    public DrivetrainIOSparkMAX() {
    }

    public void updateInputs(DrivetrainIOInputs inputs) {
        inputs.leftPositionRadians = ((leftEncoder.getPosition() / afterEncoderReduction) * 2 * Math.PI);
        inputs.rightPositionRadians = ((rightEncoder.getPosition() / afterEncoderReduction) * 2 * Math.PI);
    }

    /** Drives the robot at the specified percentages (from -1 to 1). */
    public void setOutputs(double leftPercent, double rightPercent) {
    }

    /** Resets the encoder values to 0. */
    public void resetEncoders() {
    }

    /** Resets the gyro angle to 0. */
    public void resetGyro() {
    }
}
