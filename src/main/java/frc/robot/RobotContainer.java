package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.ResetArmCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
  Joystick leftJoystick = new Joystick(0);
  Joystick rightJoystick = new Joystick(1);
  JoystickButton raiseArm = new JoystickButton(leftJoystick, 2);
  JoystickButton lowerArm = new JoystickButton(rightJoystick, 2);
  JoystickButton resetArm = new JoystickButton(leftJoystick, 3); // button for resetting the arm

  Drivetrain drivetrain = new Drivetrain();
  Arm arm = new Arm();

  public RobotContainer() {
    drivetrain.setDefaultCommand(new InstantCommand(() -> drivetrain.drive(leftJoystick.getY(), rightJoystick.getY())));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    raiseArm.onTrue(new InstantCommand(() -> arm.moveArm(0.5)));
    lowerArm.onTrue(new InstantCommand(() -> arm.moveArm(-0.5)));
    resetArm.whenPressed(new ResetArmCommand(arm)); // button with the ResetArmCommand
  }

  public Command getAutonomousCommand() {
    return new AutoDrive(drivetrain, 0.5, 0.5, 2);
  }

  
}
