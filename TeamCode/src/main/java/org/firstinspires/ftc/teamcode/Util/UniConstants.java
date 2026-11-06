package org.firstinspires.ftc.teamcode.Util;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;

public class UniConstants {
    // --| Constants on the DriverHub |-- \\
    private static final PoseFactory p = PoseFactory.radians();
    public static final String FrontLeftMotor = "FLM";    // Con Motor 1
    public static final String FrontRightMotor = "FRM";    // Con Motor 0
    public static final String RearLeftMotor = "RLM";    // Con Motor 2
    public static final String RearRightMotor = "RRM";    // Con Motor 3
    public static final String PinPointOdometry = "POC";    // I2C Con Port 1
    public static final String IntakeMotor = "INM";     // Exp Motor 0
    public static final String LimeLight = "LLT"; //
    // --| Pathing Constants |-- \\


    public static final Pose startPose = p.of(0, 12, 0);
    public static final Pose park = p.of(24, 36, 90);

}
