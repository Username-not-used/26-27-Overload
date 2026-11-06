package org.firstinspires.ftc.teamcode;

public class RobotLocation {
    private double angleRadians;
    public RobotLocation(double angleRadians) {
        this.angleRadians = angleRadians;
    }
    public double getHeading() {
        double angle = this.angleRadians;
        while(angle > Math.PI) {
            angle -= 2*Math.PI;
        }
        while(angle < -Math.PI) {
            angle += 2*Math.PI;
        }
        return Math.toDegrees(angle);
    }
    public void setAngleRadians(double angleRadians) {
        this.angleRadians = Math.toRadians(angleRadians);
    }
    public void turn(double angleRadians) {
        this.angleRadians += Math.toRadians(angleRadians);
    }
    public double getAngleRadians() {
        return angleRadians;
    }
}
