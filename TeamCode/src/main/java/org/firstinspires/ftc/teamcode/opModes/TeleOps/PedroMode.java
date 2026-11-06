package org.firstinspires.ftc.teamcode.opModes.TeleOps;

import com.pedropathing.drivetrain.DrivePowers;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.teamcode.Util.UniConstants;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Camera;
import org.firstinspires.ftc.teamcode.subsystems.Innards.Intake;

@TeleOp(name = "PedroTest", group = "Testing")
public class PedroMode extends OpMode {
    DcMotor FRM, FLM, RRM, RLM, INT;
    Limelight3A limelight;
    Follower follower;
    Intake intake;
    Camera camera;
    boolean intakeOn = false;
    @Override
    public void init() {
        FRM = hardwareMap.get(DcMotor.class, UniConstants.FrontRightMotor);
        FLM = hardwareMap.get(DcMotor.class, UniConstants.FrontLeftMotor);
        RRM = hardwareMap.get(DcMotor.class, UniConstants.RearRightMotor);
        RLM = hardwareMap.get(DcMotor.class, UniConstants.RearLeftMotor);
        INT = hardwareMap.get(DcMotor.class, UniConstants.IntakeMotor);
        intake = new Intake(INT);
        follower = Constants.create(hardwareMap);
    }
    @Override
    public void loop() {
        double forward = -gamepad1.left_stick_y;
        double lateral = -gamepad1.left_stick_x;
        double turn = -gamepad1.right_stick_x;
        DrivePowers powers = ManualDrive.fieldCentric(
                forward,
                lateral,
                turn,
                follower.pose().heading()
        );

        if(gamepad1.aWasPressed()) {
            if(!intakeOn) {
                intakeOn = true;

            }
            else {
                intakeOn = false;
            }
        }
        if(intakeOn) {
            intake.intake();
        }
        else {
            intake.stopIntake();
        }
        follower.manual(powers);
        follower.update();
        telemetry.addData("X: ", follower.pose().x());
        telemetry.addData("Y: ", follower.pose().y());
        telemetry.addData("Heading", Math.toDegrees(follower.pose().heading()));
        telemetry.addLine();
    }

}
