package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.FRONT;

@Autonomous(name = "extreme memes", group = "Autonomous")
public class TestAutonomous extends OpMode {

    private RobotHardware Robot = new RobotHardware();
    private RobotFunctions fRobot = new RobotFunctions();

    //vuforia
    private boolean targetVisible = false;
    private List<VuforiaTrackable> allTrackables;
    private OpenGLMatrix lastLocation = null;

    //color sensor
    private int cBlueValue, cRedValue, cGreenValue;



    @Override
    public void init() {
        telemetry.addData("STATUS", "Beginning Initialization");
        Robot.init(hardwareMap);
        fRobot.vuforiaSetup();
        allTrackables = fRobot.trackables();

        //have to change to color values for yellow mineral
        cRedValue = 255;
        cGreenValue = 205;
        cBlueValue = 53;

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

        //FOR VUFORIA
        targetVisible = false;
        for (VuforiaTrackable trackable : allTrackables) {
            if (((VuforiaTrackableDefaultListener)trackable.getListener()).isVisible()) {
                telemetry.addData("Visible Target", trackable.getName());
                targetVisible = true;

                // getUpdatedRobotLocation() will return null if no new information is available since
                // the last time that call was made, or if the trackable is not currently visible.
                OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener)trackable.getListener()).getUpdatedRobotLocation();
                if (robotLocationTransform != null) {
                    lastLocation = robotLocationTransform;
                }
                break;
            }
        }

        if (targetVisible) {
            // express position (translation) of robot in inches.
            VectorF translation = lastLocation.getTranslation();
            telemetry.addData("Pos (in)", "{X, Y, Z} = %.1f, %.1f, %.1f",
                    translation.get(0) / RobotFunctions.mmPerInch, translation.get(2) / RobotFunctions.mmPerInch);

            // express the rotation of the robot in degrees.
            Orientation rotation = Orientation.getOrientation(lastLocation, EXTRINSIC, XYZ, DEGREES);
            telemetry.addData("Rot (deg)", "{Roll, Pitch, Heading} = %.0f, %.0f, %.0f", rotation.firstAngle, rotation.secondAngle, rotation.thirdAngle);
        }
        else {
            telemetry.addData("Visible Target", "none");
        }


        /*detecting minerals with color sensor
        if(Robot.colorSensor.blue() <= cBlueValue && Robot.colorSensor.red() >= cRedValue && Robot.colorSensor.green() >= cGreenValue) {

            //Robot.mineralServo.setPosition(1.0); //change to a correct value with testing
        }
        else {
            //action to test each mineral
        }
        */



        telemetry.update();
    }

    @Override
    public void stop() {

    }
}

class RobotFunctions extends OpMode{

    static final float mmPerInch = 25.4f;
    private static final float mmFTCFieldWidth = (12*6) * mmPerInch;
    private static final float mmTargetHeight = 6 * mmPerInch;

    private static final String VUFORIA_KEY = "AU0E6zH/////AAABmeyLALbsKEFIpMUkLULjns+JunlFl6EODfdmmbA3EL2YiQR78UqUSsa5NYvEWSFznLsxHlBHUdEuvtIYZL4wrdU1VcZoozWgmyAVTQdlGh60nB8nPR4Bz5aHq5N6bnEjpv9eNa96BLWzOjqGJPutC39mos2wQUfZAohsDF978mPlguiRuzW8RM0e88TSjjzlsYfzvioajei3MRbau9oBDzBArzdIr9j+eQqsQ1shrjcFf2KtE1I81yG2cUDNkxmxfXERoco2VrjE4EuhN1mYFQtrggjXd6V/AMs6oyiTAIdJF0AtHOPJX08aOraqyNR7hrqaX0hlgwjnHtGF7jEQOZBmOdfDIZtTyFyz9nScEcVN";
    private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;

    private VuforiaLocalizer vuforia;


    void vuforiaSetup() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CAMERA_CHOICE;

        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }

    List<VuforiaTrackable> trackables() {
        vuforiaSetup();

        VuforiaTrackables targetsRoverRuckus = this.vuforia.loadTrackablesFromAsset("RoverRuckus");
        VuforiaTrackable blueRover = targetsRoverRuckus.get(0);
        blueRover.setName("Blue-Rover");
        VuforiaTrackable redFootprint = targetsRoverRuckus.get(1);
        redFootprint.setName("Red-Footprint");
        VuforiaTrackable frontCraters = targetsRoverRuckus.get(2);
        frontCraters.setName("Front-Craters");
        VuforiaTrackable backSpace = targetsRoverRuckus.get(3);
        backSpace.setName("Back-Space");

        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>(targetsRoverRuckus);

        OpenGLMatrix blueRoverLocationOnField = OpenGLMatrix
                .translation(0, mmFTCFieldWidth, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0));
        blueRover.setLocation(blueRoverLocationOnField);

        OpenGLMatrix redFootprintLocationOnField = OpenGLMatrix
                .translation(0, -mmFTCFieldWidth, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180));
        redFootprint.setLocation(redFootprintLocationOnField);

        OpenGLMatrix frontCratersLocationOnField = OpenGLMatrix
                .translation(-mmFTCFieldWidth, 0, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90));
        frontCraters.setLocation(frontCratersLocationOnField);

        OpenGLMatrix backSpaceLocationOnField = OpenGLMatrix
                .translation(mmFTCFieldWidth, 0, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90));
        backSpace.setLocation(backSpaceLocationOnField);

        //Displacement from the center of the robot and the floor.
        final int CAMERA_FORWARD_DISPLACEMENT = 110;
        final int CAMERA_VERTICAL_DISPLACEMENT = 200;
        final int CAMERA_LEFT_DISPLACEMENT = 0;

        OpenGLMatrix phoneLocationOnRobot = OpenGLMatrix
                .translation(CAMERA_FORWARD_DISPLACEMENT, CAMERA_LEFT_DISPLACEMENT, CAMERA_VERTICAL_DISPLACEMENT)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, YZX, DEGREES,
                        CAMERA_CHOICE == FRONT ? 90 : -90, 0, 0));

        for (VuforiaTrackable trackable : allTrackables) {
            ((VuforiaTrackableDefaultListener) trackable.getListener()).setPhoneInformation(phoneLocationOnRobot, CAMERA_CHOICE);
        }

        return allTrackables;
    }

    public void init() {

    }

    public void loop() {

    }
}


