package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase {
    Drivetrain drivetrain;
    double leftSpeed; 
    double rightSpeed;
    Timer timer;
    double time;

    public AutoDrive(Drivetrain dt, double lS, double rS, double t) {
        drivetrain = dt;
        leftSpeed = lS;
        rightSpeed = rS;
        timer = new Timer();
        time = t;
        super.addRequirements(dt);
    }

    public void initialize(){
        timer.reset();
        timer.start();
    }

    public void execute() {
        drivetrain.drive(leftSpeed, rightSpeed);
    }

    public boolean isFinished() {
        return timer.get() > time;
    }

    public void end(boolean stop) {
    }
}