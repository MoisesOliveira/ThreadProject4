package controller;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarController extends Thread {

	public float distance;
	private int maxVelocity;
	private float velocity;
	public int distanceElapsed ;
	private JLabel car;
	public static int crossed;
	JTextField vencedor;
	JTextField perdedor;
	
	public CarController(int distance, JLabel car, JTextField vencedor, JTextField perdedor) {
		this.distance = distance;
		this.car = car;
		Random random = new Random();
		maxVelocity = random.nextInt(distance - 100);
		this.vencedor = vencedor;
		this.perdedor = perdedor;
	}

	@Override
	public void run() {
		
		Random random = new Random();
		int next = random.nextInt((maxVelocity - 1) + 1) + 5;
		distance = distance - car.getX();
		
		System.out.println(distance);
		while(distanceElapsed < distance) {
			moveCar(car, distanceElapsed);
			distanceElapsed += next;
		}
		
		crossed += 1;
		
		if(crossed == 1) {
			Result(vencedor, car.getText());
		}
		if(crossed == 2) {
			Result(perdedor, car.getText());
		}
	}
	
	private void moveCar(JLabel car, int position) {
		try {
			car.setLocation(position, car.getY());
			sleep(100);
		} 
		catch (Exception e) {
			
		}
	}
	
	public void Result(JTextField result, String msg) {
		result.setText(msg);
	}
		
}
