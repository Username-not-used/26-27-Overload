package org.firstinspires.ftc.teamcode.subsystems;

import static com.pedropathing.ivy.commands.Commands.infinite;

import androidx.annotation.NonNull;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.commands.Commands;

import org.firstinspires.ftc.teamcode.subsystems.Innards.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.NectarLever;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.NectarOuttake;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.PollenLever;
import org.firstinspires.ftc.teamcode.subsystems.Outtake.PollenOuttake;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class RobotSubsystem implements NextRobot {
    public Intake intake = new Intake();
    public NectarOuttake nOuttake = new NectarOuttake();
    public PollenOuttake pOuttake = new PollenOuttake();
    public NectarLever nLever = new NectarLever();
    public PollenLever pLever = new PollenLever();
    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() { return Set.of(intake, nOuttake, pOuttake, nLever, pLever); }
}
