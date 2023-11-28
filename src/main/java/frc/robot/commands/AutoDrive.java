package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm;

public class AutoDrive extends CommandBase {
    private final Drivetrain drivetrain;
    private final Arm arm;
    private final Timer timer = new Timer();

    public AutoDrive(Drivetrain dt, Arm arm) {
        drivetrain = dt;
        this.arm = arm;
        addRequirements(dt, arm);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        double elapsedTime = timer.get();

        // Move forward for 5 seconds
        if (elapsedTime <= 5.0) {
            drivetrain.drive(0.5, 0.5); // Adjust speed
        } else if (elapsedTime <= 8.0) {
            // Turn left for 90 degrees
            drivetrain.drive(0.5, -0.5); // Adjust speed
        } else if (elapsedTime <= 11.0) {
            // Move forward for 3 seconds
            drivetrain.drive(0.5, 0.5); // Adjust speed 
        } else if (elapsedTime <= 13.0) {
            // Turn right for 90 degrees
            drivetrain.drive(-0.5, 0.5); // Adjust speed
        } else if (elapsedTime <= 14.5) {
            // Move forward for 1.5 seconds
            drivetrain.drive(0.5, 0.5); // Adjust speed
        } else if (elapsedTime <= 15.0) {
            // Raise arm
            arm.moveArmUp(); // Adjust method as needed
        } else {
            // Stop drivetrain and arm
            drivetrain.stop();
            arm.stop();
        }
    }

    @Override
    public boolean isFinished() {
        // Finish after 15 seconds
        return timer.get() > 15.0;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
        arm.stop();
    }
}
