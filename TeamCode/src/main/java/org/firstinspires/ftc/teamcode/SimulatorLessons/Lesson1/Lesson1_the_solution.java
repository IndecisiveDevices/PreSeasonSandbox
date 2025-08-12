package org.firstinspires.ftc.teamcode;

/** 
 * This file contains a solution to Lesson 1. In the starter code.
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Lesson1_the_solution", group = "Tutorial")
public class Lesson1_the_solution extends LinearOpMode {

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

            // car drives for 1.8 seconds
            sleep(1800);

            // stop car
            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);

            // Bonus challenge: make the robot spin in a circle for 4 seconds
            frontRight.setPower(1);
            frontLeft.setPower(-1);
            backRight.setPower(1);
            backLeft.setPower(-1);

            sleep(4000);
        }

    }

}
