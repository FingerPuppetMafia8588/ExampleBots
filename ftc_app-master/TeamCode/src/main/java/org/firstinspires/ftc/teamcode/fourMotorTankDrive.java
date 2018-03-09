package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by isaac.blandin on 3/9/18.
 */
@TeleOp(name = "fourMotorTank")
public class fourMotorTankDrive extends LinearOpMode {

    DcMotor rightFront;
    DcMotor rightBack;
    DcMotor leftFront;
    DcMotor leftBack;

    double right;
    double left;

    @Override
    public void runOpMode(){

        rightFront = hardwareMap.dcMotor.get("rf");
        rightBack = hardwareMap.dcMotor.get("rb");
        leftFront = hardwareMap.dcMotor.get("lf");
        leftBack = hardwareMap.dcMotor.get("lb");

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while(opModeIsActive()){

            right = -gamepad1.right_stick_y;
            left = -gamepad1.left_stick_y;

            rightFront.setPower(right);
            rightBack.setPower(right);

            leftFront.setPower(left);
            leftBack.setPower(left);

        }
        stop();
    }
}
