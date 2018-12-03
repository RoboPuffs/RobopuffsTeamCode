package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "ULTIMATE MEMES", group = "Autonomous")
public class AutonomousTest extends OpMode {

    RobotHardware hRobot = new RobotHardware();

    @Override
    public void init() {
        telemetry.addData("STATUS", "Starting Initialization");
        hRobot.init(hardwareMap);
        telemetry.addData("STATUS", "Initialized");

        double x, y, r;
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

class RobotFunctions {

}
