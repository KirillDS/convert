package kelvin;

//Necessary imports - Creating the frame and implementing the actions
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Kelvin {

//By Kirill David Sorokin
	
	private JFrame frame;
	private JTextField leftField;
	private JTextField rightField;
	
	//Global variables
	double calculationOne, calculationTwo;
	String calculationThree;
	JComboBox<Object> leftComboBox = new JComboBox<Object>();
	
	// Try and Catch
	/*'try' and 'catch' functions are implemented 
	 * to prevent the program from crashing 
	 * - or mainly to indicate if there has been an Error detected.*/
	
	//Launches the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kelvin window = new Kelvin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creates the application
	public Kelvin() {
		initialize();
	}

	//Contents of the Frame
	/*  IMPORTANT NOTE: The reason as to why the 'ActionEvent' within
	 * 'leftComboBox' and 'convertBtn' are identical is because of I intended on the user
	 *  being able to convert the amount at the beginning with the button, 
	 *  however if they wish to view the amount in a different format, 
	 *  then they can easily do so just by selecting the different format. */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 381, 277);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Combo Box functionalities
		leftComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String convertString = (String) leftComboBox.getSelectedItem();
					if (convertString == "Celsius") {
						calculationOne = (Double.parseDouble(leftField.getText()));
						calculationTwo = calculationOne + 273.15;
						calculationThree = String.format("%.3f", calculationTwo);
						rightField.setText(null);
						rightField.setText(calculationThree);
					}
					else if (convertString == "Fahrenheit") {
						calculationOne = (Double.parseDouble(leftField.getText()));
						calculationTwo = (calculationOne - 32) * 5/9 + 273.15;
						calculationThree = String.format("%.3f", calculationTwo);
						rightField.setText(null);
						rightField.setText(calculationThree);
					}	
					}catch(Exception h) {JOptionPane.showMessageDialog(null, "There has been an Error!");}
			}
		});
		leftComboBox.setBounds(23, 94, 123, 27);
		leftComboBox.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		leftComboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Celsius", "Fahrenheit"}));
		frame.getContentPane().add(leftComboBox);
		
		//Left text field's functionalities
		leftField = new JTextField();
		leftField.setHorizontalAlignment(SwingConstants.RIGHT);
		leftField.setBounds(23, 69, 123, 26);
		frame.getContentPane().add(leftField);
		leftField.setColumns(10);
		
		//Right text field's functionalities
		rightField = new JTextField();
		rightField.setEditable(false);
		rightField.setHorizontalAlignment(SwingConstants.RIGHT);
		rightField.setBounds(231, 69, 123, 26);
		rightField.setColumns(10);
		frame.getContentPane().add(rightField);
		
		//Equals' symbol
		JLabel equalsLabel = new JLabel("=");
		equalsLabel.setBounds(158, 74, 61, 16);
		equalsLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		equalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(equalsLabel);
		
		//Convert button functionalities
		JButton convertBtn = new JButton("Convert ->");
		convertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String convertString = (String) leftComboBox.getSelectedItem();
				if (convertString == "Celsius") {
					calculationOne = (Double.parseDouble(leftField.getText()));
					calculationTwo = calculationOne + 273.15;
					calculationThree = String.format("%.3f", calculationTwo);
					rightField.setText(calculationThree+" K");
				}
				else if (convertString == "Fahrenheit") {
					calculationOne = (Double.parseDouble(leftField.getText()));
					calculationTwo = (calculationOne - 32) * 5/9 + 273.15;
					calculationThree = String.format("%.3f", calculationTwo);
					rightField.setText(calculationThree);
				}
			}catch(Exception h) {JOptionPane.showMessageDialog(null, "There has been an Error!");}
			}
		});
		convertBtn.setBounds(137, 129, 117, 29);
		frame.getContentPane().add(convertBtn);
		
		//Kelvin label
		JLabel lblKelvin = new JLabel("Kelvin");
		lblKelvin.setHorizontalAlignment(SwingConstants.CENTER);
		lblKelvin.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblKelvin.setBounds(231, 92, 123, 25);
		frame.getContentPane().add(lblKelvin);
		
		//Convert button from Kelvin to Celsius and Fahrenheit
		/*!!!!!!!CURRENTLY TURNED OFF/DISABLED!!!!!!!!!*/
		JButton convertTwoBtn = new JButton("<- Convert");
		convertTwoBtn.setEnabled(false);
		convertTwoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String convertString = (String) leftComboBox.getSelectedItem();
					if (convertString == "Celsius") {
						calculationOne = (Double.parseDouble(rightField.getText()));
						calculationTwo = (calculationOne - 273.15);
						calculationThree = String.format("%.2f", calculationTwo);
						leftField.setText(calculationThree);
					}
					else if (convertString == "Fahrenheit") {
						calculationOne = (Double.parseDouble(rightField.getText()));
						calculationTwo = (((calculationOne - 273.15)*9/5)+32);
						calculationThree = String.format("%.2f", calculationTwo);
						leftField.setText(calculationThree);
					}
				} catch(Exception h) {JOptionPane.showMessageDialog(null, "There has been an Error!");}
			}
		});
		convertTwoBtn.setBounds(137, 182, 117, 29);
		frame.getContentPane().add(convertTwoBtn);
		
		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					leftField.setText(null);
					rightField.setText(null);
				}catch(Exception h) {JOptionPane.showMessageDialog(null, "There has been an Error!");}
			}
		});
		clearBtn.setBounds(137, 155, 117, 29);
		frame.getContentPane().add(clearBtn);
		
		/* This check box will monitor if the box is selected or not;
		 * false = disables the right text field and second 'convert' button,
		 * true = enables the right text field and second 'convert' button.*/ 
		JCheckBox twoWayChckBx = new JCheckBox("2-Way Convert");
		twoWayChckBx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(twoWayChckBx.isSelected()==false) {
						rightField.setEditable(false);
						convertTwoBtn.setEnabled(false);
					}
					else if (twoWayChckBx.isSelected()==true) {
						rightField.setEditable(true);
						convertTwoBtn.setEnabled(true);
					}
				}catch(Exception h) {JOptionPane.showMessageDialog(null, "There has been an Error!");}
		}
		});
		twoWayChckBx.setBounds(132, 213, 128, 23);
		frame.getContentPane().add(twoWayChckBx);
	}
}
