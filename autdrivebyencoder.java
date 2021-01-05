package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  leftBackMotor:         "leftBackMotor"
 * Motor channel:  leftFrontMotor:        "leftFrontMotor"
 * Motor channel:  rightBackMotor:        "rightBackMotor"
 * Motor channel:  rightFrontMotor:       "rightFrontMotor"
 */
public class HardwareMechbot
{
    /* Public OpMode members. */
    public DcMotor  lbm   = null;
    public DcMotor  lfm  = null;
    public DcMotor  rbm     = null;
    public DcMotor  rfm     = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareMechbot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        lbm  = hwMap.get(DcMotor.class, "lbm");
        lfm = hwMap.get(DcMotor.class, "lfm");
        rbm    = hwMap.get(DcMotor.class, "rbm");
        rfm    = hwMap.get(DcMotor.class, "rfm");
        lbm.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        lfm.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        lbm.setPower(0);
        lfm.setPower(0);
        rbm.setPower(0);
        rfm.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        lbm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lfm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rbm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rfm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
}
