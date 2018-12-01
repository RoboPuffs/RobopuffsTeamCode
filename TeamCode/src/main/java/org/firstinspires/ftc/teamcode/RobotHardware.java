package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;


public class RobotHardware
{
    // instantiate motors and servos
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;
    //public DcMotor verticalArmMovement;
    //public DcMotor horizontalArmMovement;
    public Servo   servoArm;
    public CRServo servoIntake;
    public DcMotor armMotor;

    // creating the hardware map
    HardwareMap hardwareMap;


    // making a method to later call upon in opMode
    // use it to declare everything in our robot
    public void init(HardwareMap hardwareMap) {


        // Defining motors and servos
        frontLeftMotor = hardwareMap.get(DcMotor.class, "front left motor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "front right motor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "back left motor");
        backRightMotor = hardwareMap.get(DcMotor.class, "back right motor");
        //verticalArmMovement = hardwareMap.get(DcMotor.class, "vertical movement");
        //horizontalArmMovement = hardwareMap.get(DcMotor.class, "horizontal movement");
        //servoArm = hardwareMap.get(Servo.class, "servo arm");
        servoIntake = hardwareMap.get(CRServo.class, "servo intake");
        armMotor = hardwareMap.get(DcMotor.class, "arm motor");

        // set motor power
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        //verticalArmMovement.setPower(0);
        //horizontalArmMovement.setPower(0);

        // set motor mode
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //...RunMode.RUN_TO_POSITION - for autonomous when you want to use encoder positions
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //verticalArmMovement.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //horizontalArmMovement.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // set motor zeroPowerBehavior
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); //...zeroPowerBehavior.float we want it to stop exactly when set to zero
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //verticalArmMovement.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //horizontalArmMovement.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /* set servo position
        servoArm.setPosition(0); //have to change later when robot is running ***
        */
        servoIntake.setPower(0);

    }

    /*public void forwardPositions(){
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

    }
    */
 }

