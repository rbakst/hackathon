package Simulation.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Simulation.wr.*;
import Simulation.wr.WaitingRoom;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class DataFrameNew extends JFrame {

	private JPanel contentPane;
	private WaitingRoom clinic;
	private JTextField newNumDrs;
	private JTextField newNumPatients;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public DataFrameNew(int numDoctors, int patientsPerHour, int fifteen, int thirty, int fortyfive, int sixty,
			int simulationRuntime) {
		clinic = new WaitingRoom();
		clinic.setValues(numDoctors, patientsPerHour, fifteen, thirty, fortyfive, sixty, simulationRuntime);
		

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JLabel lblNumberOfPeople = new JLabel("Number of Patients Processed: ");
		lblNumberOfPeople.setFont(new Font("Garamond", Font.BOLD, 17));
		lblNumberOfPeople.setBounds(80, 24, 234, 16);
		contentPane.add(lblNumberOfPeople);
		
		
		
		
		
		
		
		int sumPatients = 0;
		double sumWaitTime = 0;
		for (int i = 0; i < 100; i++)
		{
			clinic.run();
			sumPatients += clinic.getPeopleSeen();
			sumWaitTime += clinic.getAverageWaitTime();
		}
		//calculate averages
		double avgPatients = sumPatients / 100;
		double avgWaitTime = sumWaitTime / 100;
		
		avgPatients = avgPatients/2;
		avgWaitTime = avgWaitTime/2;
		
		//JLabel label = new JLabel(String.valueOf(avgPatients));
		
		
		JLabel numPatients = new JLabel(String.valueOf(avgPatients));
		numPatients.setBounds(326, 53, 56, 16);
		contentPane.add(numPatients);
		
		numPatients.setBounds(5, 375, 638, 0);
		contentPane.add(numPatients);
		
		
		
		JLabel lblAverageWaitTime = new JLabel("Average Wait time per patient:");
		lblAverageWaitTime.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAverageWaitTime.setBackground(Color.ORANGE);
		lblAverageWaitTime.setBounds(32, 53, 282, 16);
		contentPane.add(lblAverageWaitTime);
		
		JLabel waitTimeLabel = new JLabel(String.valueOf(avgWaitTime));
		waitTimeLabel.setBounds(350, 55, 56, 16);
		contentPane.add(waitTimeLabel);
		
		
		JTextArea text = new JTextArea();
		text.setText(clinic.toString());
		text.setEditable(false);
		
		getContentPane().add(text);
		
		JLabel numPatientLabel = new JLabel(String.valueOf(avgPatients));
		numPatientLabel.setBounds(340, 24, 56, 16);
		contentPane.add(numPatientLabel);
		
		JLabel lblAdjustNumberDoctors = new JLabel("Adjust number Doctors");
		lblAdjustNumberDoctors.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAdjustNumberDoctors.setBounds(97, 336, 231, 26);
		contentPane.add(lblAdjustNumberDoctors);
		
		newNumDrs = new JTextField();
		newNumDrs.setBounds(340, 340, 116, 22);
		contentPane.add(newNumDrs);
		newNumDrs.setColumns(10);
		
		JLabel lblAdjustNumberPatients = new JLabel("Adjust number patients per hour");
		lblAdjustNumberPatients.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAdjustNumberPatients.setBounds(32, 372, 282, 26);
		contentPane.add(lblAdjustNumberPatients);
		
		newNumPatients = new JTextField();
		newNumPatients.setBounds(339, 376, 116, 22);
		contentPane.add(newNumPatients);
		newNumPatients.setColumns(10);
		
		JButton btnRecalculateDrs = new JButton("Recalculate");
		btnRecalculateDrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runWithNumDoctorProjections(clinic, Integer.parseInt(newNumDrs.getText()));
			}
		});
		btnRecalculateDrs.setBounds(481, 337, 97, 25);
		contentPane.add(btnRecalculateDrs);
		
		JButton btnRecalculatePatients = new JButton("Recalculate");
		btnRecalculatePatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				runWithNumPatientProjections(clinic, Integer.parseInt(newNumPatients.getText()));
			}
		});
		btnRecalculatePatients.setBounds(481, 375, 97, 25);
		contentPane.add(btnRecalculatePatients);
//		
//		JLabel lblNewLabel = new JLabel(new ImageIcon("C:/Users/Rachel/OneDrive/Touro/Fall 2016/Hackathon/Simulation/Simulation/gui/waiting.jpeg"));
//		lblNewLabel.setBounds(398, 147, 263, 203);
//		contentPane.add(lblNewLabel);
//		
		JLabel picture = new JLabel(new ImageIcon("C:\\Users\\Rachel\\OneDrive\\Touro\\Fall 2016\\Hackathon\\Simulation\\Simulation\\gui\\e.jpg"));
		picture.setFont(new Font("Tahoma", Font.BOLD, 17));
		picture.setBackground(Color.ORANGE);
		picture.setBounds(73, 82, 476, 241);
		contentPane.add(picture);
		this.setVisible(true);
		
	//	runWithNumDoctorProjections(clinic);
		
	}
	
	public static void runWithNumDoctorProjections(WaitingRoom theClinic, int numDocs)
	{
		System.out.println("Adding " + numDocs + " doctor(s):");
		theClinic.setNumDoctors(theClinic.getNumDoctors() + numDocs);
		
		int sumPatients = 0;
		double sumWaitTime = 0;
		for (int i = 0; i < 100; i++)
		{
			theClinic.run();
			sumPatients += theClinic.getPeopleSeen();
			sumWaitTime += theClinic.getAverageWaitTime();
		}
		//calculate averages
		double avgPatients = sumPatients / 100;
		double avgWaitTime = sumWaitTime / 100;
				
		System.out.println("Average patients serviced: " + avgPatients);
		System.out.println("Average wait time patients waited: " + avgWaitTime);
	}
	private static void runWithNumPatientProjections(WaitingRoom theClinic, int numPatients) {
		
		System.out.println("Changed number of patients per hour to " + numPatients + " :");
		theClinic.setNumDoctors(numPatients);
		
		int sumPatients = 0;
		double sumWaitTime = 0;
		for (int i = 0; i < 100; i++)
		{
			theClinic.run();
			sumPatients += theClinic.getPeopleSeen();
			sumWaitTime += theClinic.getAverageWaitTime();
		}
		//calculate averages
		double avgPatients = sumPatients / 100;
		double avgWaitTime = sumWaitTime / 100;
				
		System.out.println("Average patients serviced: " + avgPatients);
		System.out.println("Average wait time patients waited: " + avgWaitTime);
	}


}
