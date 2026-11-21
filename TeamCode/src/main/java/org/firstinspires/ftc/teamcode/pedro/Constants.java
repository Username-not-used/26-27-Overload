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
                Controller primaryTranslationalForward = Controller.proportional(-519.2030191189546);
                Controller secondaryTranslationalForward = Controller.proportional(-191.83164220427352);
                Controller primaryTranslationalLateral = Controller.proportional(0.7320456982730912);
                Controller secondaryTranslationalLateral = Controller.proportional(0.2704713248905962);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(1.3491974966311588));
                c.brake.set(Controller.proportionalFeedforward(1.146817872136485));

                c.headingFeedback.set(Controller.proportional(4.691954011116822));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.03783717654287991, 0.014048546778616826));

                c.linearBrakeCoefficients.set(Matrix.diag(0.0623377309930992, 0.10293466496625979));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.002869707132028179, 0.0011149464306709266));

                c.maxAchievableForwardVelocity.set(63.601260465935596);
                c.maxAchievableStrafeVelocity.set(49.057213621410845);
                c.naturalForwardDeceleration.set(60.0);//45.94091501961449
                c.naturalStrafeDeceleration.set(61.63176450451228);
                c.cosineScale.set(true);
            }
    );


}