package org.firstinspires.ftc.teamcode.Util;

import static com.pedropathing.api.Paths.line;
import static org.firstinspires.ftc.teamcode.Util.UniConstants.*;
import static com.pedropathing.api.Paths.*;

import com.pedropathing.api.Paths;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;

import com.pedropathing.paths.Path;
public class Pathing {
    private final PoseFactory poseFactory = PoseFactory.degrees();
    public final Pose start = poseFactory.of(55, 8, 90);
    private final Pose path1 = poseFactory.of(22.75, 46.75, 90);
    private final Pose point2 = poseFactory.of(10.75, 106.75, 90);

    public Path path1() {
        return Paths.line(start, path1).constant(path1);
    }

    public Path path2() {
        return Paths.line(path1, point2).tangent();
    }
}
