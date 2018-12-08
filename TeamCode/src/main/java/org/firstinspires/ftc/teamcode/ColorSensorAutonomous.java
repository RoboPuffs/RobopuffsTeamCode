package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "color sensor test", group = "Autonomous")
public class ColorSensorAutonomous extends OpMode {

    public RobotHardware Robot = new RobotHardware();
    public int cBlueValue, cRedValue, cGreenValue;

    public void forwardPosition(){
        Robot.frontLeftMotor.setPower(.5);
        Robot.frontRightMotor.setPower(-.5);
        Robot.backLeftMotor.setPower(.5);
        Robot.backRightMotor.setPower(-.5);

    }

    @Override
    public void init(){
        telemetry.addData("STATUS", "Beginning Initialization");
        Robot.init(hardwareMap);

        //have to change to color values for yellow mineral
        cBlueValue = 255;
        cRedValue = 205;
        cGreenValue = 53;


        telemetry.addData("STATUS", "Initialized");

    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

    }




}
