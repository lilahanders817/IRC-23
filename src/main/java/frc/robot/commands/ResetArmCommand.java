package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ResetArmCommand extends CommandBase {
    private final Arm arm;
    private final Timer movementTimer;
    private final double movementDuration = 2.0; // Adjust the duration

    public ResetArmCommand(Arm arm) {
        this.arm = arm;
        this.movementTimer = new Timer();
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        // Assuming arm is at zero when powered on
        arm.setZeroPosition();
        arm.resetToZero();

        // Start the timer for movement duration
        movementTimer.reset();
        movementTimer.start();
    }

    @Override
public void execute() {
    // Move the arm for time
    if (movementTimer.get() < movementDuration) {
        arm.moveArm(0.5); // Adjust speed
    } else {
        arm.stop(); // Stop the arm when time is reached
    }
}
    @Override
    public boolean isFinished() {
        //Finish command when timer exceeds time
        return movementTimer.get() >= movementDuration;
    }

    @Override
    public void end(boolean interrupted) {
        arm.stop();
    }
}

