package org.firstinspires.ftc.teamcode.opModes.TeleOps;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RobotLocation;
import org.firstinspires.ftc.teamcode.Util.UniConstants;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

@TeleOp(name = "Test", group = "Testing")
public class TestMode extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    DcMotor FLM, RLM, FRM, RRM;
    CRServo servo;
    double forward, strafe, rotate;
    boolean robotDrive = false;
    RobotLocation robotLocation;
    @Override
    public void init() {
        drive.init(hardwareMap);
        FLM = hardwareMap.get(DcMotor.class, UniConstants.FrontLeftMotor);
        RLM = hardwareMap.get(DcMotor.class, UniConstants.RearLeftMotor);
        FRM = hardwareMap.get(DcMotor.class, UniConstants.FrontRightMotor);
        RRM = hardwareMap.get(DcMotor.class, UniConstants.RearRightMotor);
    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            robotDrive = true;
        }
        else if(gamepad1.b) {
            robotDrive = false;
        }
        if(gamepad1.xWasPressed()) {
            servo.setPower(0.7);
        }
        forward = gamepad1.left_stick_y;
        strafe = -gamepad1.left_stick_x;
        rotate = -gamepad1.right_stick_x;
        if(robotDrive) {
            drive.drive(forward, strafe, rotate);
        }
        else {
            drive.driveFieldRelative(forward, strafe, rotate);
        }
        telemetry.addData("Gamepad 1 A:", gamepad1.a);
    }
}
