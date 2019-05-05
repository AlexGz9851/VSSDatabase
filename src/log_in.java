import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class log_in extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel label;
	private JLabel label_1;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1 ;
	private boolean modoPrueba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log_in frame = new log_in();
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
	public log_in() {
		
		// *************************** MODO PRUEBA *********************************************
		modoPrueba=false;
		// *************************************************************************************
		
		int h=458;
		int v=308;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds((screenSize.width-h)/2, (screenSize.height-v)/2, h, v);
		setBounds((screenSize.width-h)/2, (screenSize.height-v)/2, h, v);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VSS Database");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 34));
		lblNewLabel.setBounds(120, 29, 210, 33);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(216, 97, 159, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 163, 159, 33);
		contentPane.add(passwordField);
		
		label = new JLabel("Usuario");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setBounds(30, 97, 108, 33);
		contentPane.add(label);
		
		label_1 = new JLabel("Contraseña");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.PLAIN, 30));
		label_1.setBounds(30, 163, 166, 33);
		contentPane.add(label_1);
		
		btnNewButton = new JButton("Aceptar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 153, 204));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(241, 218, 114, 40);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(0, 153, 204));
		btnNewButton_1.setBounds(63, 218, 114, 40);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton) {
			String user = textField.getText();
			String pass  = passwordField.getText();
			DatabaseConnection dc = new DatabaseConnection(modoPrueba);
			int credenciales = dc.getNivelDeCredenciales(user, pass);
			if(credenciales>=0) {
				SeleccionarAccion frame = new SeleccionarAccion(dc,user,credenciales);	
				frame.setVisible(true);
				this.dispose();
			}else if(credenciales==-2){
				JOptionPane.showConfirmDialog(null, "El usuario o contraseña fue incorrecto", "Log in fallido", 1);
			}else {
				JOptionPane.showConfirmDialog(null, "Hubo un problema con la conexión. Intente ingresar de nuevo.", "Log in fallido", 1);

			}


		}else {
			dispose();
		}
		
	}

}
