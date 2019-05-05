
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Delete extends JFrame  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DatabaseConnection dc;
	private JButton btnAceptar;
	private JButton btnNewButton;
	private JLabel lblresult;
	private JComboBox<String> comboBox_1 ;
	private JComboBox<String> comboBox ;
	private int nivelDeCredenciales;
	private String user;
	private JLabel lblUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnection dc = new DatabaseConnection(true);
					Delete frame = new Delete(dc, null, 0);
					Delete frame1 = new Delete(dc, null, 1);
					Delete frame2 = new Delete(dc, null, 2);
					frame.setVisible(true);
					frame1.setVisible(true);
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Delete(DatabaseConnection dc, String user, int nivelDeCredenciales) {
		this.dc = dc;
		this.user= user;
		this.nivelDeCredenciales=nivelDeCredenciales;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		
		int h=780;
		int v=537;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setBounds((screenSize.width-h)/2, (screenSize.height-v)/2, h, v);
		setBounds((screenSize.width-h)/2, (screenSize.height-v)/2, h, v);
		

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarElementos = new JLabel("Eliminar Elementos");
		lblEliminarElementos.setForeground(Color.WHITE);
		lblEliminarElementos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblEliminarElementos.setBounds(61, 24, 261, 34);
		contentPane.add(lblEliminarElementos);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 28));
		comboBox.setBounds(309, 94, 299, 34);
		comboBox.setEditable(false);
		contentPane.add(comboBox);
		
		JLabel lblEliminar = new JLabel("Eliminar de: ");
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Arial", Font.BOLD, 30));
		lblEliminar.setBounds(76, 94, 188, 34);
		contentPane.add(lblEliminar);
		

		
		JLabel lblCondicin = new JLabel("Buscar por:");
		lblCondicin.setVisible(false);
		lblCondicin.setForeground(Color.WHITE);
		lblCondicin.setFont(new Font("Arial", Font.BOLD, 30));
		lblCondicin.setBounds(76, 162, 188, 34);
		contentPane.add(lblCondicin);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setVisible(false);
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 28));
		comboBox_1.setBounds(309, 162, 299, 34);
		comboBox_1.setEditable(false);
		contentPane.add(comboBox_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setVisible(false);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Arial", Font.BOLD, 30));
		lblId.setBounds(76, 248, 188, 34);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setVisible(false);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 30));
		lblNombre.setBounds(76, 248, 188, 34);
		contentPane.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setVisible(false);
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 30));
		lblApellidos.setBounds(76, 302, 188, 34);
		contentPane.add(lblApellidos);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setVisible(false);
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setFont(new Font("Arial", Font.BOLD, 30));
		lblNumero.setBounds(76, 356, 188, 34);
		contentPane.add(lblNumero);
		
		JLabel lblAntiguedad = new JLabel("Antiguedad (en dias):");
		lblAntiguedad.setVisible(false);
		lblAntiguedad.setForeground(Color.WHITE);
		lblAntiguedad.setFont(new Font("Arial", Font.BOLD, 30));
		lblAntiguedad.setBounds(61, 356, 311, 34);
		contentPane.add(lblAntiguedad);
		
		lblresult = new JLabel("AQUI VA EL RESULTADO DEL QUERY");
		lblresult.setVisible(false);
		lblresult.setForeground(Color.CYAN);
		lblresult.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblresult.setBounds(61, 401, 547, 34);
		contentPane.add(lblresult);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(382, 254, 226, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setVisible(false);
		textField_1.setColumns(10);
		textField_1.setBounds(382, 302, 226, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setVisible(false);
		textField_2.setColumns(10);
		textField_2.setBounds(382, 356, 226, 34);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("Regresar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(114, 446, 131, 41);
		contentPane.add(btnNewButton);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAceptar.setBounds(433, 446, 131, 41);
		btnAceptar.setVisible(false);
		
		btnAceptar.addActionListener( this);
		btnNewButton.addActionListener( this);

		contentPane.add(btnAceptar);
		
		lblUsuario = new JLabel("Usuario: "+user);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblUsuario.setBounds(389, 11, 325, 34);
		contentPane.add(lblUsuario);
		
		JLabel lblPermisos = new JLabel("Permisos: "+dc.strCredenciales(nivelDeCredenciales));
		lblPermisos.setForeground(Color.WHITE);
		lblPermisos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblPermisos.setBounds(389, 49, 325, 34);
		contentPane.add(lblPermisos);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato");
		lblTipoDeContrato.setFont(new Font("Arial", Font.BOLD, 30));
		lblTipoDeContrato.setForeground(Color.WHITE);
		lblTipoDeContrato.setBounds(76, 248, 258, 34);
		lblTipoDeContrato.setVisible(false);
		contentPane.add(lblTipoDeContrato);
		
		JLabel lblNumeroDeContrato = new JLabel("N° de Contrato");
		lblNumeroDeContrato.setFont(new Font("Arial", Font.BOLD, 30));
		lblNumeroDeContrato.setForeground(Color.WHITE);
		lblNumeroDeContrato.setBounds(76, 302, 258, 34);
		lblNumeroDeContrato.setVisible(false);
		contentPane.add(lblNumeroDeContrato);

		refreshTablesOptions(comboBox, nivelDeCredenciales);
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
			          //Eligió tabla
					
					String tabla = (String) comboBox.getSelectedItem();
					lblCondicin.setVisible(true);
					comboBox_1.setVisible(true);
					refreshConditionsOptions(comboBox_1 ,  tabla);
					
				
					comboBox_1.addItemListener(new ItemListener() {
						@Override
						public void itemStateChanged(ItemEvent e) {
							
							if (e.getStateChange() == ItemEvent.SELECTED) {
								//Eligio condición
								
								String condicion  = (String) comboBox_1.getSelectedItem();
								btnAceptar.setVisible(true);
								if(condicion.equals("Por antiguedad")) {
									lblAntiguedad.setVisible(true);
									
									lblId.setVisible(false);		
									lblNombre.setVisible(false);
									lblApellidos.setVisible(false);
									lblNumero.setVisible(false);
									lblTipoDeContrato.setVisible(false);
									lblNumeroDeContrato.setVisible(false);
									
									textField.setVisible(false);
									textField_1.setVisible(false);
									textField_2.setVisible(true);
									
									
									
								}else if(condicion.equals("Por Numero")) {
									lblNumero.setVisible(true);
									
									lblId.setVisible(false);		
									lblNombre.setVisible(false);
									lblApellidos.setVisible(false);
									lblAntiguedad.setVisible(false);
									lblTipoDeContrato.setVisible(false);
									lblNumeroDeContrato.setVisible(false);
									
									textField.setVisible(false);
									textField_1.setVisible(false);
									textField_2.setVisible(true);
									
								}else if(condicion.equals("Nombre y Apellidos")) {
									lblNombre.setVisible(true);
									lblApellidos.setVisible(true);
									
									lblId.setVisible(false);		
									lblNumero.setVisible(false);
									lblTipoDeContrato.setVisible(false);
									lblNumeroDeContrato.setVisible(false);
									lblAntiguedad.setVisible(false);
									
									textField.setVisible(true);
									textField_1.setVisible(true);
									textField_2.setVisible(false);
									
								}else if(condicion.equals("Id")) {
									if(tabla.equals("Contrato")) {
										lblTipoDeContrato.setVisible(true);
										lblNumeroDeContrato.setVisible(true);
										
										lblId.setVisible(false);
										lblNombre.setVisible(false);
										lblApellidos.setVisible(false);
										lblNumero.setVisible(false);
										lblAntiguedad.setVisible(false);
										
										textField.setVisible(true);
										textField_1.setVisible(true);
										textField_2.setVisible(false);
									}else {
										lblId.setVisible(true);
										
										lblNombre.setVisible(false);
										lblApellidos.setVisible(false);
										lblNumero.setVisible(false);
										lblAntiguedad.setVisible(false);
										lblTipoDeContrato.setVisible(false);
										lblNumeroDeContrato.setVisible(false);
										
										textField.setVisible(true);
										textField_1.setVisible(false);
										textField_2.setVisible(false);
									}
									
								}else if(condicion.equals("Por Numero, Nombre y Apellidos")){ // 
									lblNombre.setVisible(true);
									lblApellidos.setVisible(true);
									lblNumero.setVisible(true);
									
									lblId.setVisible(false);		
									lblAntiguedad.setVisible(false);
									lblTipoDeContrato.setVisible(false);
									lblNumeroDeContrato.setVisible(false);
									
									textField.setVisible(true);
									textField_1.setVisible(true);
									textField_2.setVisible(true);
									
								}else if(condicion.equals("Nombre") || condicion.equals("Nombre de Usuario")) {
									lblNombre.setVisible(true);
									
									lblId.setVisible(false);		
									lblApellidos.setVisible(false);
									lblNumero.setVisible(false);
									lblAntiguedad.setVisible(false);
									lblTipoDeContrato.setVisible(false);
									lblNumeroDeContrato.setVisible(false);
									
									textField.setVisible(true);
									textField_1.setVisible(false);
									textField_2.setVisible(false);
									
								}else {
									lblId.setVisible(false);
									lblNombre.setVisible(false);
									lblApellidos.setVisible(false);
									lblNumero.setVisible(false);
									lblAntiguedad.setVisible(false);
									lblTipoDeContrato.setVisible(false);
									lblNumeroDeContrato.setVisible(false);
									
									textField.setVisible(false);
									textField_1.setVisible(false);
									textField_2.setVisible(false);
									btnAceptar.setVisible(false);
									
								}
								
								
							
							}
							
						}
					});
					
			    }
			}
		});

		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar) {
			String  q = createQuery();
			if(dc.getModoPrueba()) {
				lblresult.setText(q);
				lblresult.setVisible(true);
			}else {
				boolean result = dc.resultDeleteQuery(q);
				lblresult.setText(result?"Se han borrado los registros pedidos" : "Ha habido un problema al intentar borrar las tuplas.");
				lblresult.setVisible(true);
				
			}
		}else {
			SeleccionarAccion s = new SeleccionarAccion(dc,user,nivelDeCredenciales );
			s.setVisible(true);
			this.dispose();
		}
	}
	
	private void refreshConditionsOptions(JComboBox<String> cb , String tabla) {
		cb.removeAllItems();
		cb.addItem("");
		if(tabla.equals("Contrato")) {
			cb.addItem("Por antiguedad");
		}
		if(   ( tabla.equals("TelefonoCl") || tabla.equals("TelefonoCo") || tabla.equals("TelefonoV") )) {
			cb.addItem("Por Numero");
			cb.addItem("Por Numero, Nombre y Apellidos");
			cb.addItem("Nombre y Apellidos");
			
			
		}else if(tabla.equals("Usuario")){
			cb.addItem("Nombre de Usuario");
		}else{
			cb.addItem("Id");
		}
		if(tabla.equals("Cliente") || tabla.equals("Vendedor") || tabla.equals("Supervisor")  || tabla.equals("Cobrador")  
				) {
			cb.addItem("Nombre y Apellidos");

		}
		if(tabla.equals("Departamento") ) {
			cb.addItem("Nombre");
		}
		
		
	}
	
	public  boolean isValid(String text) {
	    try {
	      Integer.parseInt(text);
	      return true;
	    } catch (NumberFormatException e) {
	      return false;
	    }
	  }
	
	private void refreshTablesOptions(JComboBox<String> cb , int nivelDeCredenciales) {
		cb.removeAllItems();
		String[][] listaDeTablas =
		{
				{"","Cliente", "TelefonoCl"},
				{"TelefonoV", "Vendedor","TelefonoCo","Cobrador"},
				{"Supervisor", "Contrato", "TipoDeContrato", "Pago", "Departamento","Usuario"}
				                
		};
		// 0 --> vendedor
		// 1--> supervisor
		// 2--> administrador
		for(int i=0;i<=nivelDeCredenciales;i++) {
			for(int j=0;j<listaDeTablas[i].length;j++) {
				cb.addItem(listaDeTablas[i][j]);
			}
		}
		
		
	}
	
	private String createQuery() {
		String q = "DELETE FROM " + (String)comboBox.getSelectedItem()+ " WHERE ";
		String opcion = (String)comboBox_1.getSelectedItem();
		String tabla = (String)comboBox.getSelectedItem();
		String s1 = textField.getText();
		String s2 = textField_1.getText();
		String s3 = textField_2.getText();
		
		if(opcion.equals("Por antiguedad")) {
			q += "fechaalta+"+s3 +" < sysdate ";
		}else if(opcion.equals("Por Numero")) {
			q += 	"telefono= "+ s3 +" ";
		}else if(opcion.equals("Por Numero, Nombre y Apellidos")) {
			q += "nombre= '" + s1 + "'  and apellidos =  '" + s2 + "' and telefono= "+ s3  +" ";
		}else if(opcion.equals("Nombre y Apellidos")) {
			q += "nombre= '" + s1 + "'  and apellidos =  '" + s2 + "' ";
		}else if(opcion.equals("Id")) {
			// contratos, sintaxis
			if(tabla.equals("Contrato")) {
				q+= "tipoDeContratoID='" + s1 + "' and numContrato='" +s2  +"' ";
			}else if(tabla.equals("Cliente") ||tabla.equals("Departamento") || tabla.equals("Supervisor")  
					|| tabla.equals("TipoDeContrato")   ) {
				q += tabla+"id "+" ='" +s1  + "'" ;
			}else {// vendedor , cobrador, pago
				q += " id"+tabla+" ='" +s1  + "'" ;
			}
		}else if(opcion.equals("Nombre")) {// tabla: departamento;
			q += "nombre= '" + s1 +"' ";
		}else {
			q += "usuario= '" + s1 + "' ";

			
		}
		
		return q;
	}
	
	private void close() {
		dc.endConection();
		System.exit(0);
	}
}
