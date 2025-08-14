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
 * I created a moveForward() method as an example of how you can "encapsulate" code for reuse. It
 * takes in "arguments", in order
 *  - distance in ticks
 *  - motor power
 *  - frontRight motor object
 *  - frontLeft motor object
 *  - backRight motor object
 *  - backLeft motor object
 *
 * I also created an empty method called turnLeft() that you need to fill in with code and make use of.
 * Don't worry, the code you need is already in here, you just need to move it to the right place.
 * 
 * Note: this code also works around a bug in the VRS simulator that doesn't reset the encoder
 * position to zero when you would expect it to on a "real" FTC robot.
 */

@TeleOp(name = "Lesson3_starter_code", group = "Tutorial")
public class Lesson3_starter_code extends LinearOpMode {
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

        // I started coding the actions for you using the moveForward() method. But you need to fill in
        // the rest of the code to 
        if (opModeIsActive()) {
            // Here's where we are using the moveForward() method.
            // Notice I'm "passing in" everything it needs for the robot to move forward
            //  - distance, power (speed), frontRight, frontLeft, backRight, backLeft
            moveForward(4000, forwardSpeed, frontRight, frontLeft, backRight, backLeft);
            sleep(1000);
            
            // Turn Left
            // This chunk of code turns the robot left. But we are going to turn left twice. See if
            // you can move this left-turn chunk of code to the leftTurn() method
            double turnPower = 0.15;
            frontRight.setPower(turnPower);
            frontLeft.setPower(-turnPower);
            backRight.setPower(turnPower);
            backLeft.setPower(-turnPower);
            sleep(850);
            
            // Move Forward Again (hint, reuse the moveForward() method)
            // ADD CODE BELOW
            
            // Turn Left Again (hint, reuse the turnLeft() method)
            // ADD CODE BELOW
            
            // Move Forward One last time until you reach the flag
            // ADD CODE BELOW
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
     * Turns the robot left for a predefined duration. You need to fill in this method.
     */
    private void turnLeft(DcMotor frontRight, DcMotor frontLeft, DcMotor backRight, DcMotor backLeft) {
        // ADD CODE HERE
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

}
