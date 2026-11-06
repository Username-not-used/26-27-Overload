package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Constants {
    public static Follower create(HardwareMap h) {
        return new Follower(
                new PinpointLocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("FLM");
        c.frontRightName.set("FRM");
        c.backLeftName.set("RLM");
        c.backRightName.set("RRM");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });
    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("POC");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(0.6655140373650498);
        c.yPodOffset.set(1.3763324106772117);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });
    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.28619762564152557);
                Controller secondaryTranslationalForward = Controller.proportional(0.10574237533314348);
                Controller primaryTranslationalLateral = Controller.proportional(0.5366427892285534);
                Controller secondaryTranslationalLateral = Controller.proportional(0.1982751712605305);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.015927414300935343));
                c.brake.set(Controller.proportionalFeedforward(0.013538302155795042));

                c.headingFeedback.set(Controller.proportional(4.283827195601008));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.0459206763178937, 0.011829111138602341));

                c.linearBrakeCoefficients.set(Matrix.diag(0.02037348915364895, 0.039786922935671896));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.004657522914066928, 0.002513767856237655));

                c.maxAchievableForwardVelocity.set(60.78388744186045);
                c.maxAchievableStrafeVelocity.set(48.80651341245593);
                c.naturalForwardDeceleration.set(54.220940576369884);
                c.naturalStrafeDeceleration.set(65.30511880342017);
            }
    );


}