package com.currency;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.border.LineBorder;
import javax.swing.JSlider;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CurrencyInterface extends JFrame {

	private JPanel contentPane;
	private JPanel panelDivisas;
	private JPanel panelTemperatura;
	private ButtonGroup radioGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyInterface frame = new CurrencyInterface();
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
	public CurrencyInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Establecer el ícono vacío en la ventana
		this.setIconImage(
				Toolkit.getDefaultToolkit().getImage(CurrencyInterface.class.getResource("/com/images/5.png")));

		JPanel panel = new JPanel();
		panel.setToolTipText("Seleccionar");
		panel.setBackground(new Color(51, 153, 255));
		panel.setBounds(0, 0, 400, 463);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panelComboBox = new JPanel();
		panelComboBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComboBox.setBackground(new Color(51, 153, 255));
		panelComboBox.setBounds(30, 30, 300, 50);
		panel.add(panelComboBox);
		panelComboBox.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 280, 22);
		panelComboBox.add(comboBox);
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Convertir divisas", "Convertir temperatura" }));
		comboBox.setBackground(new Color(0, 153, 255));

		panelDivisas = new JPanel();
		panelDivisas.setBounds(30, 120, 300, 160);
		panel.add(panelDivisas);
		panelDivisas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDivisas.setBackground(new Color(51, 153, 255));
		panelDivisas.setLayout(null);

		JRadioButton rdbtnDolar = new JRadioButton("Convertir Pesos colombianos a Dólar");
		rdbtnDolar.setBounds(10, 10, 280, 20);
		panelDivisas.add(rdbtnDolar);

		JRadioButton rdbtnEuros = new JRadioButton("Convertir Pesos colombianos a Euros");
		rdbtnEuros.setBounds(10, 40, 280, 20);
		panelDivisas.add(rdbtnEuros);

		JRadioButton rdbtnLibras = new JRadioButton("Convertir Pesos colombianos a Libras Esterlinas");
		rdbtnLibras.setBounds(10, 70, 280, 20);
		panelDivisas.add(rdbtnLibras);

		JRadioButton rdbtnYen = new JRadioButton("Convertir Pesos colombianos a Yen Japonés");
		rdbtnYen.setBounds(10, 100, 280, 20);
		panelDivisas.add(rdbtnYen);

		JRadioButton rdbtnWon = new JRadioButton("Convertir Pesos colombianos a Won sur-coreano");
		rdbtnWon.setBounds(10, 130, 280, 20);
		panelDivisas.add(rdbtnWon);

		// Agrupar los JRadioButton para permitir solo una selección
		radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnDolar);
		radioGroup.add(rdbtnEuros);
		radioGroup.add(rdbtnLibras);
		radioGroup.add(rdbtnYen);
		radioGroup.add(rdbtnWon);

		panelDivisas.setVisible(false);

		panelDivisas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDivisas.setBackground(new Color(51, 153, 255));

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcionSeleccionada = (String) comboBox.getSelectedItem();
				if (opcionSeleccionada.equals("Convertir divisas")) {
					panelDivisas.setVisible(true); // Mostrar el panel de divisas
					panelTemperatura.setVisible(false); // Ocultar el panel de temperatura
				} else if (opcionSeleccionada.equals("Convertir temperatura")) {
					panelDivisas.setVisible(false); // Ocultar el panel de divisas
					panelTemperatura.setVisible(true); // Mostrar el panel de temperatura
				} else {
					panelDivisas.setVisible(false); // Ocultar el panel de divisas
					panelTemperatura.setVisible(false); // Ocultar el panel de temperatura
				}
			}
		});

		panelTemperatura = new JPanel();
		panelTemperatura.setBounds(30, 120, 300, 80);
		panel.add(panelTemperatura);
		panelTemperatura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTemperatura.setBackground(new Color(51, 153, 255));
		panelTemperatura.setLayout(null);

		JRadioButton rdbtnFahrenheitToCelsius = new JRadioButton("Convertir Fahrenheit a Celsius");
		rdbtnFahrenheitToCelsius.setBounds(10, 10, 260, 20);
		panelTemperatura.add(rdbtnFahrenheitToCelsius);

		JRadioButton rdbtnCelsiusToKelvin = new JRadioButton("Convertir Celsius a Kelvin");
		rdbtnCelsiusToKelvin.setBounds(10, 40, 260, 20);
		panelTemperatura.add(rdbtnCelsiusToKelvin);

		radioGroup.add(rdbtnFahrenheitToCelsius);
		radioGroup.add(rdbtnCelsiusToKelvin);

		panelTemperatura.setVisible(false);

		panelTemperatura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTemperatura.setBackground(new Color(51, 153, 255));

		JLabel lblNumeroAConvertir = new JLabel("Número a convertir:");
		lblNumeroAConvertir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumeroAConvertir.setBounds(30, 330, 200, 14);
		panel.add(lblNumeroAConvertir);

		JTextArea textoConvertir = new JTextArea();
		textoConvertir.setBounds(30, 350, 300, 22);
		panel.add(textoConvertir);

		textoConvertir.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				convertirValor();
			}

			public void removeUpdate(DocumentEvent e) {
				convertirValor();
			}

			public void insertUpdate(DocumentEvent e) {
				convertirValor();
			}
		});

		JLabel labelImagen = new JLabel("");
		labelImagen.setIcon(new ImageIcon(CurrencyInterface.class.getResource("/com/images/11.png")));
		labelImagen.setBounds(480, 20, 250, 250);
		contentPane.add(labelImagen);

		TextArea textoResultado = new TextArea();
		textoResultado.setBounds(480, 350, 250, 50);
		contentPane.add(textoResultado);
		
		JLabel lblNumeroConvertido = new JLabel("Número a convertir:");
		lblNumeroConvertido.setBounds(480, 330, 200, 14);
		contentPane.add(lblNumeroConvertido);
		lblNumeroConvertido.setFont(new Font("Tahoma", Font.BOLD, 12));
	}

	public void convertirValor() {
		String opcionSeleccionada = (String) comboBox.getSelectedItem();
		String valorTexto = textoConvertir.getText();
		double valor = 0;

		try {
			valor = Double.parseDouble(valorTexto);
		} catch (NumberFormatException e) {
			// Manejar la excepción si el valor ingresado no es numérico
			// En este caso, podrías mostrar un mensaje de error al usuario
			return;
		}

		if (opcionSeleccionada.equals("Convertir divisas")) {
			String valorConvertido = "";
			if (rdbtnDolar.isSelected()) {
				valorConvertido = convertirPesosACambio(valor, "Dólar");
			} else if (rdbtnEuros.isSelected()) {
				valorConvertido = convertirPesosACambio(valor, "Euros");
			} else if (rdbtnLibras.isSelected()) {
				valorConvertido = convertirPesosACambio(valor, "Libras");
			} else if (rdbtnYen.isSelected()) {
				valorConvertido = convertirPesosACambio(valor, "Yen");
			} else if (rdbtnWon.isSelected()) {
				valorConvertido = convertirPesosACambio(valor, "Won");
			}
			textoResultado.setText(valorConvertido);
		} else if (opcionSeleccionada.equals("Convertir temperatura")) {
			String valorConvertido = "";
			if (rdbtnFahrenheitToCelsius.isSelected()) {
				valorConvertido = convertirFahrenheitACelsius(valor);
			} else if (rdbtnCelsiusToKelvin.isSelected()) {
				valorConvertido = convertirCelsiusAKelvin(valor);
			}
			textoResultado.setText(valorConvertido);
		}
	}

	private String convertirPesosACambio(double valor, String moneda) {
		// Aquí implementas la lógica para la conversión de Pesos colombianos a la moneda especificada
		// Puedes usar tasas de cambio reales o valores fijos para hacer la conversión
		// Por ejemplo, puedes tener un método que reciba el valor en Pesos y el tipo de moneda
		// y devuelva el valor convertido en la moneda especificada
		// A modo de ejemplo, usaré un valor fijo para el Dólar y el Euro:
		double tasaDolar = 0.00027;
		double tasaEuro = 0.00023;
		double tasaLibra = 0.00020;
		double tasaYen = 0.030;
		double tasaWon = 0.00031;

		double valorConvertido = 0;
		if (moneda.equals("Dólar")) {
			valorConvertido = valor * tasaDolar;
		} else if (moneda.equals("Euros")) {
			valorConvertido = valor * tasaEuro;
		} else if (moneda.equals("Libras")) {
			valorConvertido = valor * tasaLibra;
		} else if (moneda.equals("Yen")) {
			valorConvertido = valor * tasaYen;
		} else if (moneda.equals("Won")) {
			valorConvertido = valor * tasaWon;
		}

		return String.valueOf(valorConvertido);
	}

	private String convertirFahrenheitACelsius(double valor) {
		// Aquí implementas la lógica para convertir Fahrenheit a Celsius
		// La fórmula para la conversión es: (valor - 32) * 5/9
		double valorConvertido = (valor - 32) * 5 / 9;
		return String.valueOf(valorConvertido);
	}

	private String convertirCelsiusAKelvin(double valor) {
		// Aquí implementas la lógica para convertir Celsius a Kelvin
		// La fórmula para la conversión es: valor + 273.15
		double valorConvertido = valor + 273.15;
		return String.valueOf(valorConvertido);
	}
}
