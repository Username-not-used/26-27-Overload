package org.firstinspires.ftc.teamcode.Util;

import static com.pedropathing.api.Paths.line;
import static org.firstinspires.ftc.teamcode.Util.UniConstants.*;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;

public class Path {
    public static com.pedropathing.paths.Path Park() {
        return line(startPose, park).linear(startPose, park);
    }
}
