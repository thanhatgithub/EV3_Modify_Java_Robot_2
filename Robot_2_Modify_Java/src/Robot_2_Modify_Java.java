import lejos.hardware.Button;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

public class Robot_2_Modify_Java {

	//Colorsensor wird initialisiert mit entsprechendem Eingangsport S
	public static EV3ColorSensor ev3CS = new EV3ColorSensor(SensorPort.S1);
	//Motoren werden initialisiert mit entsprechendem Eingangsports
	public static EV3MediumRegulatedMotor motorA = new EV3MediumRegulatedMotor(MotorPort.A);
	public static UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
	public static UnregulatedMotor motorC = new UnregulatedMotor(MotorPort.C);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		
		
		
		//Füge deinen Code an dieser Stelle ein!
		
		
		
		
		
		
	}

	static void turnRight() {
		motorB.setPower(100);
		motorC.setPower(0);
		// wartet 1,8 sek d.h. setzt den einen Motor für 1,8 sek auf 100 anschließend auf 0
		//im weiteren Verlauf des Programms gleich
		Delay.msDelay(1800);
		motorB.setPower(0);
		motorC.setPower(0);
	}
	
	static void turnLeft() {
		motorB.setPower(0);
		motorC.setPower(100);
		Delay.msDelay(1800);
		motorB.setPower(0);
		motorC.setPower(0);
	}
	
	static void moveForward() {
		motorB.setPower(100);
		motorC.setPower(100);
		Delay.msDelay(700);
		motorB.setPower(0);
		motorC.setPower(0);
	}
	
	static void moveBackward() {
		motorB.setPower(-100);
		motorC.setPower(-100);
		Delay.msDelay(700);
		motorB.setPower(0);
		motorC.setPower(0);
	}
	
	static void moveCircleLeft() {
		motorB.setPower(-100);
		motorC.setPower(100);
		Delay.msDelay(3500);
		motorB.setPower(0);
		motorC.setPower(0);
	}
	
	static void moveCircleRight() {
		motorB.setPower(100);
		motorC.setPower(-100);
		Delay.msDelay(3500);
		motorB.setPower(0);
		motorC.setPower(0);
	}
	
	static void moveHalfCircleLeft() {
		motorB.setPower(-100);
		motorC.setPower(100);
		Delay.msDelay(1180);
		motorB.setPower(0);
		motorC.setPower(0);
	}
	
	static void moveHalfCircleRight() {
		motorB.setPower(100);
		motorC.setPower(-100);
		Delay.msDelay(1180);
		motorB.setPower(0);
		motorC.setPower(0);
	}
	
	static void moveToBlackLine() {
		boolean btnOn = true;
		while(btnOn) {
			//Colorsensor bekommt den Code als Zahl und wandelt sie um in ein Integer als Variable
			Integer color = ev3CS.getColorID();
			//sobald Enter Button getätigt wird, halten die Motoren an. Ende der While Schleife
			//while Schleife muss irgendwann einmal beendet weren
			if(Button.ENTER.isDown()) {
				motorB.stop();
				motorC.stop();
				btnOn = false;
			}
			else{
				if (color == 7) {
					motorC.setPower(0);
					motorB.setPower(0);
					btnOn = false;
				};
				if (color != 7) {
					motorB.setPower(70);
					motorC.setPower(70);
				};
			};
		};
	}
	
	static void forkUp() {
		motorA.rotate(360*11*1);
		motorA.stop();
	}
	
	static void forkDown() {
		motorA.rotate(360*11*-1);
		motorA.stop();
	}
	
}
