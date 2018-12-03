package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;


public class RobotHardware
{
    // instantiate motors and servos
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;
    public Servo   servoArm;
    public CRServo servoIntake;
    public DcMotor armMotor;
    public DcMotor middleArmMotor;
    public ColorSensor colorSensor;


    //temporary definitions for new arm mechanism
    public DcMotor intakeMotor;
    public DcMotor inputMotor;
    public DcMotor armMotor2;

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
        //servoArm = hardwareMap.get(Servo.class, "servo arm");
        servoIntake = hardwareMap.get(CRServo.class, "servo intake");
        armMotor = hardwareMap.get(DcMotor.class, "arm motor");
        middleArmMotor = hardwareMap.get(DcMotor.class, "middle arm motor");
        colorSensor = hardwareMap.get(ColorSensor.class, "color sensor");

        //initializing variable for potential arm mechanism
        intakeMotor = hardwareMap.get(DcMotor.class, "intake motor");
        inputMotor = hardwareMap.get(DcMotor.class, "input motor");
        armMotor2 = hardwareMap.get(DcMotor.class, "arm motor");



        // set motor power
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        middleArmMotor.setPower(0);

        intakeMotor.setPower(0);
        inputMotor.setPower(0);
        armMotor2.setPower(0);

        colorSensor.enableLed(true);


        // set motor mode
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); //...RunMode.RUN_TO_POSITION - for autonomous when you want to use encoder positions
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        middleArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        armMotor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        inputMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        //set motor zeroPowerBehavior
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); //...zeroPowerBehavior.float we want it to stop exactly when set to zero
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        middleArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        inputMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        inputMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        /* set servo position
        servoArm.setPosition(0); //have to change later when robot is running ***
        */
        servoIntake.setPower(0);

    }


 }

