package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by isaac.blandin on 3/9/18.
 */

@TeleOp(name = "name here")
@Disabled
public class teleOpTemplate extends LinearOpMode {

    //declare hardware here
    DcMotor motorName;
    Servo servoName;

    @Override
    public void runOpMode(){
        //all code for hardware identification and commands for during initialization here

        motorName = hardwareMap.dcMotor.get("motor name");
        servoName = hardwareMap.servo.get("servo name");

        motorName.setDirection(DcMotorSimple.Direction.REVERSE);
        motorName.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //all code after this command runs after start is pressed
        waitForStart();

        while (opModeIsActive()){
            //all code for during main teleop loop here

            motorName.setPower(gamepad1.left_stick_y);

            if (gamepad1.a) {
                servoName.setPosition(1);
            } else if (gamepad1.b){
                servoName.setPosition(0);
            }

        }
        stop();
    }
}
