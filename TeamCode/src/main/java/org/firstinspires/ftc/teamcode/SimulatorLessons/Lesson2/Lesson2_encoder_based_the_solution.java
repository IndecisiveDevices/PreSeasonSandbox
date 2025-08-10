package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
/** 
 * This file contains a solution to Lesson 2 based largely on the solution
 * provided in the VRS Simulator for Lesson 2. The concept of using encoders
 * is introduced here, allowing for more precise control of the robot's movements.
 * What is an encoder? It is a device that measures the rotation of the motor shaft,
 * allowing us to know how far the robot has moved. This is useful for tasks that require
 * precise positioning, such as moving to a specific distance or turning to a specific angle.
 * 
 * This solution demonstrates how to use encoders to move the robot forward
 * to a specific position and then turn left, showcasing the benefits of using
 * encoders for accurate positioning compared to time-based solutions.
 * The other new concept introduced in this lesson is the creation and use of variables
 * to make the code easier to read and modify. This is a fundamental programming practice
 * that helps in maintaining and understanding the code better.
 * 
 * Note: this code also works around a bug in the VRS simulator that doesn't reset the encoder
 * position to zero when you would expect it to on a "real" FTC robot.
 */

@TeleOp(name = "Lesson2_encoder_based_starter", group = "Tutorial")
public class Lesson2_encoder_based_starter extends LinearOpMode {
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

        // set mode to STOP_AND_RESET_ENCODER to set position to zero
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set mode to RUN_TO_POSITION
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // set target position
        // Note, the VRS simulator has a bug that doesn't STOP_AND_RESET_ENCODER when like
        // you would expect (see lines 29-32). On a "real" FTC robot, you would set the target position like this:
        //    frontLeft.setTargetPosition(4700);
        // However, because of the bug, we are going to set the target position
        // to the current position plus 4700.
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 4700);

        // define variable for easier programming
        int on = 0.9;

        waitForStart();

        // when started
        if (opModeIsActive()) {

            // loop until reach target position
            while (frontLeft.getCurrentPosition() < frontLeft.getTargetPosition()) {
                frontRight.setPower(on);
                frontLeft.setPower(on);
                backRight.setPower(on);
                backLeft.setPower(on);
                // displays encoder position
                telemetry.addData("Position", frontLeft.getCurrentPosition());
                telemetry.update();
                sleep(50);
            }

            // turn left
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
            sleep(100);

            // turn left
            frontRight.setPower(0.15);
            frontLeft.setPower(-0.15);
            backRight.setPower(0.15);
            backLeft.setPower(-0.15);
            sleep(850);

            // stop and reset encoder
            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            // set mode to RUN_TO_POSITION
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // set target position
            frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 4700); // on "real" robot, you would just use setTargetPosition(4700)

            // loop until target position
            while (frontLeft.getCurrentPosition() < frontLeft.getTargetPosition()) {
                frontRight.setPower(on);
                frontLeft.setPower(on);
                backRight.setPower(on);
                backLeft.setPower(on);
                // display encoder position
                telemetry.addData("Position", frontLeft.getCurrentPosition());
                telemetry.update();
                sleep(50);
            }

            // stop car
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
            sleep(2000);

        }
    }
}
