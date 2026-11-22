package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.subsystems.Innards.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.NectarLever;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.NectarOuttake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.Outtake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.PollenLever;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.PollenOuttake;

import java.util.Collections;
import java.util.Set;

import dev.nextftc.robot.Mechanism;

public interface NextRobot {
    Intake intake = new Intake();
    Outtake outtake = new Outtake();
    default void periodic() {}
    default Set<Mechanism> getMechanisms() { return Set.of(intake, outtake); }
}
