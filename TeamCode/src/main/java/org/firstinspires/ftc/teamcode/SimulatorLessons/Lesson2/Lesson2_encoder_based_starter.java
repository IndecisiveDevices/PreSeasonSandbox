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
        // Why? Because we want to start counting from zero when we begin moving the robot.
        // The code below only sets one motor, but you should set all four motors.
        // ADD CODE BELOW HERE
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set mode to RUN_TO_POSITION
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // set target position
        // What is a target position? It is the position we want the motor to reach. 
        // The value of 1000 seems like it might not be enough to get around the first corner.
        // Can you think of a better value to use here?
        //
        // Note: The code below only sets the target position for the frontLeft motor. We don't
        // need to set the target position for the other motors. Can you think of a reason
        // why we don't need to set the target position for the other motors? 
        // UPDATE THE TARGET POSITION BELOW
        frontLeft.setTargetPosition(1000);

        // Below is what we call a "variable". It's name is "on".
        // Why use a variable? It makes the code easier to read and modify. Say, for example
        // you want to change the power of the motors, to slow down or speed up the robot.
        // Instead of changing the value in multiple places, you can change it in one place.
        // The value of 0.9 should be a good value for the solution. 
        // But feel free to  play around with it to see how it affects the robot's movement.
        // if you'd like.
        double on = 0.9;  

        waitForStart();

        // when started
        if (opModeIsActive()) {

            // This block of code is called a "while loop". It tells the program to keep doing something
            // until a certain condition is met. In this case, it keeps moving the robot
            // forward until the frontLeft motor reaches its target position.
            // Meaning, set the power of the motors to "on" for 50 milliseonds at a time until
            // the frontLeft motor reaches its target position.
            while (frontLeft.getCurrentPosition() < frontLeft.getTargetPosition()) {
                frontRight.setPower(on); // Hey, look! We've started using the variable "on" here! 
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

            // stop and reset encoder
            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            // turn left
            frontRight.setPower(1);
            frontLeft.setPower(-1);
            backRight.setPower(1);
            backLeft.setPower(-1);
            sleep(210);

            // set mode to RUN_TO_POSITION
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // set target position
            frontLeft.setTargetPosition(4500);

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
