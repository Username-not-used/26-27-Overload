package org.firstinspires.ftc.teamcode.subsystems;
import androidx.annotation.NonNull;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import java.util.List;

public class Camera {
    public Limelight3A limelight;
    //public AprilTagDetection tagDetection = new AprilTagDetection();
    public IMU imu;
    YawPitchRollAngles angles;
    LLResult camResult;
    public Camera(Limelight3A limelight, HardwareMap hMap) {
        RevHubOrientationOnRobot hubOrientation = new
                RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP);
        this.limelight = limelight;
        imu = hMap.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(hubOrientation));
        angles = imu.getRobotYawPitchRollAngles();
        camResult = limelight.getLatestResult();
        if(camResult != null && camResult.isValid()) {
            Pose3D botPose = camResult.getBotpose_MT2();
        }

    }

    /*public int result() {
        List<AprilTagClusterDetection> camResults;
    }*/

    @NonNull
    @Override
    public String toString() {
        return "\n|-- Camera Data --|" +
                "\nTx: " + camResult.getTx() +
                "\nTy: " + camResult.getTy() +
                "\nTa: " + camResult.getTa();


    }

}
