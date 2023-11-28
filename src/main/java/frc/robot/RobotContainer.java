package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {
    Joystick leftJoystick = new Joystick(0);
    Joystick rightJoystick = new Joystick(1);
    JoystickButton raiseArmButton = new JoystickButton(leftJoystick, 2);
    JoystickButton lowerArmButton = new JoystickButton(rightJoystick, 2);
    JoystickButton stopArmButton = new JoystickButton(leftJoystick, 3);

    Drivetrain drivetrain = new Drivetrain();
    Arm arm = new Arm();

    public RobotContainer() {
        drivetrain.setDefaultCommand(new InstantCommand(() -> drivetrain.drive(leftJoystick.getY(), rightJoystick.getY())));
        configureButtonBindings();
    }

    private void configureButtonBindings() {
    raiseArmButton.whenHeld(new InstantCommand(() -> arm.moveArmUp()));
    lowerArmButton.whenHeld(new InstantCommand(() -> arm.moveArmDown()));
    stopArmButton.whenPressed(new InstantCommand(() -> arm.stop()));
}

  public Command getAutonomousCommand() {
    return new AutoDrive(drivetrain, arm);
  }

  
}
