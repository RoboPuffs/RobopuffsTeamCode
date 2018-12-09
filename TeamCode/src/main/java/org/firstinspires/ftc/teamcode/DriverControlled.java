package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Driver Controlled", group="TeleOp")

public class DriverControlled extends OpMode{

    // define robot
    RobotHardware robot   = new RobotHardware();


    //run once on init()
    @Override
    public void init() {
        telemetry.addData("STATUS", "Beginning Initialization");
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

        //defining gamepad variables
        //gamepad 1 will be used solely for robot movement
        //g1 stands for controls on gamepad 1
        double Y = gamepad1.right_stick_y;
        double X = gamepad1.right_stick_x;
        double R = gamepad1.left_stick_x;

        //gamepad 2 will be used solely for mineral mechanism
        //g2 stands for controls on gamepad 2
        boolean g2_LB = gamepad2.left_bumper;
        boolean g2_RB = gamepad2.right_bumper;
        boolean g2_DPAD_right = gamepad2.dpad_right;
        boolean g2_DPAD_left = gamepad2.dpad_left;
        boolean g2_DPAD_up = gamepad2.dpad_up;
        boolean g2_DPAD_down = gamepad2.dpad_down;


        //position value for servo emptying minerals position
        final double SERVO_EMPTIED_POSITION = .8;
        //position value for servo in holding minerals position
        final double SERVO_HOLDING_POSITION = 0.0;

        //robot movement
        robot.frontLeftMotor.setPower(Y + X - R);
        robot.backLeftMotor.setPower(Y - X - R);
        robot.frontRightMotor.setPower(-Y + X - R);
        robot.backRightMotor.setPower(-Y - X - R);

        /*code for intake of minerals via motor
        if(g2_LB)
            robot.mineralIntakeMotor.setPower(1.0);
        else
            robot.mineralIntakeMotor.setPower(0.0);
          */

        //will use right bumper to empty minerals into mineral holder
        /*and right trigger to move original mineral holder back to intake position
        if(g2_DPAD_right)
            robot.mineralOutputMotor.setPower(.25);
        else if(g2_DPAD_left)
            robot.mineralOutputMotor.setPower(-.25);
        else
            robot.mineralOutputMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    */


        if(g2_DPAD_up)
            robot.mainArmJointMotor.setPower(.4);
        else if(g2_DPAD_down)
            robot.mainArmJointMotor.setPower(-.4);
        else {
            robot.mainArmJointMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.mainArmJointMotor.setPower(0);
        }


        //right bumper will move servo to empty out stored minerals
        if(g2_RB)
            robot.mineralHolderArmServo.setPosition(SERVO_EMPTIED_POSITION);
        else
            robot.mineralHolderArmServo.setPosition(SERVO_HOLDING_POSITION);


    }

    // runs once
    @Override
    public void stop() {
        //could set servo arm back to zero etc.
    }
}
