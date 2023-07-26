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
	private JComboBox comboBox;
	private JTextArea textoConvertir;
    private JRadioButton rdbtnDolar;
    private JRadioButton rdbtnEuros;
    private JRadioButton rdbtnLibras;
    private JRadioButton rdbtnYen;
    private JRadioButton rdbtnWon;
    private JTextArea textoResultado;
    private JRadioButton rdbtnFahrenheitToCelsius;
    private JRadioButton rdbtnCelsiusToKelvin;

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

		// 2.3.2. Opción radial botón euros
		JRadioButton rdbtnEuros = new JRadioButton("Convertir Pesos colombianos a Euros");
		rdbtnEuros.setBounds(10, 40, 280, 20);
		panelDivisas.add(rdbtnEuros);

		// 2.3.3. Opción radial botón libras
		JRadioButton rdbtnLibras = new JRadioButton("Convertir Pesos colombianos a Libras Esterlinas");
		rdbtnLibras.setBounds(10, 70, 280, 20);
		panelDivisas.add(rdbtnLibras);

		// 2.3.4. Opción radial botón yen
		JRadioButton rdbtnYen = new JRadioButton("Convertir Pesos colombianos a Yen Japonés");
		rdbtnYen.setBounds(10, 100, 280, 20);
		panelDivisas.add(rdbtnYen);

		// 2.3.5. Opción radial botón won
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

		// 2.4. Pánel de divisas para convertir
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

		// 2.5. Pánel de temperaturas para convertir
		panelTemperatura.setVisible(false);
		panelTemperatura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTemperatura.setBackground(new Color(51, 153, 255));
		
		panelTemperatura = new JPanel();
		panelTemperatura.setBounds(30, 120, 300, 80);
		panel.add(panelTemperatura);
		panelTemperatura.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelTemperatura.setBackground(new Color(51, 153, 255));
		panelTemperatura.setLayout(null);

		// 2.5.1. Opción radial botón Fahrenheit a Celsius
		JRadioButton rdbtnFahrenheitToCelsius = new JRadioButton("Convertir Fahrenheit a Celsius");
		rdbtnFahrenheitToCelsius.setBounds(10, 10, 260, 20);
		panelTemperatura.add(rdbtnFahrenheitToCelsius);

		// 2.5.2. Opción radial botón Celsius a Kelvin
		JRadioButton rdbtnCelsiusToKelvin = new JRadioButton("Convertir Celsius a Kelvin");
		rdbtnCelsiusToKelvin.setBounds(10, 40, 260, 20);
		panelTemperatura.add(rdbtnCelsiusToKelvin);

		radioGroup.add(rdbtnFahrenheitToCelsius);
		radioGroup.add(rdbtnCelsiusToKelvin);

		// 2.6. Ingresar valores a convertir
		// 2.6.1. Título
		JLabel lblNumeroAConvertir = new JLabel("Número a convertir:");
		lblNumeroAConvertir.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumeroAConvertir.setBounds(30, 330, 200, 14);
		panel.add(lblNumeroAConvertir);

		// 2.6.2. Número a convertir
		JTextArea textoConvertir = new JTextArea();
		textoConvertir.setBounds(30, 350, 300, 22);
		panel.add(textoConvertir);
		
		// 2.7. Botón a convertir
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConvertir.setBounds(30, 399, 300, 23);
		panel.add(btnConvertir);

		// 2.8. Imagen
		JLabel labelImagen = new JLabel("");
		labelImagen.setIcon(new ImageIcon(CurrencyInterface.class.getResource("/com/images/11.png")));
		labelImagen.setBounds(480, 20, 250, 250);
		contentPane.add(labelImagen);

		// 2.9. Ingresar valores a convertir
		// 2.9.1. Título
		JLabel lblNumeroConvertido = new JLabel("Número convertido:");
		lblNumeroConvertido.setBounds(480, 330, 200, 14);
		contentPane.add(lblNumeroConvertido);
		lblNumeroConvertido.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		// 2.10. Resultado número convertido
		TextArea textoResultado = new TextArea();
		textoResultado.setBounds(480, 350, 250, 50);
		contentPane.add(textoResultado);
	}

}
