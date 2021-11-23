// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

//import java.lang.reflect.Method;
import java.util.function.Supplier;

public class ArcadeDriveCutPower extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final Supplier<Double> m_xaxisSpeedSupplier;
  private final Supplier<Double> m_zaxisRotateSupplier;
  private final Supplier<Boolean> cutPowerModeSupplier;

  /**
   * Creates a new ArcadeDrive. This command will drive your robot according to
   * the speed supplier lambdas. This command does not terminate.
   *
   * @param drivetrain           The drivetrain subsystem on which this command
   *                             will run
   * @param xaxisSpeedSupplier   Lambda supplier of forward/backward speed
   * @param zaxisRotateSuppplier Lambda supplier of rotational speed
   */
  public ArcadeDriveCutPower(Drivetrain drivetrain, Supplier<Double> xaxisSpeedSupplier,
      Supplier<Double> zaxisRotateSuppplier, Supplier<Boolean> cutPowerModeSupplier) {
    m_drivetrain = drivetrain;
    m_xaxisSpeedSupplier = xaxisSpeedSupplier;
    m_zaxisRotateSupplier = zaxisRotateSuppplier;
    addRequirements(drivetrain);
    this.cutPowerModeSupplier = cutPowerModeSupplier;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (this.cutPowerModeSupplier.get() == true)

    {
      m_drivetrain.arcadeDrive(m_xaxisSpeedSupplier.get() * .5, m_zaxisRotateSupplier.get() * .5);
    } else {
      m_drivetrain.arcadeDrive(m_xaxisSpeedSupplier.get(), m_zaxisRotateSupplier.get());
    }

    double gyroangle = m_drivetrain.getGyroAngleZ();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
