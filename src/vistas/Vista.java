package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void vista() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
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
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Radio button
		JRadioButton rdbWindows = new JRadioButton("Windows");
		rdbWindows.setBounds(51, 66, 109, 23);
		rdbWindows.setActionCommand("Windows");
		contentPane.add(rdbWindows);
		
		JRadioButton rdbLinux = new JRadioButton("Linux");
		rdbLinux.setBounds(162, 66, 109, 23);
		rdbWindows.setActionCommand("Linux");
		contentPane.add(rdbLinux);
		
		JRadioButton rdbMac = new JRadioButton("Mac");
		rdbMac.setBounds(273, 66, 109, 23);
		rdbWindows.setActionCommand("Mac");
		contentPane.add(rdbMac);
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rdbWindows);
		bGroup.add(rdbLinux);
		bGroup.add(rdbMac);		
		
		//Labels
		JLabel lblNewLabel = new JLabel("Elige un sistema operativo");
		lblNewLabel.setBounds(120, 22, 164, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Elige tu especialidad");
		lblNewLabel_1.setBounds(120, 114, 136, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Horas dedicadas al ordenador");
		lblNewLabel_2.setBounds(120, 211, 164, 14);
		contentPane.add(lblNewLabel_2);
		
		//CheckBoxs
		JCheckBox chckbxNewCheckBox = new JCheckBox("Programación");
		chckbxNewCheckBox.setBounds(51, 157, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Diseño Grafico");
		chckbxNewCheckBox_1.setBounds(150, 157, 97, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Administración");
		chckbxNewCheckBox_2.setBounds(249, 157, 133, 23);
		contentPane.add(chckbxNewCheckBox_2);		
		
		//Slider
		JSlider slider = new JSlider(0,10);		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setBounds(105, 252, 200, 45);
		contentPane.add(slider);
		
		//Button
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sistemaOperativo = "Sistema Operativo: ";
				
				for(Enumeration<AbstractButton> buttons = bGroup.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					if(button.isSelected()) {
						sistemaOperativo += button.getText();
					}
				}				
				String especialidades = "Especialidades | ";
				
				if(chckbxNewCheckBox.isSelected()) {
					especialidades += chckbxNewCheckBox.getText() + " | ";
				}
				if(chckbxNewCheckBox_1.isSelected()) {
					especialidades += chckbxNewCheckBox_1.getText() + " | ";
				}
				if(chckbxNewCheckBox_2.isSelected()) {
					especialidades += chckbxNewCheckBox_2.getText() + " | ";
				}
				
				int horas = slider.getValue();				
				
				JOptionPane.showMessageDialog(null, sistemaOperativo + "\n" + especialidades + "\nHoras: " + horas);
			}
		});
		btnNewButton.setBounds(158, 340, 89, 23);
		contentPane.add(btnNewButton);
	}
}
