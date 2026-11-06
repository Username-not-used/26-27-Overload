package org.firstinspires.ftc.teamcode.subsystems.Innards;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Intake {
    private DcMotor motor;
    public Intake(DcMotor motor) {
        this.motor = motor;
    }
    public void intake() {
        motor.setPower(0.9);
    }
    public void stopIntake() {
        motor.setPower(0.0);
    }
    public void pushOut() {
        motor.setPower(-0.9);
    }
}
