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
        double g1_rightstick_y = gamepad1.right_stick_y;
        double g1_rightsick_x = gamepad1.right_stick_x;
        double g1_leftstick_x = gamepad1.left_stick_x;

        //gamepad 2 will be used solely for mineral mechanism
        //g2 stands for controls on gamepad 2
        boolean g2_LB = gamepad2.left_bumper; //for mineral intake
        boolean g2_RB = gamepad2.right_bumper; //for servo emptying minerals at end of arm
        boolean g2_DPAD_right = gamepad2.dpad_right; //for emptying minerals into mineral compartment
        boolean g2_DPAD_up = gamepad2.dpad_up; //for moving arm to put minerals into lander
        boolean g2_DPAD_down = gamepad2.dpad_down; //for reversing arm to come back to original position

        final double SERVO_EMPTIED_POSITION = .8;  //position value for servo emptying minerals position
        final double SERVO_HOLDING_POSITION = 0.0; //position value for servo in holding minerals position
        final double MINERAL_HOLDING_START_POSITION= 0.0;


        //robot movement
        robot.frontLeftMotor.setPower(g1_rightstick_y + g1_rightsick_x - g1_leftstick_x);
        robot.backLeftMotor.setPower(g1_rightstick_y - g1_rightsick_x - g1_leftstick_x);
        robot.frontRightMotor.setPower(-g1_rightstick_y + g1_rightsick_x - g1_leftstick_x);
        robot.backRightMotor.setPower(-g1_rightstick_y - g1_rightsick_x - g1_leftstick_x);

        /*code for intake of minerals via motor
        if(g2_LB)
            robot.mineralIntakeMotor.setPower(1.0);
        else
            robot.mineralIntakeMotor.setPower(0.0);
        */


        robot.mineralOutputServo.setPosition(MINERAL_HOLDING_START_POSITION);


        //using up and down buttons on dpad to move main arm motor on back of robot
        if(g2_DPAD_up)
            robot.mainArmJointMotor.setPower(.6);
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

    }
}
