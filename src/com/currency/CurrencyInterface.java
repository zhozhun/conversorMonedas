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
import javax.swing.JButton;
import javax.swing.JTextField;

public class CurrencyInterface extends JFrame {

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

	// Campos de clase para elementos de la interfaz
	private JPanel contentPane;
	private JPanel panelDivisas;
	private JPanel panelTemperatura;
	private ButtonGroup radioGroup;

	public CurrencyInterface() {
		// 1. Dimensiones de aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 2. Elementos de la interfaz
		// 2.1. Panel principal
		JPanel panel = new JPanel();
		panel.setToolTipText("Seleccionar");
		panel.setBackground(new Color(51, 153, 255));
		panel.setBounds(0, 0, 400, 463);
		contentPane.add(panel);
		panel.setLayout(null);
		// 2.2. Panel ComboBox desplegable
		JPanel panelComboBox = new JPanel();
		panelComboBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelComboBox.setBackground(new Color(51, 153, 255));
		panelComboBox.setBounds(30, 30, 300, 50);
		panel.add(panelComboBox);
		panelComboBox.setLayout(null);
		// 2.2.1. ComboBox desplegable
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 280, 22);
		panelComboBox.add(comboBox);
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Convertir divisas", "Convertir temperatura" }));
		comboBox.setBackground(new Color(0, 153, 255));
		// 2.3. Pánel para escoger divisas a convertir
		panelDivisas = new JPanel();
		panelDivisas.setBounds(30, 120, 300, 160);
		panel.add(panelDivisas);
		panelDivisas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDivisas.setBackground(new Color(51, 153, 255));
		panelDivisas.setLayout(null);
		// 2.3.1. Opción radial botón dólar
		JRadioButton rdbtnDolar = new JRadioButton("Convertir Pesos colombianos a Dólar");
		rdbtnDolar.setBounds(10, 10, 280, 20);
		panelDivisas.add(rdbtnDolar);
		// Valor para ActionCommand
		rdbtnDolar.setActionCommand("dolar");

		// 2.3.2. Opción radial botón euros
		JRadioButton rdbtnEuros = new JRadioButton("Convertir Pesos colombianos a Euros");
		rdbtnEuros.setBounds(10, 40, 280, 20);
		panelDivisas.add(rdbtnEuros);
		// Valor para ActionCommand
		rdbtnEuros.setActionCommand("euros");

		// 2.3.3. Opción radial botón libras
		JRadioButton rdbtnLibras = new JRadioButton("Convertir Pesos colombianos a Libras Esterlinas");
		rdbtnLibras.setBounds(10, 70, 280, 20);
		panelDivisas.add(rdbtnLibras);
		// Valor para ActionCommand
		rdbtnLibras.setActionCommand("libras");

		// 2.3.4. Opción radial botón yen
		JRadioButton rdbtnYen = new JRadioButton("Convertir Pesos colombianos a Yen Japonés");
		rdbtnYen.setBounds(10, 100, 280, 20);
		panelDivisas.add(rdbtnYen);
		// Valor para ActionCommand
		rdbtnYen.setActionCommand("yen");

		// 2.3.5. Opción radial botón won
		JRadioButton rdbtnWon = new JRadioButton("Convertir Pesos colombianos a Won sur-coreano");
		rdbtnWon.setBounds(10, 130, 280, 20);
		panelDivisas.add(rdbtnWon);
		// Valor para ActionCommand
		rdbtnWon.setActionCommand("won");

		// 2.4. Pánel de temperaturas para convertir
		panelTemperatura = new JPanel();
		panelTemperatura.setBounds(30, 120, 300, 80);
		panel.add(panelTemperatura);
		panelTemperatura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTemperatura.setBackground(new Color(51, 153, 255));
		panelTemperatura.setLayout(null);
		// 2.4.1. Opción radial botón Celsius a Fahrenheit
		JRadioButton rdbtnCelsiusToFahrenheit = new JRadioButton("Convertir Celsius a Fahrenheit");
		rdbtnCelsiusToFahrenheit.setBounds(10, 10, 260, 20);
		panelTemperatura.add(rdbtnCelsiusToFahrenheit);
		rdbtnCelsiusToFahrenheit.setActionCommand("celsiusToFahrenheit");
		// 2.4.2. Opción radial botón Fahrenheit a Celsius
		JRadioButton rdbtnFahrenheitToCelsius = new JRadioButton("Convertir Fahrenheit a Celsius");
		rdbtnFahrenheitToCelsius.setBounds(10, 40, 260, 20);
		panelTemperatura.add(rdbtnFahrenheitToCelsius);
		rdbtnFahrenheitToCelsius.setActionCommand("fahrenheitToCelsius");
		// 2.5. Ingresar valores a convertir
		// 2.5.1. Título
		JLabel lblNumeroAConvertir = new JLabel("Número a convertir:");
		lblNumeroAConvertir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumeroAConvertir.setBounds(30, 330, 200, 14);
		panel.add(lblNumeroAConvertir);
		// 2.5.2. Número a convertir
		JTextArea textoConvertir = new JTextArea();
		textoConvertir.setBounds(30, 350, 300, 22);
		panel.add(textoConvertir);
		// 2.6. Botón a convertir
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConvertir.setBounds(30, 399, 300, 23);
		panel.add(btnConvertir);
		// 2.7. Imagen
		JLabel labelImagen = new JLabel("");
		labelImagen.setIcon(new ImageIcon(CurrencyInterface.class.getResource("/com/images/11.png")));
		labelImagen.setBounds(480, 20, 250, 250);
		contentPane.add(labelImagen);
		// 2.8. Ingresar valores a convertir
		// 2.8.1. Título
		JLabel lblNumeroConvertido = new JLabel("Número convertido:");
		lblNumeroConvertido.setBounds(480, 330, 200, 14);
		contentPane.add(lblNumeroConvertido);
		lblNumeroConvertido.setFont(new Font("Tahoma", Font.BOLD, 12));
		// 2.9. Resultado número convertido
		TextArea textoResultado = new TextArea();
		textoResultado.setBounds(480, 350, 250, 50);
		contentPane.add(textoResultado);

