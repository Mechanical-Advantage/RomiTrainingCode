// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/** Add your docs here. */
public class DrivetrainIOSparkMAX implements DrivetrainIO {
    private final CANSparkMax m_leftLeaderMotor = new CANSparkMax(12, MotorType.kBrushless);
    private final CANSparkMax m_rightLeaderMotor = new CANSparkMax(15, MotorType.kBrushless);
    private final CANSparkMax m_leftFollowerMotor = new CANSparkMax(3, MotorType.kBrushless);
    private final CANSparkMax m_rightFollowerMotor = new CANSparkMax(16, MotorType.kBrushless);

    public DrivetrainIOSparkMAX() {
    }

    public void updateInputs(DrivetrainIOInputs inputs) {
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
