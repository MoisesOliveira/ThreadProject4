package view;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.Lock;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import controller.CarController;

import javax.swing.JPanel;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class Race {

	
	 CarController carController1;
	 CarController carController2;
	static JLabel car1 = new JLabel("Carro 1");
	static JLabel car2 = new JLabel("Carro 2");
	static JTextField ultimoText = new JTextField();
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Race window = new Race();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Race() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JLabel vencedor = new JLabel("Vencedor");
		JLabel perdedor = new JLabel("Perdedor");
		
		
		JTextField vencedorText = new JTextField();
		JTextField perdedorText = new JTextField();
		vencedorText.setBounds(177, 181, 86, 20);
		perdedorText.setBounds(177, 227, 86, 20);
		frame.getContentPane().add(vencedorText);
		frame.getContentPane().add(perdedorText);
		perdedorText.setColumns(10);
		vencedorText.setColumns(10);
		car1.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		car1.setForeground(new Color(255, 83, 83));
		
		car1.setBounds(20, 50, 105, 50);
		car2.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		car2.setForeground(new Color(0, 225, 0));
		car2.setBounds(20, 70, 105, 50);
	
		frame.setBounds(200, 200, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		vencedor.setBounds(114,166, 100, 50);
		perdedor.setBounds(114,212, 100, 50);
		frame.getContentPane().add(vencedor);
		frame.getContentPane().add(perdedor);
		frame.getContentPane().add(car1);
		frame.getContentPane().add(car2);
		frame.getContentPane().setLayout(null);
		
		
		 carController1 = new CarController(200, car1, vencedorText, perdedorText);
		 carController2 = new CarController(200, car2, vencedorText, perdedorText);
		 
		 Button button = new Button("Start");
		 button.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		try {
					startRace();
					button.setVisible(false);
				} 
		 		
		 		catch (Exception e2) {
					System.err.println("Don't try again");
				}
		 	}
		 });
		 
		 
		 button.setBounds(40, 294, 70, 22);
		 frame.getContentPane().add(button);
		 
}
	private void startRace(){	
		carController1.start();
		carController2.start();
		
	}
}
