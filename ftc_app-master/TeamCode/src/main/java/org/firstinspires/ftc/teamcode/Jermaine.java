package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by isaac.blandin on 7/10/18.
 */

@TeleOp(name = "jermaine ")
public class Jermaine extends LinearOpMode {

    DcMotor rightDrive;
    DcMotor leftDrive;

    DcMotor collector;
    DcMotor rightFly;
    DcMotor leftFly;

    boolean flyWheels = false;

    @Override
    public void runOpMode(){

        rightDrive = hardwareMap.dcMotor.get("right_drive");
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        collector = hardwareMap.dcMotor.get("collector");
        rightFly = hardwareMap.dcMotor.get("right_fly");
        leftFly = hardwareMap.dcMotor.get("left_fly");

        rightFly.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFly.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightFly.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()){

            rightDrive.setPower(-gamepad1.right_stick_y);
            leftDrive.setPower(-gamepad1.left_stick_y);

            if (gamepad2.dpad_up){
                collector.setPower(1);
            } else if (gamepad2.dpad_down){
                collector.setPower(-1);
            } else {
                collector.setPower(0);
            }

            if (gamepad2.y){
                if (flyWheels){
                   flyWheels = false;
                } else {
                   flyWheels = true;
                }
            }

            if (flyWheels){
                rightFly.setPower(1);
                leftFly.setPower(1);
            } else {
                rightFly.setPower(0);
                leftFly.setPower(0);
            }

        }
        stop();
    }
}
