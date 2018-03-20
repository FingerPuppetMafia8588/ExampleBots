package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by isaac.blandin on 3/20/18.
 */
@TeleOp(name = "Mecanum")
public class Mecanum extends LinearOpMode {

    DcMotor rightFront;
    DcMotor rightBack;
    DcMotor leftFront;
    DcMotor leftBack;

    double x1;
    double x2;
    double y1;

    double rfVar;
    double rbVar;
    double lfVar;
    double lbVar;

    double max;

    @Override
    public void runOpMode(){

        rightFront = hardwareMap.dcMotor.get("rf");
        rightBack = hardwareMap.dcMotor.get("rb");
        leftFront = hardwareMap.dcMotor.get("lf");
        leftBack = hardwareMap.dcMotor.get("lb");

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()){

            x1 = gamepad1.left_stick_x;
            y1 = -gamepad1.left_stick_y;
            x2 = gamepad1.right_stick_x;

            rfVar = 0;
            rbVar = 0;
            lfVar = 0;
            lbVar = 0;

            rfVar += y1;
            rbVar += y1;
            lfVar += y1;
            lbVar += y1;

            rfVar -= x1;
            rbVar += x1;
            lfVar += x1;
            lbVar -= x1;

            rfVar -= x2;
            rbVar -= x2;
            lfVar += x2;
            lbVar += x2;

            max = rfVar;
            if (rbVar > max){
                max = rbVar;
            }
            if (lfVar > max){
                max = lfVar;
            }
            if (lbVar > max){
                max = lbVar;
            }

            rightFront.setPower(rfVar/max);
            rightBack.setPower(rbVar/max);
            leftFront.setPower(lfVar/max);
            leftBack.setPower(lbVar/max);

        }
        stop();
    }
}
