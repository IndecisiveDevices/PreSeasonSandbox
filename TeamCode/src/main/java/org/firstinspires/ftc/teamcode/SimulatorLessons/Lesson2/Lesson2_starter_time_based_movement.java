package org.firstinspires.ftc.teamcode;

/** 
 * This file contains a solution to Lesson 1 as the starter code. If you remember
 * the solution uses sleep to move the robot forward for a certain amount of time.
 * But how do we turn the robot?
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Lesson2_starter_without_encoder", group = "Tutorial")
public class Lesson2_starter_time_based_movement extends LinearOpMode {

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

            // car drives for 1.8 seconds right now, but the course has changed.
            // How can you fix this?
            sleep(1800);    // UPDATE THIS SLEEP TIME VALUE

            // stop car
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);

            // telemetry data displayed in terminal
            telemetry.addData("Turning", "Left");
            telemetry.update();

            // Oh no, we're spinning in circles! How can we fix this to just turn left?
            // hints: 
            //   - We should to set the motors to a lower power than we would if we were driving forward.
            //     You can set the power to numbers between 0 and 1 or -1, like 0.15 and -0.15
            //   - This makes it easier to predict and fine-tune how long we need to set the sleep time for.
            // UPDATE THE POWER VALUES BELOW
            frontRight.setPower(1);
            frontLeft.setPower(-1);
            backRight.setPower(1);
            backLeft.setPower(-1);

            // approximately 4.0 seconds to turn left.
            sleep(4000);  // UPDATE THIS SLEEP TIME VALUE 

            // telemetry data displayed in terminal
            telemetry.addData("Driving", "Forward");
            telemetry.update();

            // Go to flag. Remember, we want to drive to the flag, not past it.
            // ADD CODE HERE TO DRIVE FORWARD TO THE FLAG

        }
    }
}
