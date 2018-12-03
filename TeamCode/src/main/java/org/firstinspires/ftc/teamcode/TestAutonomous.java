package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.vuforia.CameraDevice;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

@Autonomous(name="extreme meme", group="Autonomous")
public class TestAutonomous extends OpMode {

    RobotHardware robot = new RobotHardware();
    private RobotFunctions fRobot = new RobotFunctions();

    ColorSensor color_sensor;


    @Override
    public void init() {
        telemetry.addData("STATUS", "Beginning Initialization");
        robot.init(hardwareMap);
        color_sensor = hardwareMap.colorSensor.get("color sensor");
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

class RobotFunctions extends OpMode{

    private static final float mmPerInch = 25.4f;
    private static final float mmFTCFieldWidth = (12*6) * mmPerInch;
    private static final float mmTargetHeight = 6 * mmPerInch;

    private static final String VUFORIA_KEY = "AU0E6zH/////AAABmeyLALbsKEFIpMUkLULjns+JunlFl6EODfdmmbA3EL2YiQR78UqUSsa5NYvEWSFznLsxHlBHUdEuvtIYZL4wrdU1VcZoozWgmyAVTQdlGh60nB8nPR4Bz5aHq5N6bnEjpv9eNa96BLWzOjqGJPutC39mos2wQUfZAohsDF978mPlguiRuzW8RM0e88TSjjzlsYfzvioajei3MRbau9oBDzBArzdIr9j+eQqsQ1shrjcFf2KtE1I81yG2cUDNkxmxfXERoco2VrjE4EuhN1mYFQtrggjXd6V/AMs6oyiTAIdJF0AtHOPJX08aOraqyNR7hrqaX0hlgwjnHtGF7jEQOZBmOdfDIZtTyFyz9nScEcVN";
    private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;

    private OpenGLMatrix lastLocation = null;
    private boolean targetVisible = false;
    VuforiaLocalizer vuforia;

    void vuforiaSetup() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CAMERA_CHOICE;
    }

    public void init() {

    }

    public void loop() {

    }
}


