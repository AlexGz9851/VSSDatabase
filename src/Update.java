import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Update extends JFrame  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DatabaseConnection dc;
	private JButton btnAceptar;
	private JButton btnNewButton;
	private JLabel lblresult;
	private JComboBox<String> comboBox ;

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private JLabel lblUsuario;
	private JLabel lblInsertarElementos ;
	private JLabel lblInsertarEn;
	private JLabel lblId;
	private JLabel lblApellidos;
	private JLabel lblNombre;
	private JLabel lblIDdelSup;
	private JLabel lblNumero;
	private JLabel lblTelefono;
	private JLabel lblIDDep;
	private JLabel lblLocacion;
	private JLabel lblCalle;
	private JLabel lblHorario;
	private JLabel lblPermisos;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_ID;
	private JLabel lblZona;
	private JLabel lblColonia;
	private JTextField calle_field;
	private String usuario;
	private int nivelDeCredenciales;
	Hashtable<String, String> equivalenciaTablas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnection dc = new DatabaseConnection(true);
					Update frame = new Update(dc, null, 2);
					Update frame2 = new Update(dc, null, 1);
					Update frame1 = new Update(dc, null, 0);
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
	public Update(DatabaseConnection dc, String user, int nivelDeCredenciales) {
		this.dc = dc;
		this.usuario = user;
		this.nivelDeCredenciales = nivelDeCredenciales;
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		
	
		int h=750;
		int v=537;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setBounds((screenSize.width-h)/2, (screenSize.height-v)/2, h, v);
		setBounds((screenSize.width-h)/2, (screenSize.height-v)/2, h, v);
		
		
		equivalenciaTablas= new Hashtable<String, String>();
		equivalenciaTablas.put("Un Cliente", "Cliente");
		equivalenciaTablas.put("", "");
		equivalenciaTablas.put("Un Cobrador", "Cobrador");
		equivalenciaTablas.put("Un Departamento", "Departamento");
		equivalenciaTablas.put("Un Supervisor", "Supervisor");
		equivalenciaTablas.put("Un Vendedor", "Vendedor");


		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 28));
		comboBox.setBounds(309, 94, 300, 34);
		comboBox.setEditable(false);
		contentPane.add(comboBox);
		
		lblInsertarElementos = new JLabel("Actualizar Elementos");
		lblInsertarElementos.setForeground(Color.WHITE);
		lblInsertarElementos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblInsertarElementos.setBounds(25, 24, 320, 34);
		contentPane.add(lblInsertarElementos);
		
		lblInsertarEn = new JLabel("Actualizar datos de:");
		lblInsertarEn.setForeground(Color.WHITE);
		lblInsertarEn.setFont(new Font("Arial", Font.BOLD, 30));
		lblInsertarEn.setBounds(10, 94, 289, 34);
		contentPane.add(lblInsertarEn);
		
		lblId = new JLabel("ID:");
		lblId.setVisible(false);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Arial", Font.BOLD, 30));
		lblId.setBounds(199, 160, 40, 34);
		contentPane.add(lblId);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setVisible(false);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 30));
		lblNombre.setBounds(115, 200, 124, 34);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setVisible(false);
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 30));
		lblApellidos.setBounds(93, 240, 154, 34);
		contentPane.add(lblApellidos);
		
		lblIDDep = new JLabel("ID del Dep:");
		lblIDDep.setVisible(false);
		lblIDDep.setForeground(Color.WHITE);
		lblIDDep.setFont(new Font("Arial", Font.BOLD, 30));
		lblIDDep.setBounds(80, 280, 162, 34);
		contentPane.add(lblIDDep);
		
		lblIDdelSup = new JLabel("ID del Sup:");
		lblIDdelSup.setVisible(false);
		lblIDdelSup.setForeground(Color.WHITE);
		lblIDdelSup.setFont(new Font("Arial", Font.BOLD, 30));
		lblIDdelSup.setBounds(83, 280, 162, 34);
		contentPane.add(lblIDdelSup);
		
		lblresult = new JLabel("AQUI VA EL RESULTADO DEL QUERY");
		lblresult.setVisible(false);
		lblresult.setForeground(Color.CYAN);
		lblresult.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblresult.setBounds(61, 401, 547, 34);
		contentPane.add(lblresult);
		
		btnNewButton = new JButton("Regresar");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(157, 446, 131, 41);
		contentPane.add(btnNewButton);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAceptar.setBounds(482, 446, 131, 41);
		btnAceptar.setVisible(false);
		
		btnAceptar.addActionListener( this);
		btnNewButton.addActionListener( this);

		contentPane.add(btnAceptar);
		
		lblUsuario = new JLabel("Usuario: "+usuario);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblUsuario.setBounds(389, 11, 325, 34);
		contentPane.add(lblUsuario);
		
		lblPermisos = new JLabel("Permisos: "+dc.strCredenciales(nivelDeCredenciales));
		lblPermisos.setForeground(Color.WHITE);
		lblPermisos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblPermisos.setBounds(389, 49, 325, 34);
		contentPane.add(lblPermisos);
		
		lblCalle = new JLabel("Calle:");
		lblCalle.setVisible(false);
		lblCalle.setFont(new Font("Arial", Font.BOLD, 30));
		lblCalle.setForeground(Color.WHITE);
		lblCalle.setBounds(153, 280, 162, 34);
		lblCalle.setVisible(false);
		contentPane.add(lblCalle);
		
		lblLocacion = new JLabel("Locaci\u00F3n:");
		lblLocacion.setFont(new Font("Arial", Font.BOLD, 30));
		lblLocacion.setForeground(Color.WHITE);
		lblLocacion.setBounds(98, 325, 141, 34);
		lblLocacion.setVisible(false);
		contentPane.add(lblLocacion);
		
		refreshTablesOptions(comboBox, nivelDeCredenciales);
				
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		textField_1.setBounds(256, 200, 336, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		textField_2.setBounds(256, 240, 336, 26);
		contentPane.add(textField_2);
		
		
		textField_3 = new JTextField();
		textField_3.setVisible(false);
		textField_3.setColumns(10);
		textField_3.setBounds(256, 325, 227, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setVisible(false);
		textField_4.setColumns(10);
		textField_4.setBounds(256, 362, 227, 26);
		contentPane.add(textField_4);
		
		calle_field = new JTextField();
		calle_field.setVisible(false);
		calle_field.setBounds(256, 280, 336, 26);
		contentPane.add(calle_field);
		calle_field.setColumns(10);
		
		lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setVisible(false);
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 30));
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(100, 364, 154, 26);
		contentPane.add(lblTelefono);
		
		lblNumero = new JLabel("Número:");
		lblNumero.setVisible(false);
		lblNumero.setFont(new Font("Arial", Font.BOLD, 30));
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setBounds(108, 364, 131, 26);
		contentPane.add(lblNumero);
		
		lblZona = new JLabel("Zona:");
		lblZona.setVisible(false);
		lblZona.setFont(new Font("Arial", Font.BOLD, 30));
		lblZona.setForeground(Color.WHITE);
		lblZona.setBounds(157, 325, 82, 34);
		contentPane.add(lblZona);
		
		
		lblHorario = new JLabel("Horario:");
		lblHorario.setVisible(false);
		lblHorario.setFont(new Font("Arial", Font.BOLD, 30));
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setBounds(120, 325, 130, 34);
		contentPane.add(lblHorario);
		
		lblColonia = new JLabel("Colonia:");
		lblColonia.setVisible(false);
		lblColonia.setFont(new Font("Arial", Font.BOLD, 30));
		lblColonia.setForeground(Color.WHITE);
		lblColonia.setBounds(115, 325, 150, 34);
		contentPane.add(lblColonia);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(255, 280, 230, 34);
		comboBox_1.setVisible(false);
		comboBox_1.setEditable(false);
		contentPane.add(comboBox_1);
		
		comboBox_ID = new JComboBox<String>();
		comboBox_ID.setEditable(false);
		comboBox_ID.setVisible(false);
		comboBox_ID.setBounds(256, 160, 230, 34);
		contentPane.add(comboBox_ID);
		
		btnAceptar.addActionListener(this);
		
		comboBox.addItemListener(new ItemListener() {

			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
			          //Eligió tabla
					String elem = (String)comboBox.getSelectedItem();
					String tabla = equivalenciaTablas.get(elem);
					btnAceptar.setVisible(true);
					refreshVisibleElements(tabla);
					refreshIDElements(1, tabla);
					refreshIDElements(0, tabla);
				
				}
			}
		});
		
		comboBox_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Eligio ID
				}
			}
		});

		comboBox_ID.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Eligio ID
				}
			}
		});
		
		
	}
	private void refreshIDElements(int i, String tabla) {
		JComboBox<String> cb;
		
		String q, selectfromtable;
		
		if(i==1) {
			cb = comboBox_1;
			cb.removeAllItems();
			if(tabla.equals("Vendedor") || tabla.equals("Cobrador") ) {
				// ref to Sup
				selectfromtable="Supervisor";
			}else  {
				// ref to dep
				selectfromtable="Departamento";
				
			}
		}else {
			cb = comboBox_ID;
			cb.removeAllItems();
			selectfromtable=tabla;
		}
		
		cb.addItem("");
		q=createIDSelectQ(selectfromtable);
		LinkedList<String> options = dc.rowSelectQuery(q);
		for(String id : options) {
			cb.addItem(id);
		}
	}
	
	private String createIDSelectQ(String tabla) {
		String q = "Select ";
		if(tabla.equals("Contrato")) {
			q+=  "numContrato ";
		}else if(tabla.equals("Cliente") ||tabla.equals("Departamento") || tabla.equals("Supervisor")  
				|| tabla.equals("TipoDeContrato")   ) {
			q += tabla+"id ";
		}else {// vendedor , cobrador, pago
			q += " id"+tabla;
		}
		q+= " from "+tabla;
		return q;
	}

	
	private void refreshTablesOptions(JComboBox<String> cb , int nivelDeCredenciales) {
		cb.removeAllItems();
		String[][] listaDeTablas =
		{
				{"","Un Cliente" },
				{"", "Un Vendedor","Un Cobrador","Un Cliente"},
				{"","Un Supervisor", "Un Departamento" },

		};
		// 0 --> vendedor
		// 1--> supervisor
		// 2--> administrador
		for(int j=0;j<listaDeTablas[nivelDeCredenciales].length;j++) {
				cb.addItem(listaDeTablas[nivelDeCredenciales][j]);
		}		
	}
	
	private void close() {
		dc.endConection();
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnAceptar) {
			if(isAllValid()) {
				String  q = createUpdateQuery();
				if(dc.getModoPrueba()) {
					lblresult.setText(q);
					lblresult.setVisible(true);
				}else {
					System.out.println(q);
					boolean result = dc.resultUpdateQuery(q);
					lblresult.setText(result?"Se ha actualizado la tupla": "No se ha podido actualizar la tupla");
					lblresult.setVisible(true);
				}
			}else {
				lblresult.setText("Hay caracteres no validos en campos numéricos");
				lblresult.setVisible(true);
			}
		}else {
			SeleccionarAccion s = new SeleccionarAccion(dc, usuario, nivelDeCredenciales);
			s.setVisible(true);
			this.dispose();
		}
		
	}
	private String createUpdateQuery() {
		
		String tabla = equivalenciaTablas.get((String) comboBox.getSelectedItem());
		
		String q ="UPDATE " + tabla + " SET ";
		String t1 = textField_1.getText();
		String t2 = textField_2.getText();
		String t3 = textField_3.getText();
		String t4 = textField_4.getText();
		String id = (String)comboBox_ID.getSelectedItem();
		String fk = (String)comboBox_1.getSelectedItem();
		String c = calle_field.getText();
		if(tabla.equals( "Cliente")) {
			
			
			q+=( t1.equals("") ? "" : (" nombre= "+"'"+t1+"'"))
			+(t1.equals("") || (t2.equals("") && c.equals("") && t3.equals("") && t4.equals(""))?" ":" , ")	
			+( t2.equals("") ? "" : ("apellidos= "+"'"+t2+"'"))
			+(t2.equals("") ||(c.equals("") && t3.equals("") && t4.equals(""))?" ":" , ")	
			+( c.equals("") ? "" : ("calle= "+"'"+c+"'"))
			+(c.equals("") || (t3.equals("") && t4.equals(""))?" ":" , ")	
			+( t4.equals("") ? "" : ("numero= "+t4))
			+(t4.equals("") ||t3.equals("")?" ":", ")	
			+( t3.equals("") ? "" : ("colonia="+"'"+t3+"'"))
			+"WHERE clienteID= '"+id+"'"
			;
		}else if(tabla.equals(  "Departamento")) {
			
			q+=( t1.equals("") ? "" : (" nombre= "+"'"+t1+"'"))
					+((t1.equals("") || (t3.equals("")))?" ":", ")	
					+ (t3.equals("") ? " " : ("locacion="+"'"+t3+"'"))
					+"WHERE DepartamentoId= '"+id+"'";
			
		}else if(tabla.equals(  "Supervisor")) {

			q+=( t1.equals("") ? "" : (" nombre= "+"'"+t1+"'"))
					+(t1.equals("") ||((t2.equals("") && fk.equals("") && t4.equals("")))?" ":" , ")	
					+ ( t2.equals("") ? "" : ("apellidos= "+"'"+t2+"'"))
					+(t2.equals("") ||(( fk.equals("") && t4.equals("")))?" ":" , ")	
					+ ( t4.equals("") ? "" : ("teléfono= "+t4))
					+((t4.equals("") ||fk.equals(""))?" ":" , ")	
					+ (fk.equals("")  ? "" : ("DepartamentoId="+"'"+fk+"'"+" "))
					+"WHERE supervisorID= '"+id+"'";	
			
		}else if(tabla.equals( "Vendedor")) {

			q+=( t1.equals("") ? "" : ("nombre= "+"'"+t1+"'"))
				+(t1.equals("") ||(t2.equals("") && fk.equals("") && t3.equals(""))?" ":" , ")	
				+ ( t2.equals("") ? "" : ("apellidos= "+"'"+t2+"'"))
				+(t2.equals("") ||(fk.equals("") && t3.equals(""))?" ":" , ")	
				+ (fk.equals("")  ? "" : ("idSupervisor= "+"'"+fk+"'"))
				+((fk.equals("") || t3.equals(""))?" ":" , ")	
				+ (t3.equals("") ? "" : ("horariosDeOficina= "+"'"+t3+"'"+" "))
				+"WHERE idVendedor= "+"'"+id+"'";
			


		}else if(tabla.equals( "Cobrador")) {
			q+= ( t1.equals("") ? "" : ("nombre= "+"'"+t1+"'"))
					+(t1.equals("") ||(t2.equals("") && fk.equals("") && t3.equals(""))?" ":" , ")	
					+ ( t2.equals("") ? "" : ("apellidos= "+"'"+t2+"'")) 
					+(t2.equals("") ||(fk.equals("") && t3.equals(""))?" ":" , ")	
					+ (t3.equals("") ? "" : ("zona= "+"'"+t3+"'"))
					+(t3.equals("") || (fk.equals(""))?" ":" , ")	
					+ (fk.equals("")  ? "" : ("supervisor= "+"'"+fk+"'"+" "))
					+"WHERE idCobrador= "+"'"+id+"'";
		}
		return q;
	}
	 
	public  boolean isAllValid() {
		String tabla= equivalenciaTablas.get((String)comboBox.getSelectedItem());
		if(tabla.equals("Cliente") || tabla.equals("Supervisor")) {
			return isValid(textField_4.getText());
		}
		return true;
	}
	public  boolean isValid(String text) {
			if(text.equals("")) {
				return true;
			}
		    try {
		      Integer.parseInt(text);
		      return true;
		    } catch (NumberFormatException e) {
		      return false;
		    }
		  }
	
	private void refreshVisibleElements(String tabla) {
		
		lblId.setVisible(true);
		lblApellidos.setVisible(false);
		lblNombre.setVisible(false);
		lblIDdelSup.setVisible(false);
		lblNumero.setVisible(false);
		lblTelefono.setVisible(false);
		lblIDDep.setVisible(false);
		lblLocacion.setVisible(false);
		lblCalle.setVisible(false);
		lblZona.setVisible(false);
		lblColonia.setVisible(false);
		lblHorario.setVisible(false);
		textField_1.setVisible(true);
		textField_2.setVisible(true);
		textField_4.setVisible(true);
		textField_3.setVisible(false);
		calle_field.setVisible(false);
		comboBox_1.setVisible(false);
		comboBox_ID.setVisible(true);
		

		
		if(tabla.equals("Cliente")) {
			
			lblCalle.setVisible(true);
			lblNumero.setVisible(true);
			lblNombre.setVisible(true);
			lblApellidos.setVisible(true);
			lblColonia.setVisible(true);
			textField_3.setVisible(true);
			calle_field.setVisible(true);
			
		}else if(tabla.equals("Vendedor")) {
			
			lblIDdelSup.setVisible(true);
			lblNombre.setVisible(true);
			lblApellidos.setVisible(true);
			lblHorario.setVisible(true);
			textField_4.setVisible(false);
			textField_3.setVisible(true);
			comboBox_1.setVisible(true);

			
		}else if(tabla.equals("Departamento")) {
			
			lblNombre.setVisible(true);
			lblLocacion.setVisible(true);
			textField_2.setVisible(false);
			textField_4.setVisible(false);
			textField_3.setVisible(true);			
			
			
			
		}else if(tabla.equals("Cobrador")) {
			
			lblNombre.setVisible(true);
			lblZona.setVisible(true);
			lblIDdelSup.setVisible(true);
			lblApellidos.setVisible(true);
			textField_4.setVisible(false);
			textField_3.setVisible(true);
			comboBox_1.setVisible(true);
			
			
			
		}else if(tabla.equals("Supervisor")) {
			
			lblNombre.setVisible(true);
			lblIDDep.setVisible(true);
			lblTelefono.setVisible(true);
			lblApellidos.setVisible(true);
			
			comboBox_1.setVisible(true);

			
		}else {
			btnAceptar.setVisible(true);
			comboBox_ID.setVisible(false);
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			textField_4.setVisible(false);
			textField_3.setVisible(false);
			lblId.setVisible(false);

			
		}
	}
}