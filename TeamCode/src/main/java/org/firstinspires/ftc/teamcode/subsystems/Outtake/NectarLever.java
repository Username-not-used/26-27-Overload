package org.firstinspires.ftc.teamcode.subsystems.Outtake;

import static com.pedropathing.ivy.commands.Commands.infinite;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.Util.UniConstants;

import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class NectarLever implements Mechanism {
    private final NextServo servo = new NextServo(UniConstants.NectarOuttakeServo);
    public Command on() {
        return infinite(() -> servo.setPosition(0.5)).setEnd(interrupted -> servo.setPosition(0));
    }
    public double getServoPos() {
        return servo.getPosition();
    }
}
