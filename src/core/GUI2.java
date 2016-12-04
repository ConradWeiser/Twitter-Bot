package core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Canvas;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.SystemColor;

public class GUI2 {

	private JFrame frmVvf;
	private JTextField txtTypeInA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 window = new GUI2();
					window.frmVvf.setVisible(true);
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
	Color twitterBlue = new Color (0, 172, 237);
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVvf = new JFrame();
		frmVvf.getContentPane().setBackground(UIManager.getColor(twitterBlue));
		frmVvf.setOpacity(100.0f);
		frmVvf.setBackground(UIManager.getColor("Table.selectionBackground"));
		frmVvf.setTitle("Twitter Bot");
		frmVvf.setForeground(Color.ORANGE);
		frmVvf.setBounds(100, 100, 801, 518);
		frmVvf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVvf.getContentPane().setLayout(null);
		
		JTextPane txtpnToCheckWeather = new JTextPane();
		txtpnToCheckWeather.setForeground(SystemColor.info);
		txtpnToCheckWeather.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnToCheckWeather.setBackground(UIManager.getColor(twitterBlue));
		txtpnToCheckWeather.setText("To check weather conditions within a region, type in a state.");
		txtpnToCheckWeather.setBounds(10, 11, 685, 70);
		frmVvf.getContentPane().add(txtpnToCheckWeather);
		
		txtTypeInA = new JTextField();
		txtTypeInA.setForeground(UIManager.getColor("Button.shadow"));
		txtTypeInA.setFont(new Font("Tahoma", Font.ITALIC, 23));
		txtTypeInA.setText("Type in a State");
		txtTypeInA.setBounds(10, 91, 315, 43);
		frmVvf.getContentPane().add(txtTypeInA);
		txtTypeInA.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnSearch.setBounds(401, 91, 206, 43);
		frmVvf.getContentPane().add(btnSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 145, 765, 2);
		frmVvf.getContentPane().add(separator);
		
		JTextPane txtpnRegionsAndConditions = new JTextPane();
		txtpnRegionsAndConditions.setForeground(SystemColor.info);
		txtpnRegionsAndConditions.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtpnRegionsAndConditions.setBackground(UIManager.getColor(twitterBlue));
		txtpnRegionsAndConditions.setText("Regions and Conditions");
		txtpnRegionsAndConditions.setBounds(10, 156, 414, 43);
		frmVvf.getContentPane().add(txtpnRegionsAndConditions);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(10, 219, 765, 250);
		frmVvf.getContentPane().add(canvas);
		frmVvf.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmVvf.getContentPane(), txtpnToCheckWeather, txtTypeInA, btnSearch, separator, txtpnRegionsAndConditions, canvas}));
	}

}
