package org.firstinspires.ftc.teamcode.subsystems.Outtake;

import static com.pedropathing.ivy.groups.Groups.parallel;

import com.pedropathing.ivy.Command;

import dev.nextftc.robot.Mechanism;

public class Outtake implements Mechanism {
    public NectarLever nLever;
    public NectarOuttake nOuttake;
    public PollenLever pLever;
    public PollenOuttake pOuttake;
    public Command shoot() {
        return parallel(
                nOuttake.on(),
                pOuttake.on(),
                nLever.on(),
                pLever.on()
        );
    }
    public Command openLever() {
        return parallel(
                nLever.on(),
                pLever.on()
        );
    }
    public Command outtakesOn() {
        return parallel(
                nOuttake.on(),
                pOuttake.on()
        );
    }
}
