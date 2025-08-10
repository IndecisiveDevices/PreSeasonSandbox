package org.firstinspires.ftc.teamcode;

/** 
 * This file contains a solution to Lesson 2 based largely on the solution
 * provided in the VRS Simulator for Lesson 1. VRS Simulator did not provide
 * a time-based solution for Lesson 2, but this lesson was added to show
 * how there can be multiple solutions to the same problem. 
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Lesson2_time_based_the_solution", group = "Tutorial")
public class Lesson2_time_based_the_solution extends LinearOpMode {

    // create DcMotor objects
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    @Override
    public void runOpMode() {
        // Initialize the hardware variables
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");

        // Set motor direction
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Run until the end of the match (driver presses STOP)
        if (opModeIsActive()) {
            // Put run blocks here.
            frontRight.setPower(1);
            frontLeft.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(1);

            // telemetry data displayed in terminal
            telemetry.addData("Driving", "Forward");
            telemetry.update();

            // car drives for 1.55 seconds
            sleep(1550);

            // stop car
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);

            // telemetry data displayed in terminal
            telemetry.addData("Turning", "Left");
            telemetry.update();

            // Set the robot motors to a lower number than we would if
            // we were driving forward, so it turns slowly and smoothly. 
            // This makes it easier to predict and fine-tune how long we need
            // to set the sleep time for.
            frontRight.setPower(0.15);
            frontLeft.setPower(-0.15);
            backRight.setPower(0.15);
            backLeft.setPower(-0.15);

            // approximately 0.85 seconds to turn left. 
            sleep(850);

            // Go to flag
            frontRight.setPower(1);
            frontLeft.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(1);

            // telemetry data displayed in terminal
            telemetry.addData("Driving", "Forward");
            telemetry.update();

            // car drives for 1.55 seconds
            sleep(1550);
        }
    }
}
