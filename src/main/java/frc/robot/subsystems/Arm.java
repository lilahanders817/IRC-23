package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    MotorController armVictor;
    Timer movementTimer;
    private double zeroPosition = 0.0;

    // Duration for which the arm should move (seconds)
    private final double movementDuration = 2.0;

    public Arm() {
        armVictor = new Victor(2);
        movementTimer = new Timer();
    }

    public void moveArm(double speed) {
        armVictor.set(speed);
    }

    public void stop() {
        armVictor.stopMotor();
    }

    //Move arm for a time
    public void moveArmForDuration(double speed) {
        movementTimer.reset();
        movementTimer.start();

        while (movementTimer.get() < movementDuration) {
            armVictor.set(speed);
        }

        stop(); //Stop arm after the time
        movementTimer.stop();
    }

    //set the zero position to the lowest point of the arm
    public void setZeroPosition() {
        zeroPosition = 0.0; // Make value of the lowest point of the arm 
    }

    //Reset the arm to the zero position
    public void resetToZero() {
        moveArm(zeroPosition);
    }
}
