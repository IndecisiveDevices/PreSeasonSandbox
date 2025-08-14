package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * This file contains a solution to Lesson 3 and builds on top of the encoder based solution in Lesson 2.
 * The course has changed to a "U" shaped course. This requires us to make 2 left turns, not just one.
 * We also have to move forward 3 times:
 *  1) Move forward
 *  2) Turn left
 *  3) Move forward
 *  4) Turn left
 *  5) Move forward to the flag.
 *  
 * Do you notice a pattern? We are repeating the same actions multiple times. But we don't want to
 * have to write or copy/paste the same code over and over again. This is where methods come in.
 *
 * 
 * Note: this code also works around a bug in the VRS simulator that doesn't reset the encoder
 * position to zero when you would expect it to on a "real" FTC robot.
 */

@TeleOp(name = "Lesson3_encoder_based_the_solution", group = "Tutorial")
public class Lesson3_encoder_based_the_solution extends LinearOpMode {
    // create DcMotor objects
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    @Override
    public void runOpMode()  {
        // initialize hardware variables
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");

        // Set motor direction
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        // define variable for easier programming
        double forwardSpeed = 0.5;

        waitForStart();

        // when started
        if (opModeIsActive()) {
            moveForward(4000, forwardSpeed, frontRight, frontLeft, backRight, backLeft);
            sleep(1000);

            turnLeft(frontRight, frontLeft, backRight, backLeft);
            sleep(1000);

            moveForward(5500, forwardSpeed, frontRight, frontLeft, backRight, backLeft);
            sleep(1000);

            turnLeft(frontRight, frontLeft, backRight, backLeft);
            sleep(1000);

            moveForward(6000, forwardSpeed, frontRight, frontLeft, backRight, backLeft);
            sleep(1000);
        }
    }

    /**
     * Moves the robot forward for a specified distance using encoder counts. Now all you need to do
     * to use it from other code is like this, and you can use it multiple times:
     *   moveForward(4000, 0.5, frontRight, frontLeft, backRight, backLeft);
     *
     * Note: Normally, we wouldn't need to pass in the motor objects, but the simulator seems
     *       to have ANOTHER BUG accessing the motor object properties in the class object.
     *       But, we can work around this by having the caller give us the motor objects.
     */
    private void moveForward(int distanceTicks, double power, DcMotor frontRight, DcMotor frontLeft, DcMotor backRight, DcMotor backLeft) {
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

        // Set target position
        // Note: Accommodating VRS simulator bug for encoder reset
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + distanceTicks);

        // loop until reach target position
        // Note: normally, we would use "while(frontLeft.isBusy())", but not in the VRS simulator
        while (frontLeft.getCurrentPosition() < frontLeft.getTargetPosition()) {
            frontRight.setPower(power);
            frontLeft.setPower(power);
            backRight.setPower(power);
            backLeft.setPower(power);
            // displays encoder position
            telemetry.addData("Moving Forward", frontLeft.getCurrentPosition());
            telemetry.update();
            sleep(50);
        }
        stopAllMotors(frontRight, frontLeft, backRight, backLeft);
    }

    /**
     * This method stops all motors. This is also another action that we perform a lot in the examples.
     */
    private void stopAllMotors(DcMotor frontRight, DcMotor frontLeft, DcMotor backRight, DcMotor backLeft) {
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }

    /**
     * Turns the robot left for a predefined duration.
     */
    private void turnLeft(DcMotor frontRight, DcMotor frontLeft, DcMotor backRight, DcMotor backLeft) {
        double turnPower = 0.15;
        frontRight.setPower(turnPower);
        frontLeft.setPower(-turnPower);
        backRight.setPower(turnPower);
        backLeft.setPower(-turnPower);
        sleep(850);
        stopAllMotors(frontRight, frontLeft, backRight, backLeft);
    }
}
