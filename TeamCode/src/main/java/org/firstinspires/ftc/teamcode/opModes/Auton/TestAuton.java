package org.firstinspires.ftc.teamcode.opModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.follower.Follower;

import static org.firstinspires.ftc.teamcode.Util.UniConstants.*;

import org.firstinspires.ftc.teamcode.Util.Path;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.api.PoseFactory;

import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

@Autonomous
public class TestAuton extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.radians();
    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
        Scheduler.reset();
    }
    @Override
    public void start() {
        schedule(follow(follower, Path.Park()));
    }
    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
        telemetry.addData("X: ", follower.pose().x());
        telemetry.addData("Y: ", follower.pose().y());
        telemetry.addData("Heading", Math.toDegrees(follower.pose().heading()));
    }
}
