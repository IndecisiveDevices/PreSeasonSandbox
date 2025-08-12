package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/** 
 * This file contains a partial solution to Lesson 2 based largely on the solution
 * provided in the VRS Simulator for Lesson 2. The concept of using encoders
 * is introduced here, allowing for more precise control of the robot's movements.
 * What is an encoder? It is a device that measures the rotation of the motor shaft,
 * allowing us to know how far the robot has moved. This is useful for tasks that require
 * precise positioning, such as moving to a specific distance or turning to a specific angle.
 * 
 * This solution should demonstrate how to use encoders to move the robot forward
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

        // stop and reset encoder
        // set mode to STOP_AND_RESET_ENCODER to set position to zero
        // Why? Because we want to start counting from zero when we begin moving the robot.
        // The code below only sets one motor, but you should set all four motors.
        // ADD CODE BELOW HERE
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set mode to RUN_TO_POSITION for all motors
        // What does RUN_TO_POSITION mean? It means the motor will run to a specific position
        // that we set later. This is useful for precise movements. 
        // But we need to set the mode for all motors, not just one.
        // ADD CODE BELOW HERE
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // set target position
        // What is a target position? It is the position we want the motor to reach. 
        // The value of 1000 seems like it might not be enough to get around the first corner.
        // Can you think of a better value to use here?
        //
        // BTW, the code below only sets the target position for the frontLeft motor. We don't
        // need to set the target position for the other motors. Can you think of a reason
        // why we don't need to set the target position for the other motors?
        // 
        // Note: the VRS simulator has a bug that doesn't STOP_AND_RESET_ENCODER when like
        // you would expect (see lines 29-32). On a "real" FTC robot, you would set the target position like this:
        //    frontLeft.setTargetPosition(1000);
        // However, because of the bug, we are going to set the target position
        // to the current position plus the value.
        frontLeft.setTargetPosition(frontLeft.getCurrentPosition() + 1000); // UPDATE THIS VALUE FROM 1000 TO SOMETHING BIGGER 

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

            // we need to stop before turn starting our left turn. shut off the motors.
            // hint, set motors power to 0.
            // ADD CODE BELOW HERE

            sleep(100);

            // Now, turn left
            // Refer to the Lesson2_time_based_the_solution.java file for how to turn left. 
            // if you've forgotten. Don't forget that the motors power and sleep time both need
            // to be adjusted until your bot is facing towards the flag.
            // ADD CODE BELOW HERE

            sleep(210); 

            // Now that we're turned and hopefully facing the flag, we need to move foward.

            // stop and reset encoder
            // Hmm...we did this before in this code file. Let's do it again to reset the encoder position
            // ADD CODE BELOW HERE

            // set mode to RUN_TO_POSITION
            // We did this earlier in the code as well. See if you can find it and add the same code here.
            // ADD CODE BELOW HERE

            // set target position
            //This is something we did earlier in the code as well. See you can find where we are
            // using setTargetPosition() and add the same code here.
            // ADD CODE BELOW HERE

            // loop until target position
            // remember that "while loop" we used earlier? We can use it again here to move the robot forward.
            // See if you can add the code to move the robot forward until it reaches the flag.
            // FIX THE CODE BELOW
            while ( REPLACE_ME < REPLACE_ME) {
                // ADD CODE BELOW HERE
                
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
