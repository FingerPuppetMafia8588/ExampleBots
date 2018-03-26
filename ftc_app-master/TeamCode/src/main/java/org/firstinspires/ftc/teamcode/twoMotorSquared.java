package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by isaac.blandin on 3/26/18.
 */
@TeleOp(name = "two motor squared")
public class twoMotorSquared extends LinearOpMode {

    DcMotor right;
    DcMotor left;

    double rightVar;
    double leftVar;

    @Override
    public void runOpMode(){

        right = hardwareMap.dcMotor.get("r");
        left = hardwareMap.dcMotor.get("l");

        right.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()){

            if (gamepad1.right_stick_y > 0){
                rightVar = -Math.pow(gamepad1.right_stick_y, 2);
            } else {
                rightVar = Math.pow(gamepad1.right_stick_y, 2);
            }

            if (gamepad1.left_stick_y > 0){
                leftVar = -Math.pow(gamepad1.left_stick_y, 2);
            } else {
                leftVar = Math.pow(gamepad1.left_stick_y, 2);
            }

            right.setPower(rightVar);
            left.setPower(leftVar);

        }
        stop();
    }
}
