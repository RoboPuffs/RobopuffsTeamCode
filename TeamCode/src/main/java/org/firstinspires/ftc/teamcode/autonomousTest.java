package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "ULTIMATE MEMES", group = "Autonomous")
public class autonomousTest extends OpMode {

    RobotHardware robot = new RobotHardware();

    @Override
    public void init() {
        telemetry.addData("STATUS", "Starting Initialization");
        robot.init(hardwareMap);
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

    @Override
    public void stop() {

    }
}
