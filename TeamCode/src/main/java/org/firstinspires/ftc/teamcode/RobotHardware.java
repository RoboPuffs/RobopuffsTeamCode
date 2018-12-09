package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;
//import com.qualcomm.robotcore.hardware.ColorSensor;


public class RobotHardware
{
    //instantiating motors and servos
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;
    public Servo mineralOutputServo;
    public DcMotor mainArmJointMotor;
    public DcMotor mineralIntakeMotor;
    //public ColorSensor colorSensor;
    public Servo mineralHolderArmServo;

    //creating hardware map
    HardwareMap hardwareMap;

    //making a method to later call upon in opMode
    //use it to declare everything in our robot
    public void init(HardwareMap hardwareMap) {

        // Defining motors and servos
        frontLeftMotor = hardwareMap.get(DcMotor.class, "front left motor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "front right motor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "back left motor");
        backRightMotor = hardwareMap.get(DcMotor.class, "back right motor");
        mineralIntakeMotor = hardwareMap.get(DcMotor.class, "intake motor");
        mainArmJointMotor = hardwareMap.get(DcMotor.class, "arm motor");
        mineralOutputServo = hardwareMap.get(Servo.class, "mineral output servo");
        //colorSensor = hardwareMap.get(ColorSensor.class, "color sensor");
        mineralHolderArmServo = hardwareMap.get(Servo.class, "mineral holder servo");


        //setting motor power
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        mineralIntakeMotor.setPower(0);
        mainArmJointMotor.setPower(0);

        //enabling color sensor LED
        //colorSensor.enableLed(true);

        //setting motor mode
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //...RunMode.RUN_TO_POSITION - for autonomous when you want to use encoder positions
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mainArmJointMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mineralIntakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //setting motor zeroPowerBehavior
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); //...zeroPowerBehavior.float we want it to stop exactly when set to zero
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mainArmJointMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mineralIntakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //mineralOutputMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //initializing servo beginning position
        mineralHolderArmServo.setPosition(0.1);
        mineralOutputServo.setPosition(0.4);

    }
 }

