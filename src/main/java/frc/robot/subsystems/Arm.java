package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    MotorController armVictor;

    public Arm() {
        armVictor = new Victor(2);
    }

    public void moveArm(double speed) {
        armVictor.set(speed);
    }
    
    public void stop() {
        armVictor.stopMotor();
    }
}