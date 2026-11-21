package org.firstinspires.ftc.teamcode.subsystems.Innards;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.Util.UniConstants;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Intake implements Mechanism {
    private final NextMotor motor = new NextMotor(UniConstants.IntakeMotor);
    public Command on() {
        return infinite(() -> motor.setThrottle(1.0)).setEnd(interrupted -> motor.setThrottle(0.0));
    }
    public Command reverseTake() {
        return infinite(() -> motor.setThrottle(-1.0)).setEnd(interrupted -> motor.setThrottle(0.0));
    }
}
