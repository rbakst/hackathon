
package Simulation.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RunWaitingRoom
extends JFrame {

	private JPanel contentPane;
	private JTextField pperhour;
	private JTextField fifteenTXT;
	private JTextField thirtyTXT;
	private JTextField fourtyfiveTXT;
	private JTextField sixtyTXT;
	private JTextField workdayhours;
	private JTextField numDoctors;
	private JTextField fifteentxt;
	private JTextField thirtytxt;
	private JTextField fortyfivetxt;
	private JTextField sixtytxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunWaitingRoom frame = new RunWaitingRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RunWaitingRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHowManyPatients = new JLabel("How many patients do you schedule per hour?");
		lblHowManyPatients.setFont(new Font("Garamond", Font.BOLD, 17));
		lblHowManyPatients.setBounds(53, 45, 336, 34);
		contentPane.add(lblHowManyPatients);
		
		pperhour = new JTextField();
		pperhour.setBounds(401, 51, 74, 22);
		contentPane.add(pperhour);
		pperhour.setColumns(10);
		
		JLabel lblApproximatelyWhatPercent = new JLabel("Approximately what percent of people are in and out in:");
		lblApproximatelyWhatPercent.setFont(new Font("Garamond", Font.BOLD, 17));
		lblApproximatelyWhatPercent.setBounds(98, 100, 415, 34);
		contentPane.add(lblApproximatelyWhatPercent);
		
		fifteenTXT = new JTextField();
		fifteenTXT.setBounds(313, 147, 60, 22);
		contentPane.add(fifteenTXT);
		fifteenTXT.setColumns(10);
		
		JLabel lblMinutes = new JLabel("15 minutes:");
		lblMinutes.setBounds(207, 139, 124, 39);
		contentPane.add(lblMinutes);
		
		JLabel lblMinutes_1 = new JLabel("30 Minutes:");
		lblMinutes_1.setBounds(207, 191, 84, 16);
		contentPane.add(lblMinutes_1);
		
		thirtyTXT = new JTextField();
		thirtyTXT.setBounds(313, 185, 60, 22);
		contentPane.add(thirtyTXT);
		thirtyTXT.setColumns(10);
		
		JLabel lblMinutes_2 = new JLabel("45 minutes:");
		lblMinutes_2.setBounds(207, 226, 103, 16);
		contentPane.add(lblMinutes_2);
		
		fourtyfiveTXT = new JTextField();
		fourtyfiveTXT.setBounds(313, 223, 60, 22);
		contentPane.add(fourtyfiveTXT);
		fourtyfiveTXT.setColumns(10);
		
		JLabel lblMinutes_3 = new JLabel("60 minutes:");
		lblMinutes_3.setBounds(207, 266, 74, 22);
		contentPane.add(lblMinutes_3);
		
		sixtyTXT = new JTextField();
		sixtyTXT.setBounds(313, 266, 60, 22);
		contentPane.add(sixtyTXT);
		sixtyTXT.setColumns(10);
		
		 fifteentxt = new JTextField(5);
		 thirtytxt = new JTextField(5);
		fortyfivetxt = new JTextField(5);
		sixtytxt = new JTextField(5);
		
		JLabel lblHowLongIs = new JLabel("How long is your workday?");
		lblHowLongIs.setFont(new Font("Garamond", Font.BOLD, 17));
		lblHowLongIs.setBounds(44, 311, 210, 22);
		contentPane.add(lblHowLongIs);
		
		workdayhours = new JTextField();
		workdayhours.setBounds(250, 311, 60, 22);
		contentPane.add(workdayhours);
		workdayhours.setColumns(10);
		
		JLabel lblHrs = new JLabel("hrs");
		lblHrs.setBounds(313, 314, 56, 16);
		contentPane.add(lblHrs);
		
		JButton btnCalculateEfficiency = new JButton("Calculate Efficiency");
		btnCalculateEfficiency.addActionListener(new ActionListener(){

		
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new DataFrameNew(Integer.parseInt(numDoctors.getText()), Integer.parseInt(pperhour.getText()), 
					Integer.parseInt(fifteenTXT.getText()),
					Integer.parseInt(thirtyTXT.getText()),
					Integer.parseInt(fourtyfiveTXT.getText()),
					Integer.parseInt(sixtyTXT.getText()), 
					Integer.parseInt(workdayhours.getText()));
				
			}
			
		});
		btnCalculateEfficiency.setFont(new Font("Cooper Black", Font.BOLD, 17));
		btnCalculateEfficiency.setBounds(193, 353, 282, 28);
		contentPane.add(btnCalculateEfficiency);
		
		//JPanel panel = new JPanel();
		File file = new File("C:/Users/Rachel/OneDrive/Tour/Fall 2016/Hackathon/Simulation/Simulation/gui/waiting.jpeg");
		
		JLabel lbl = new JLabel(file.getAbsolutePath());
		
		contentPane.add(lbl);
//		
//		
//		try {
//			 final Image backgroundImage = javax.imageio.ImageIO.read(new
//			 File("C:\\Users\\Rachel\\OneDrive\\Touro\\Fall 2016\\Hackathon\\Simulation\\Simulation\\waiting.jpeg"));
//			 setContentPane(new JPanel(new BorderLayout()) {
//			 @Override
//			 public void paintComponent(Graphics g) {
//			 g.drawImage(backgroundImage, 70, 0, null);
//			 System.out.println("image set");
//			 }
//			 });
//			 } catch (IOException e) {
//			 JOptionPane.showMessageDialog(null, "File was not found! ");
//			 System.exit(1);
//			 }
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("C:/Users/Rachel/OneDrive/Touro/Fall 2016/Hackathon/Simulation/Simulation/gui/waiting.jpeg"));
		lblNewLabel.setBounds(398, 147, 263, 203);
		contentPane.add(lblNewLabel);
		
		JLabel lblHowManyDoctors = new JLabel("How many doctors are there?");
		lblHowManyDoctors.setFont(new Font("Garamond", Font.BOLD, 17));
		lblHowManyDoctors.setBounds(53, 16, 336, 16);
		contentPane.add(lblHowManyDoctors);
		
		numDoctors = new JTextField();
		numDoctors.setBounds(328, 16, 65, 22);
		contentPane.add(numDoctors);
		numDoctors.setColumns(10);
	}
}
