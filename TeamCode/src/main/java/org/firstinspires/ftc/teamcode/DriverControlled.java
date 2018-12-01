package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="DriverControlled", group="TeleOp")

public class DriverControlled extends OpMode{

    // define robot
    RobotHardware robot   = new RobotHardware();




    //run once on init()
    @Override
    public void init() {
        robot.init(hardwareMap);
        telemetry.addData("STATUS", "Initialized");
    }

    // loop on init()
    @Override
    public void init_loop() {
    }

    // code that runs once on start()
    @Override
    public void start() {
    }

    // loops on start(), main opMode
    @Override
    public void loop() {

        double Y = gamepad1.right_stick_y;
        double X = gamepad1.right_stick_x;
        double R = gamepad1.left_stick_x;
        boolean G2LB = gamepad2.left_bumper;
        boolean G2RB = gamepad2.right_bumper;
        boolean G1LB = gamepad1.left_bumper;
        boolean G1RB = gamepad1.right_bumper;


        //robot movement
        robot.frontLeftMotor.setPower(Y + X + R);
        robot.backLeftMotor.setPower(Y - X + R);
        robot.frontRightMotor.setPower(-Y + X + R);
        robot.backRightMotor.setPower(-Y -X + R);



        // code for intake of minerals via servo
        if(G2LB)
            robot.servoIntake.setPower(1.0);
        else if(G2RB)
            robot.servoIntake.setPower(-1.0);
        else
            robot.servoIntake.setPower(0.0);


        //movement of main arm motor
        if(G1LB)
            robot.armMotor.setPower(1.0);
        else if(G1RB)
            robot.armMotor.setPower(-1.0);
        else
            robot.armMotor.setPower(0);






    }

    // runs once on stop
    @Override
    public void stop() {
        //could set servo arm back to zero etc.
    }
}
