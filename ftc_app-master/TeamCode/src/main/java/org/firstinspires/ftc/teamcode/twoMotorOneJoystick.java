package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by isaac.blandin on 3/9/18.
 */
@TeleOp(name = "twoMotorOneJoystick")
public class twoMotorOneJoystick extends LinearOpMode {

    DcMotor rightDrive;
    DcMotor leftDrive;

    double right;
    double left;

    double x;
    double y;

    @Override
    public void runOpMode(){

        rightDrive = hardwareMap.dcMotor.get("right");
        leftDrive = hardwareMap.dcMotor.get("left");

        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()){

            y = -gamepad1.left_stick_y;
            x = gamepad1.left_stick_x;

            right = y - x;
            left = y + x;

            rightDrive.setPower(right);
            leftDrive.setPower(left);


        }
        stop();
    }
}
