package org.firstinspires.ftc.teamcode.opModes.TeleOps;

import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.groups.Groups.parallel;
import static com.pedropathing.ivy.groups.Groups.sequential;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.commands.Commands;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Util.Pathing;
import org.firstinspires.ftc.teamcode.Util.UniConstants;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.subsystems.RobotSubsystem;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;


@NextTeleop(name = "PedroTest", group = "Testing")
public class PedroMode extends NextOpMode {
    DcMotorEx FRM, FLM, RRM, RLM, INT, NOM, POM;
    Limelight3A limelight;
    Follower follower;
    RobotSubsystem robot;
    CommandGamepad gp1;
    Pathing pathing;
    public PedroMode(RobotSubsystem robot) {
        super(robot);
        this.robot = robot;
        /*FRM = hardwareMap.get(DcMotorEx.class, UniConstants.FrontRightMotor);
        FLM = hardwareMap.get(DcMotorEx.class, UniConstants.FrontLeftMotor);
        RRM = hardwareMap.get(DcMotorEx.class, UniConstants.RearRightMotor);
        RLM = hardwareMap.get(DcMotorEx.class, UniConstants.RearLeftMotor);
        INT = hardwareMap.get(DcMotorEx.class, UniConstants.IntakeMotor);
        NOM = hardwareMap.get(DcMotorEx.class, UniConstants.NectarOuttakeMotor);
        POM = hardwareMap.get(DcMotorEx.class, UniConstants.PollenOuttakeMotor);*/
        //limelight = hardwareMap.get(Limelight3A.class, UniConstants.Lim
        follower = Constants.create(hardwareMap);
        gp1 = new CommandGamepad(gamepad1);
    }
    public void start() {
        pathing = new Pathing();
        follower.setPose(pathing.start);
        gp1.a().toggleOnTrue(robot.intake.on());
        gp1.rightBumper().toggleOnTrue(robot.nOuttake.on());
        gp1.leftBumper().toggleOnTrue(robot.pOuttake.on());
        Command shoot = parallel(
            robot.nOuttake.on(),
                robot.pOuttake.on(),
                robot.nLever.on(),
                robot.pLever.on()
        );
        gp1.y().toggleOnTrue(shoot);
        gp1.b().toggleOnTrue(robot.intake.reverseTake());
        robot.nOuttake.reverseMotor();
        robot.pOuttake.reverseMotor();
        //gp1.b().onTrue(instant(()-> follower.setPose(pathing.start)));
    }
    @Override
    public void periodic() {
        if(gamepad1.dpadUpWasPressed()) {
            robot.nOuttake.increasePower();
            robot.pOuttake.increasePower();
        }
        if(gamepad1.dpadDownWasPressed()) {
            robot.nOuttake.decreasePower();
            robot.pOuttake.decreasePower();
        }
        /*DrivePowers powers = ManualDrive.fieldCentric(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x,
                follower.pose().heading()
        );
        follower.manual(powers);*/
        follower.manual(-gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x);
        follower.update();
        telemetry.addData("X: ", follower.pose().x());
        telemetry.addData("Y: ", follower.pose().y());
        telemetry.addData("Heading", Math.toDegrees(follower.pose().heading()));
        telemetry.addData("Outtake Power: ", robot.nOuttake.getPower());
    }


}
