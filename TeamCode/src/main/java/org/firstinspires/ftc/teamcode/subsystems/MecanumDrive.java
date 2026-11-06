package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Util.UniConstants;

public class MecanumDrive {
    private DcMotor frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;
    private IMU imu;
    public void init(HardwareMap hMap) {
        frontLeftMotor = hMap.get(DcMotor.class, UniConstants.FrontLeftMotor);
        frontRightMotor = hMap.get(DcMotor.class, UniConstants.FrontRightMotor);
        rearLeftMotor = hMap.get(DcMotor.class, UniConstants.RearLeftMotor);
        rearRightMotor = hMap.get(DcMotor.class, UniConstants.RearRightMotor);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Field Orientation
        imu = hMap.get(IMU.class, "imu");


        RevHubOrientationOnRobot revOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP);

        imu.initialize(new IMU.Parameters(revOrientation));
    }

    // 1 = Red side, 2 = Blue side
    public void drive(double forward, double strafe, double rotate) {
        double frontLeftPower = forward + strafe + rotate;
        double rearLeftPower = forward - strafe + rotate;
        double frontRightPower = forward - strafe - rotate;
        double rearRightPower = forward + strafe - rotate;

        double maxPower = 1.0;
        double maxSpeed = 1.0; // for outreach events, to limit speed

        maxPower = Math.max(maxPower, Math.abs(frontLeftPower));
        maxPower = Math.max(maxPower, Math.abs(rearLeftPower));
        maxPower = Math.max(maxPower, Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(rearRightPower));

        frontLeftMotor.setPower(maxSpeed * (frontLeftPower / maxPower));
        rearLeftMotor.setPower(maxSpeed * (rearLeftPower / maxPower));
        frontRightMotor.setPower(maxSpeed * (frontRightPower / maxPower));
        rearRightMotor.setPower(maxSpeed * (frontRightPower / maxPower));
    }

    public void driveFieldRelative(double forward, double strafe, double rotate) {
        double theta = Math.atan2(forward, strafe);
        double r = Math.hypot(strafe, forward);

        theta = AngleUnit.normalizeRadians(theta -
                imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));

        double newForward = r * Math.sin(theta);
        double newStrafe = r * Math.cos(theta);

        this.drive(newForward, newStrafe, rotate);
    }
}
