package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Lesson4", group = "Tutorial")
public class Lesson3 extends LinearOpMode {
    // create DcMotor objects
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    @Override
    public void runOpMode() {
        // initialize hardware variables
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        // Set motor direction
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        // when started
        if (opModeIsActive()) {

            // drive forward
            frontRight.setPower(1);
            frontLeft.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(1);
            telemetry.addData("Driving", "Forward");
            telemetry.update();
            sleep(1100);

            // stop
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
            sleep(100);

            // turn left
            frontRight.setPower(0.5);
            frontLeft.setPower(-0.5);
            backRight.setPower(0.5);
            backLeft.setPower(-0.5);
            sleep(250);

            // drive forward
            frontRight.setPower(1);
            frontLeft.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(1);
            sleep(1500);

            // stop
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
            sleep(100);

            // turn left
            frontRight.setPower(0.5);
            frontLeft.setPower(-0.5);
            backRight.setPower(0.5);
            backLeft.setPower(-0.5);
            sleep(250);

            // drive forward
            frontRight.setPower(1);
            frontLeft.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(1);
            sleep(2000);

            // stop
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
            sleep(100);

        }
    }
}