		// 3. Captura de eventos
		// 3.1. Agrupar los JRadioButton para permitir solo una selección
		radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnDolar);
		radioGroup.add(rdbtnEuros);
		radioGroup.add(rdbtnLibras);
		radioGroup.add(rdbtnYen);
		radioGroup.add(rdbtnWon);
		radioGroup.add(rdbtnCelsiusToFahrenheit);
		radioGroup.add(rdbtnFahrenheitToCelsius);
		// 3.2. Establecer visibilidad de páneles para permitir solo una selección
		// 3.2.1. Establecer la visibilidad del panel divisas
		panelDivisas.setVisible(false);
		panelDivisas.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelDivisas.setBackground(new Color(51, 153, 255));
		// 3.2.2. Establecer la visibilidad del panel temperatura
		panelTemperatura.setVisible(false);
		panelTemperatura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTemperatura.setBackground(new Color(51, 153, 255));

		// 3.3. Capturar evento de selección ComboBox
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
		// 3.4. Capturar evento Botón convertir
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener la opción de conversión seleccionada
				String opcionSeleccionada = (String) comboBox.getSelectedItem();
				// Obtener el valor ingresado por el usuario en el campo de texto
				String valorAConvertirStr = textoConvertir.getText();
				String resultado = "";

				// Verificar opción desplegable seleccionada
				if (opcionSeleccionada.equals("Convertir divisas")) {
					switch (radioGroup.getSelection().getActionCommand()) {
					case "dolar":
						double valorAConvertirDolar = Double.parseDouble(valorAConvertirStr);
						double resultadoConversionDolar = valorAConvertirDolar * 0.00026;
						resultado = String.valueOf(resultadoConversionDolar);
						break;
					case "euros":
						double valorAConvertirEuros = Double.parseDouble(valorAConvertirStr);
						double resultadoConversionEuros = valorAConvertirEuros * 0.00023;
						resultado = String.valueOf(resultadoConversionEuros);
						break;
					case "libras":
						double valorAConvertirLibras = Double.parseDouble(valorAConvertirStr);
						double resultadoConversionLibras = valorAConvertirLibras * 0.00020;
						resultado = String.valueOf(resultadoConversionLibras);
						break;
					case "yen":
						double valorAConvertirYen = Double.parseDouble(valorAConvertirStr);
						double resultadoConversionYen = valorAConvertirYen * 0.036;
						resultado = String.valueOf(resultadoConversionYen);
						break;
					case "won":
						double valorAConvertirWon = Double.parseDouble(valorAConvertirStr);
						double resultadoConversionWon = valorAConvertirWon * 0.32;
						resultado = String.valueOf(resultadoConversionWon);
						break;
					default:
						// Ninguna opción seleccionada
						resultado = "Seleccione una opción de conversión.";
					}
				} else if (opcionSeleccionada.equals("Convertir temperatura")) {
					switch (radioGroup.getSelection().getActionCommand()) {
					case "celsiusToFahrenheit":
						double valorAConvertirCtoF = Double.parseDouble(valorAConvertirStr);
						double resultadoConversionCtoF = (valorAConvertirCtoF * 1.8) + 32;
						resultado = String.valueOf(resultadoConversionCtoF);
						break;
					case "fahrenheitToCelsius":
						double valorAConvertirFtoC = Double.parseDouble(valorAConvertirStr);
						double resultadoConversionFtoC = (valorAConvertirFtoC - 32) * 0.56;
						resultado = String.valueOf(resultadoConversionFtoC);
						break;
					// case "fahrenheitToCelsius";
					// break;
					default:
						// Ninguna opción seleccionada
						resultado = "Seleccione una opción de conversión de temperatura.";
					}
				} else {
					// Opción no válida seleccionada
					resultado = "Seleccione una opción válida.";
				}

				// Mostrar el resultado en el TextArea "textoResultado"
				textoResultado.setText(resultado);
			}

		});
	};
}
