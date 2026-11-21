package org.firstinspires.ftc.teamcode.subsystems.Outtake;
import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.Util.UniConstants;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.hardware.actuators.NextMotor;
public class PollenOuttake implements Mechanism {
    private NextMotor motor = new NextMotor(UniConstants.PollenOuttakeMotor);
    private double power = 0.5;
    public Command on() {
        return infinite(() -> motor.setThrottle(power)).setEnd(interrupted -> motor.setThrottle(0));
    }
    public void increasePower() {
        power = Math.min(1.0, power + 0.1);
    }
    public void decreasePower() {
        power = Math.max(0.0, power - 0.1);
    }
    public void reverseMotor() {
        motor.setDirection(NextMotor.Direction.REVERSE);
    }
    public double getPower() {
        return power;
    }
}
