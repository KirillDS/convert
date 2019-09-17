package temperatureConverter;

//All necessary imports - building and editing the Frame
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;

public class temperatureConverter {
	
//By Kirill David Sorokin

	//Global variables
	private JFrame frame;
	private JTextField answerInFahrenheitTitle;
	private JTextField celsiusValue;
	private JTextField fahrenheitValue;
	private JTextField answerInFahrenheit;
	private JTextField answerInCelsius;
	private JTextField answerInCelsiusTitle;
	private JButton clearBtn;
	
	String cfResult, fcResult;
	double result, result2;


	//Launches the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temperatureConverter window = new temperatureConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creates the application
	public temperatureConverter() {
		initialize();
	}

	//Contents of the Frame
	private void initialize() {
		//Frame - Holds the rest of the data
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Celsius to Fahrenheit input box
		JEditorPane celsiusTitle = new JEditorPane();
		celsiusTitle.setBounds(33, 19, 161, 16);
		celsiusTitle.setEditable(false);
		celsiusTitle.setText("        Value in Celsius");
		frame.getContentPane().add(celsiusTitle);
		
		//Celsius to Fahrenheit output box
		answerInFahrenheitTitle = new JTextField();
		answerInFahrenheitTitle.setBounds(33, 150, 161, 26);
		answerInFahrenheitTitle.setHorizontalAlignment(SwingConstants.CENTER);
		answerInFahrenheitTitle.setEditable(false);
		answerInFahrenheitTitle.setText("Answer in Fahrenheit");
		frame.getContentPane().add(answerInFahrenheitTitle);
		answerInFahrenheitTitle.setColumns(10);
		
		//Fahrenheit to Celsius input box
		celsiusValue = new JTextField();
		celsiusValue.setBounds(32, 34, 161, 26);
		celsiusValue.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(celsiusValue);
		celsiusValue.setColumns(10);
		
		//Fahrenheit to Celsius input box
		JEditorPane fahrenheitTitle = new JEditorPane();
		fahrenheitTitle.setBounds(251, 19, 161, 16);
		fahrenheitTitle.setEditable(false);
		fahrenheitTitle.setText("     Value in Fahrenheit");
		frame.getContentPane().add(fahrenheitTitle);
		
		//Celsius to Fahrenheit input box
		fahrenheitValue = new JTextField();
		fahrenheitValue.setBounds(251, 34, 161, 26);
		fahrenheitValue.setHorizontalAlignment(SwingConstants.RIGHT);
		fahrenheitValue.setColumns(10);
		frame.getContentPane().add(fahrenheitValue);
		
		//Displays answer in Fahrenheit
		answerInFahrenheit = new JTextField();
		answerInFahrenheit.setEditable(false);
		answerInFahrenheit.setBounds(33, 169, 161, 26);
		answerInFahrenheit.setHorizontalAlignment(SwingConstants.RIGHT);
		answerInFahrenheit.setColumns(10);
		frame.getContentPane().add(answerInFahrenheit);
		
		//Displays answer in Celsius
		answerInCelsius = new JTextField();
		answerInCelsius.setEditable(false);
		answerInCelsius.setBounds(251, 169, 161, 26);
		answerInCelsius.setHorizontalAlignment(SwingConstants.RIGHT);
		answerInCelsius.setColumns(10);
		frame.getContentPane().add(answerInCelsius);
		
		//Text field for the 'Answer in Celsius' title
		answerInCelsiusTitle = new JTextField();
		answerInCelsiusTitle.setBounds(251, 150, 161, 26);
		answerInCelsiusTitle.setHorizontalAlignment(SwingConstants.CENTER);
		answerInCelsiusTitle.setText("Answer in Celsius");
		answerInCelsiusTitle.setEditable(false);
		answerInCelsiusTitle.setColumns(10);
		frame.getContentPane().add(answerInCelsiusTitle);
		
		//Convert button for Celsius to Fahrenheit
		JButton cfBtn = new JButton("Convert");
		cfBtn.setBounds(27, 89, 117, 29);
		cfBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result = Double.parseDouble(celsiusValue.getText());
				result = (result * 9/5)+ 32.0;
				cfResult = String.format("%.1f", result);
				answerInFahrenheit.setText(cfResult+"℉");
			}
		});
		frame.getContentPane().add(cfBtn);
		
		//Convert button for Fahrenheit to Celsius
		JButton fcBtn = new JButton("Convert");
		fcBtn.setBounds(295, 89, 117, 29);
		fcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result2 = (Double.parseDouble(fahrenheitValue.getText()));
				result2 = (result2 - 32) * 5/9;
				fcResult = String.format("%.1f", result2);
				answerInCelsius.setText(fcResult+"℃");
			}
		});
		frame.getContentPane().add(fcBtn);
		
		//Clear button that removes all input and output
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(165, 238, 117, 29);
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				celsiusValue.setText(null);
				fahrenheitValue.setText(null);
				answerInCelsius.setText(null);
				answerInFahrenheit.setText(null);
			}
		});
		frame.getContentPane().add(clearBtn);
		
		//The panel the spits the two converters
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.GRAY);
		panel.setBounds(222, 6, 2, 220);
		frame.getContentPane().add(panel);
	}
}
