package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.subsystems.Innards.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.NectarLever;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.NectarOuttake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.PollenLever;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.PollenOuttake;

import java.util.Collections;
import java.util.Set;

import dev.nextftc.robot.Mechanism;

public interface NextRobot {
    Intake intake = new Intake();
    NectarOuttake nOuttake = new NectarOuttake();
    PollenOuttake pOuttake = new PollenOuttake();
    public NectarLever nLever = new NectarLever();
    public PollenLever pLever = new PollenLever();
    default void periodic() {}
    default Set<Mechanism> getMechanisms() { return Set.of(intake, nOuttake, pOuttake, nLever, pLever); }
}
