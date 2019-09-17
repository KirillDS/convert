package dataTransferRate;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class DataTransferRate {
	
//By Kirill David Sorokin

	//Global variables
	private JFrame frame;
	private JTextField bitInput;
	private JTextField bitOutput;
	private JLabel equalsSymbol;
	private JLabel dataTransferRateLbl;
	
	double bitOne, bitTwo;
	String bitThree;
	private JButton updateBtn;

	//Launches the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataTransferRate window = new DataTransferRate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creates the application
	public DataTransferRate() {
		initialize();
	}

	//Contents of the Frame
	/*	IMPORTANT NOTE: Code was copied in two places;
	 *  the combo box(bitCombo) and the button(updateBtn),
	 *  the reason is that the code struggled to work
	 *  with them as global variables, hence why the code was copied.*/
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 505, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Input text box
		bitInput = new JTextField();
		bitInput.setBounds(28, 147, 189, 26);
		frame.getContentPane().add(bitInput);
		bitInput.setColumns(10);
		
		//Output text box
		bitOutput = new JTextField();
		bitOutput.setEditable(false);
		bitOutput.setColumns(10);
		bitOutput.setBounds(290, 147, 189, 26);
		frame.getContentPane().add(bitOutput);
		
		//bits/sec title
		JLabel bitLbl = new JLabel("Bit per second (bits/sec)");
		bitLbl.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		bitLbl.setBounds(33, 169, 189, 27);
		frame.getContentPane().add(bitLbl);
		
		/*	Data transfer type combo box;
		 *  if statements perform the calculation and upload
		 *  the output box upon selection.*/
		JComboBox<Object> bitCombo = new JComboBox<Object>();
		bitCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String convertBit = (String) bitCombo.getSelectedItem();
				if (convertBit == "Kilobit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / 1000;
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Kilobyte per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / 8000;
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Kibibit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / 1024;
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Megabit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1e+6);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Megabyte per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (8e+6);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Mebibit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1.049e+6);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Gigabit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1e+9);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Gigabyte per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (8e+9);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Gibibit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1.074e+9);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Terabit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1e+12);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Terabyte per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (8e+12);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Tebibit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1.1e+12);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
			}
		});
		bitCombo.setModel(new DefaultComboBoxModel<Object>(new String[] {"--", "Kilobit per second", "Kilobyte per second", "Kibibit per second", "Megabit per second", "Megabyte per second", "Mebibit per second", "Gigabit per second", "Gigabyte per second", "Gibibit per second", "Terabit per second", "Terabyte per second", "Tebibit per second"}));
		bitCombo.setBounds(290, 170, 189, 27);
		frame.getContentPane().add(bitCombo);
		
		//Equal symbol
		equalsSymbol = new JLabel("=");
		equalsSymbol.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		equalsSymbol.setHorizontalAlignment(SwingConstants.CENTER);
		equalsSymbol.setBounds(222, 157, 61, 16);
		frame.getContentPane().add(equalsSymbol);
		
		//Main title 
		dataTransferRateLbl = new JLabel("Data Transfer Rate");
		dataTransferRateLbl.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		dataTransferRateLbl.setBounds(115, 41, 273, 70);
		frame.getContentPane().add(dataTransferRateLbl);
		
		/*	Update button and functionalities - 
		 * 	if statements perform the calculation and update
		 *  the output box.*/
		updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String convertBit = (String) bitCombo.getSelectedItem();
				if (convertBit == "Kilobit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / 1000;
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Kilobyte per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / 8000;
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Kibibit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / 1024;
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Megabit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1e+6);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Megabyte per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (8e+6);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Mebibit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1.049e+6);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Gigabit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1e+9);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Gigabyte per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (8e+9);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Gibibit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1.074e+9);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Terabit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1e+12);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Terabyte per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (8e+12);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
				else if (convertBit == "Tebibit per second") {
					bitOne = (Double.parseDouble(bitInput.getText()));
					bitTwo = bitOne / (1.1e+12);
					bitThree = String.format("%.15f", bitTwo);
					bitOutput.setText(bitThree);
				}
			}
		});
		updateBtn.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		updateBtn.setBounds(24, 222, 117, 29);
		frame.getContentPane().add(updateBtn);
	}

}
