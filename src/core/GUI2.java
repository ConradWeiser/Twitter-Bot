import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Canvas;

public class GUI2 {

	private JFrame frame;
	private JTextField txtTypeInA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
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
	public GUI2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnToCheckWeather = new JTextPane();
		txtpnToCheckWeather.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnToCheckWeather.setBackground(UIManager.getColor(0, 172, 237));
		txtpnToCheckWeather.setText("To check weather conditions within a region, type in a state.");
		txtpnToCheckWeather.setBounds(10, 11, 349, 34);
		frame.getContentPane().add(txtpnToCheckWeather);
		
		txtTypeInA = new JTextField();
		txtTypeInA.setForeground(UIManager.getColor("Button.shadow"));
		txtTypeInA.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtTypeInA.setText("Type in a State");
		txtTypeInA.setBounds(10, 56, 86, 20);
		frame.getContentPane().add(txtTypeInA);
		txtTypeInA.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(121, 54, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 87, 414, 2);
		frame.getContentPane().add(separator);
		
		JTextPane txtpnRegionsAndConditions = new JTextPane();
		txtpnRegionsAndConditions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnRegionsAndConditions.setBackground(UIManager.getColor(0));
		txtpnRegionsAndConditions.setText("Regions and Conditions");
		txtpnRegionsAndConditions.setBounds(10, 100, 215, 20);
		frame.getContentPane().add(txtpnRegionsAndConditions);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(UIManager.getColor("controlHighlight"));
		canvas.setBounds(10, 126, 414, 125);
		frame.getContentPane().add(canvas);
	}

}
