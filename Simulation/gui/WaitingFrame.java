package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WaitingFrame extends JFrame {

	private Integer numPlayers;
	private boolean is3Checked;
	private ImageIcon icon;
	private JCheckBox chckbxAllowLetter;
	private JTextField patientsPerHourtxt; 
	JTextField fifteentxt;
	JTextField thirtytxt;
	JTextField fortyfivetxt;
	JTextField sixtytxt;
	JTextField workdaytxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaitingFrame frame = new WaitingFrame();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WaitingFrame() {
		// try {
		// final Image backgroundImage = javax.imageio.ImageIO.read(new
		// File("src/boggleGameResources/logo.png"));
		// setContentPane(new JPanel(new BorderLayout()) {
		// @Override
		// public void paintComponent(Graphics g) {
		// g.drawImage(backgroundImage, 70, 0, null);
		// System.out.println("image set");
		// }
		// });
		// } catch (IOException e) {
		// JOptionPane.showMessageDialog(null, "File was not found! fix line 50
		// and 69 in winnerFrame, startBoggle lines 54,65,73, boggleGUI lines
		// 62, 255! REMEMBER this is an approx!!!");
		// System.exit(1);
		// }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		this.setLayout(new FlowLayout());
		
		JLabel perHourlbl = new JLabel("How many patients do you schedule per hour?");
		patientsPerHourtxt = new JTextField(10);
		this.add(perHourlbl);
		this.add(patientsPerHourtxt);

		JLabel approx = new JLabel("Approximately what percent of patients are serviced in: ");
		approx.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
		approx.setBounds(60, 120, 147, 14);
		this.add(approx);
		
		JLabel fifteen = new JLabel("15 minutes");
		JLabel thirty = new JLabel("30 minutes");
		JLabel fourtyFive = new JLabel("45 minutes");
		JLabel sixty = new JLabel("1 hour (or more)");
		
		 fifteentxt = new JTextField(5);
		 thirtytxt = new JTextField(5);
		fortyfivetxt = new JTextField(5);
		sixtytxt = new JTextField(5);

		this.add(fifteen);
		this.add(fifteentxt);
		this.add(thirty);
		this.add(thirtytxt);
		this.add(fourtyFive);
		this.add(fortyfivetxt);
		this.add(sixty);
		this.add(sixtytxt);
		
		JLabel workday = new JLabel("How long is your workday? (in hours)");
		workdaytxt = new JTextField(5);
		this.add(workday);
		this.add(workdaytxt);
		
		JButton btnDone = new JButton("Calculate Efficiency");
		btnDone.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		btnDone.addActionListener(new OKActionListener(this));

		btnDone.setBounds(144, 180, 147, 55);
		this.add(btnDone);

		setVisible(true);

	
		
	}

	private class OKActionListener implements ActionListener {
		private JFrame window;

		public OKActionListener(JFrame w) {
			this.window = w;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new DataFrame(Integer.parseInt(patientsPerHourtxt.getText()), 
					Integer.parseInt(fifteentxt.getText()),
					Integer.parseInt(thirtytxt.getText()),
					Integer.parseInt(fortyfivetxt.getText()),
					Integer.parseInt(sixtytxt.getText()), 
					Integer.parseInt(workdaytxt.getText()));
		}

	}

}
