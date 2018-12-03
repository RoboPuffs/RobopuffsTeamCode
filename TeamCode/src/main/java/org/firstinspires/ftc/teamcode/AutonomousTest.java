package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.vuforia.CameraDevice;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

@Autonomous(name = "ULTIMATE MEMES", group = "Autonomous")
public class AutonomousTest extends OpMode {

    private RobotHardware hRobot = new RobotHardware();
    private RobotFunctions fRobot = new RobotFunctions();

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

class RobotFunctions extends OpMode{

    private static final float mmPerInch = 25.4f;
    private static final float mmFTCFieldWidth = (12*6) * mmPerInch;
    private static final float mmTargetHeight = 6 * mmPerInch;

    private static final String VUFORIA_KEY = "AZ+2Q0L/////AAABmWbS+aSoB0b3mZnRPyJm9UFDL8MygGiR2oXOCAZe1GSo211bmYVsiQUWMwkDfU3/EW4q9zUS0X/RQF1Iq8IDLuINzTo93+8rXZOewAYDmcbOseLgVAGCNE7HYyZjzxVQZ3/jMUB9ea+lEuF5zdUmn9i++DSOiM/BRIkJi8ur5yu9DuQ8TRLyp+WzQpNPjdZy0wmfplWKbmu1bsZ6hV4UT2wcGdryFXnkWgzbYfLemZI4rweWW+tNHb4rihgqoe3CKJ00gibqU4/C6NRzegWU7K4rtL2KLOJeRYylsidex1dkaB6KuwHc1ENKdcZkVdvnDZ33p+tszQA+dJNAs3BseD66QzmtJIZw+4zJjei+rtaz";
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
