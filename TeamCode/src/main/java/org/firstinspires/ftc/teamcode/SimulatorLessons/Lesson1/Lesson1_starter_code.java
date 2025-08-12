package org.firstinspires.ftc.teamcode;

/****
 * This file will get you started with meeting the goals of Lesson 1
 * It contains the minimum amount of code necessary to get you started.
 * Can you update the code to make the robot reach the flag? Look for the 
 * comments that says "ADD CODE CHANGES BELOW HERE".
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Lesson1_starter_code", group = "Tutorial")
public class Lesson1_starter_code extends LinearOpMode {

    // create DcMotor objects. These are the motors that move the robot wheels.
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    @Override

    public void runOpMode() {
        // Initialize the front motor hardware variables. 
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");

        // The back motors are not initialized. Can you initialize them?
        // ADD CODE CHANGES BELOW HERE
        
        // Set motors to reversse. This is because the motors are mounted in opposite directions.
        // Set front motor direction to reverse. 
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        // The backmotors need to be set to reverse too. Can you set them to reverse?
        // ADD CODE CHANGES BELOW HERE
        
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        if (opModeIsActive()) {
            // We need to give the motors power to make the robot move. This is
            // an example of setting the power of the front right motor to 1. But we 
            // have 3 more motors to set power to. Can you set the power of the other 3 motors?
            frontRight.setPower(1);
            // ADD CODE CHANGES BELOW HERE - 3 more motors need to be set to power 1

            // telemetry data is data that gets displayed in terminal. 
            telemetry.addData("Driving", "Forward");
            telemetry.update();

            // Now that you have power to all 4 motors, how long do you think the robot needs to drive forward
            // to reach the flag? The time is in milliseconds. 1000 milliseconds = 1 second.
            // the sleep command will make the robot drive for the amount of time you set. It's set to half a second now.
            // Can you change the time to make the robot reach the flag?
            sleep(500);  // UPDATE THIS VALUE 

            // stop car
            // Remember how we set the power of the motors to 1 to make the robot move? How do you think we can make the robot stop?
            // hint: we still use setPower() but what value do we set the power to?
            // ADD CODE CHANGES BELOW HERE


            // Bonus challenge: Can you make the robot spin in a circle for 4 seconds?
            // hint - right motors need to go forward and left motors need to go backwards.
            // ADD CODE CHANGES BELOW HERE

        }

    }

}
