package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by isaac.blandin on 3/8/18.
 */
@TeleOp(name = "twoMotorTank")
public class twoMotorTankDrive extends LinearOpMode {

    DcMotor right;
    DcMotor left;

    @Override
    public void runOpMode(){

        right = hardwareMap.dcMotor.get("right");
        left = hardwareMap.dcMotor.get("left");

        right.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {

            right.setPower(-gamepad1.right_stick_y);
            left.setPower(-gamepad1.left_stick_y);

        }
        stop();
    }
}
