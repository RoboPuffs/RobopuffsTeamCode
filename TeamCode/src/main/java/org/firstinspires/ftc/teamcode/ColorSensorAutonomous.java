package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name = "color sensor test", group = "TeleOp")
public class  ColorSensorAutonomous extends OpMode {

    RobotHardware robot = new RobotHardware();
    public int cBlueValue, cRedValue, cGreenValue;

    /*
    private void moveForward(){
        robot.frontLeftMotor.setPower(.5);
        robot.frontRightMotor.setPower(-.5);
        robot.backLeftMotor.setPower(.5);
        robot.backRightMotor.setPower(-.5);

    }
    */

    @Override
    public void init() {

        telemetry.addData("STATUS", "Beginning Initialization");

        //have to change to color values for yellow mineral
        cBlueValue = 255;
        cRedValue = 205;
        cGreenValue = 53;

        telemetry.addData("STATUS", "Initialized");

        robot.init(hardwareMap);

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

        /*detecting minerals with color sensor
        if(robot.colorSensor.blue() <= cBlueValue && robot.colorSensor.red() >= cRedValue && robot.colorSensor.green() >= cGreenValue) {

            telemetry.addData("Mineral", "Yellow");
        }
        else {
            telemetry.addData("Mineral", "Not Yellow");

        }
        */

    }


}
