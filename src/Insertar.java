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

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;





public class Insertar extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DatabaseConnection dc;
	private JButton btnAceptar;
	private JButton btnNewButton;
	private JLabel lblresult;
	private JComboBox<String> comboBox ;
	private JTextField textField;
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
	private JLabel lblPermisos;
	private JLabel lblContrasea;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3;
	private JLabel lblZona;
	private JLabel lblIdDelCobrador;
	private JLabel lblColonia;
	private JLabel lblHorario;
	private JLabel lblFecha;
	private JLabel lblCosto;
	private JLabel lblPagoSemanal;
	private JLabel lblComisintotal;
	private JLabel lblCantidad;
	private JLabel lblIdVendedor;
	private JLabel lblInversioninicial;
	private JLabel lblNumContrato;
	private JLabel lblTipoDeContrato;
	private JLabel lblNumerodecontrato;
	private JLabel lblIdCliente;
	private JTextField calle_field;
	private String usuario;
	private int nivelDeCredenciales;
	Hashtable<String, String> equivalenciaTablas;
	private JLabel lblPermisos_1;
	private JLabel lblElTelefonoPertenece;
	private JLabel lblElTelefonoPertenece1;
	private JLabel lblvendocob;
	String lastQuery;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnection dc = new DatabaseConnection(true);
					Insertar frame = new Insertar(dc, null, 2);
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

	public Insertar(DatabaseConnection dc, String usuario, int credenciales) {
		this.dc = dc;
		this.usuario= usuario;
		this.nivelDeCredenciales = credenciales;
		lastQuery="";

		
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
		
		nivelDeCredenciales = credenciales;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		equivalenciaTablas= new Hashtable<String, String>();
		equivalenciaTablas.put("Un cliente nuevo", "Cliente");
		equivalenciaTablas.put("", "");
		equivalenciaTablas.put( "A un cobrador nuevo" , "Cobrador");
		equivalenciaTablas.put("Un Departamento", "Departamento");
		equivalenciaTablas.put("A un supervisor nuevo", "Supervisor");
		equivalenciaTablas.put( "A un vendedor nuevo", "Vendedor");
		equivalenciaTablas.put("Un Usuario nuevo", "Credenciales");
		equivalenciaTablas.put("Telefono", "Telefono");
		equivalenciaTablas.put("Un Pago", "Pago");
		equivalenciaTablas.put("Nuevo contrato","Contrato");
		equivalenciaTablas.put("Un producto nuevo", "TipoDeContrato");
		
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 28));
		comboBox.setBounds(309, 94, 300, 34);
		comboBox.setEditable(false);
		contentPane.add(comboBox);
		
		lblInsertarElementos = new JLabel("Insertar Elementos");
		lblInsertarElementos.setForeground(Color.WHITE);
		lblInsertarElementos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblInsertarElementos.setBounds(61, 24, 261, 34);
		contentPane.add(lblInsertarElementos);
		
		lblInsertarEn = new JLabel("Insertar: ");
		lblInsertarEn.setForeground(Color.WHITE);
		lblInsertarEn.setFont(new Font("Arial", Font.BOLD, 30));
		lblInsertarEn.setBounds(120, 94, 144, 34);
		contentPane.add(lblInsertarEn);
		
		lblId = new JLabel("ID:");
		lblId.setVisible(false);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Arial", Font.BOLD, 30));
		lblId.setBounds(199, 160, 40, 34);
		contentPane.add(lblId);
		
		lblvendocob= new JLabel("¿Vendedor o Cobrador?");
		lblvendocob.setVisible(false);
		lblvendocob.setForeground(Color.WHITE);
		lblvendocob.setFont(new Font("Arial", Font.BOLD, 30));
		lblvendocob.setBounds(49, 160, 400, 34);
		contentPane.add(lblvendocob);
		
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
		
		refreshTablesOptions(comboBox);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(256, 160, 227, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		
		lblIdDelCobrador = new JLabel("IDdelCobrador:");
		lblIdDelCobrador.setVisible(false);
		lblIdDelCobrador.setForeground(Color.WHITE);
		lblIdDelCobrador.setFont(new Font("Arial", Font.BOLD, 30));
		lblIdDelCobrador.setBounds(20, 280, 230, 34);
		contentPane.add(lblIdDelCobrador);
		
		lblColonia = new JLabel("Colonia:");
		lblColonia.setVisible(false);
		lblColonia.setFont(new Font("Arial", Font.BOLD, 30));
		lblColonia.setForeground(Color.WHITE);
		lblColonia.setBounds(115, 325, 150, 34);
		contentPane.add(lblColonia);
		
		lblHorario = new JLabel("Horario:");
		lblHorario.setVisible(false);
		lblHorario.setFont(new Font("Arial", Font.BOLD, 30));
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setBounds(120, 325, 132, 34);
		contentPane.add(lblHorario);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setVisible(false);
		lblFecha.setFont(new Font("Arial", Font.BOLD, 30));
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setBounds(135, 364, 154, 26);
		contentPane.add(lblFecha);
		
		lblCosto = new JLabel("Costo:");
		lblCosto.setVisible(false);
		lblCosto.setForeground(Color.WHITE);
		lblCosto.setFont(new Font("Arial", Font.BOLD, 30));
		lblCosto.setBounds(143, 240, 154, 34);
		contentPane.add(lblCosto);
		
		lblPagoSemanal = new JLabel("Pago Semanal:");
		lblPagoSemanal.setFont(new Font("Arial", Font.BOLD, 30));
		lblPagoSemanal.setForeground(Color.WHITE);
		lblPagoSemanal.setBounds(23, 325, 250, 34);
		lblPagoSemanal.setVisible(false);
		contentPane.add(lblPagoSemanal);
		
		lblComisintotal = new JLabel("ComisiónTotal:");
		lblComisintotal.setVisible(false);
		lblComisintotal.setFont(new Font("Arial", Font.BOLD, 30));
		lblComisintotal.setForeground(Color.WHITE);
		lblComisintotal.setBounds(20, 364, 250, 26);
		contentPane.add(lblComisintotal);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 30));
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(98, 325, 141, 34);
		lblCantidad.setVisible(false);
		contentPane.add(lblCantidad);
		
		lblIdVendedor = new JLabel("IdDelVendedor:");
		lblIdVendedor.setVisible(false);
		lblIdVendedor.setForeground(Color.WHITE);
		lblIdVendedor.setFont(new Font("Arial", Font.BOLD, 30));
		lblIdVendedor.setBounds(13, 280, 250, 34);
		contentPane.add(lblIdVendedor);
		
		lblInversioninicial = new JLabel("InversionInicial:");
		lblInversioninicial.setFont(new Font("Arial", Font.BOLD, 30));
		lblInversioninicial.setForeground(Color.WHITE);
		lblInversioninicial.setBounds(7, 325, 250, 34);
		lblInversioninicial.setVisible(false);
		contentPane.add(lblInversioninicial);
		
		lblNumContrato = new JLabel("Num Contrato:");
		lblNumContrato.setVisible(false);
		lblNumContrato.setForeground(Color.WHITE);
		lblNumContrato.setFont(new Font("Arial", Font.BOLD, 30));
		lblNumContrato.setBounds(27, 240, 254, 34);
		contentPane.add(lblNumContrato);
		
		lblTipoDeContrato = new JLabel("TipoDeCont.:");
		lblTipoDeContrato.setVisible(false);
		lblTipoDeContrato.setForeground(Color.WHITE);
		lblTipoDeContrato.setFont(new Font("Arial", Font.BOLD, 30));
		lblTipoDeContrato.setBounds(50, 200, 300, 34);
		contentPane.add(lblTipoDeContrato);
		
		lblNumerodecontrato = new JLabel("NumDeCont.:");
		lblNumerodecontrato.setVisible(false);
		lblNumerodecontrato.setForeground(Color.WHITE);
		lblNumerodecontrato.setFont(new Font("Arial", Font.BOLD, 30));
		lblNumerodecontrato.setBounds(45, 160, 300, 34);
		contentPane.add(lblNumerodecontrato);
		
		lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setVisible(false);
		lblIdCliente.setForeground(Color.WHITE);
		lblIdCliente.setFont(new Font("Arial", Font.BOLD, 30));
		lblIdCliente.setBounds(93, 240, 154, 34);
		contentPane.add(lblIdCliente);
				
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(255, 280, 230, 34);
		comboBox_1.setVisible(false);
		comboBox_1.setEditable(false);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setEditable(false);
		comboBox_2.setVisible(false);
		comboBox_2.setBounds(255, 240, 230, 34);
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox<String>();
		comboBox_3.setEditable(false);
		comboBox_3.setVisible(false);
		comboBox_3.setBounds(255, 200, 230, 34);
		contentPane.add(comboBox_3);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(68, 200, 200, 26);
		lblContrasea.setVisible(false);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblContrasea);
		
		lblPermisos_1 = new JLabel("Permisos:");
		lblPermisos_1.setBounds(100, 280, 200, 26);
		lblPermisos_1.setVisible(false);
		lblPermisos_1.setForeground(Color.WHITE);
		lblPermisos_1.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblPermisos_1);
		
		lblElTelefonoPertenece1 = new JLabel("El teléfono");
		lblElTelefonoPertenece1.setBounds(13, 260, 250, 26);
		lblElTelefonoPertenece1.setVisible(false);
		lblElTelefonoPertenece1.setForeground(Color.WHITE);
		lblElTelefonoPertenece1.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblElTelefonoPertenece1);
		
		lblElTelefonoPertenece = new JLabel("pertenece a:");
		lblElTelefonoPertenece.setBounds(13, 290, 250, 26);
		lblElTelefonoPertenece.setVisible(false);
		lblElTelefonoPertenece.setForeground(Color.WHITE);
		lblElTelefonoPertenece.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblElTelefonoPertenece);
		
		
		
		
		btnAceptar.addActionListener(this);
		
		comboBox.addItemListener(new ItemListener() {

			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
			          //Eligió tabla
					String elem= (String) comboBox.getSelectedItem();
					String tabla = equivalenciaTablas.get(elem);
					btnAceptar.setVisible(true);
					refreshVisibleElements(tabla);
					refreshIDElements(1, tabla);
					refreshIDElements(2, tabla);
					refreshIDElements(3, tabla);
				
				}
			}
		});
		
		comboBox_1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

			}
		});
		
		comboBox_2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Eligio ID
				}
			}
		});

		comboBox_3.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Eligio ID
						if(((String)comboBox.getSelectedItem()).equals("Telefono")) {
							String tabla = (String) comboBox_3.getSelectedItem();
							refIdTel(tabla);
						}
				}
			}
		});
		
		
	}
	private void refreshTablesOptions(JComboBox<String> cb ) {
		cb.removeAllItems();
		String[][] listaDeTablas =
		{
				{"Un cliente nuevo", "Telefono"},
				{"Telefono", "A un vendedor nuevo","Un Pago","Nuevo contrato","A un cobrador nuevo","Un cliente nuevo"},
				{"A un supervisor nuevo", "Un producto nuevo",  "Un Departamento" , "Un Usuario nuevo"}
				                
		};
		// 0 --> vendedor
		// 1--> supervisor
		// 2--> administrador
		cb.addItem("");
		for(int j=0;j<listaDeTablas[nivelDeCredenciales].length;j++) {
			cb.addItem(listaDeTablas[nivelDeCredenciales][j]);
		}	
	}
	
	private void refreshVisibleElements(String tabla) {
		lblvendocob.setVisible(false);
		lblId.setVisible(false);
		lblApellidos.setVisible(false);
		lblNombre.setVisible(false);
		lblIDdelSup.setVisible(false);
		lblNumero.setVisible(false);
		lblTelefono.setVisible(false);
		lblIDDep.setVisible(false);
		lblLocacion.setVisible(false);
		lblCalle.setVisible(false);
		lblZona.setVisible(false);
		lblIdDelCobrador.setVisible(false);
		lblColonia.setVisible(false);
		lblHorario.setVisible(false);
		lblFecha.setVisible(false);
		lblCosto.setVisible(false);
		lblPagoSemanal.setVisible(false);
		lblIdVendedor.setVisible(false);
		lblInversioninicial.setVisible(false);
		lblNumContrato.setVisible(false);
		lblTipoDeContrato.setVisible(false);
		lblNumerodecontrato.setVisible(false);
		lblIdCliente.setVisible(false);
		lblComisintotal.setVisible(false);
		lblCantidad.setVisible(false);
		textField.setVisible(true);
		textField_1.setVisible(true);
		textField_2.setVisible(true);
		textField_4.setVisible(true);
		textField_3.setVisible(false);
		calle_field.setVisible(false);
		comboBox_1.setVisible(false);
		comboBox_2.setVisible(false);
		comboBox_3.setVisible(false);
		lblPermisos_1.setVisible(false);
		lblContrasea.setVisible(false);		
		lblElTelefonoPertenece.setVisible(false);
		lblElTelefonoPertenece1.setVisible(false);
		
		if(tabla.equals("Cliente")) {
			
			lblId.setVisible(true);
			lblCalle.setVisible(true);
			lblNumero.setVisible(true);
			lblNombre.setVisible(true);
			lblApellidos.setVisible(true);
			lblColonia.setVisible(true);
			textField_3.setVisible(true);
			calle_field.setVisible(true);
			
		}else if(tabla.equals("Vendedor")) {
			
			lblId.setVisible(true);
			lblIDdelSup.setVisible(true);
			lblNombre.setVisible(true);
			lblApellidos.setVisible(true);
			lblHorario.setVisible(true);
			textField_4.setVisible(false);
			textField_3.setVisible(true);
			comboBox_1.setVisible(true);
			
		}else if(tabla.equals("TipoDeContrato")) {
			
			lblNombre.setVisible(true);
			lblId.setVisible(true);
			lblCosto.setVisible(true);
			lblPagoSemanal.setVisible(true);
			lblComisintotal.setVisible(true);
			textField_3.setVisible(true);
			
		}else if(tabla.equals("Pago")) {
			
			lblNumContrato.setVisible(true);
			lblId.setVisible(true);
			lblIdDelCobrador.setVisible(true);
			lblFecha.setVisible(true);
			lblTipoDeContrato.setVisible(true);
			lblCantidad.setVisible(true);
			textField_2.setVisible(false);
			textField_3.setVisible(true);
			textField_1.setVisible(false);
			comboBox_1.setVisible(true);
			comboBox_2.setVisible(true);
			comboBox_3.setVisible(true);
			
		}else if(tabla.equals("Departamento")) {
			
			lblNombre.setVisible(true);
			lblLocacion.setVisible(true);
			lblId.setVisible(true);
			textField_2.setVisible(false);
			textField_4.setVisible(false);
			textField_3.setVisible(true);			
			
			
			
		}else if(tabla.equals("Cobrador")) {
			
			lblNombre.setVisible(true);
			lblZona.setVisible(true);
			lblIDdelSup.setVisible(true);
			lblApellidos.setVisible(true);
			lblId.setVisible(true);
			textField_4.setVisible(false);
			textField_3.setVisible(true);
			comboBox_1.setVisible(true);
			
			
		}else if(tabla.equals("Telefono")) {
			
			lblTelefono.setVisible(true);
			lblId.setVisible(true);
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			comboBox_1.setVisible(true);
			textField.setVisible(false);

			lblId.setVisible(false);
			lblElTelefonoPertenece.setVisible(true);
			lblElTelefonoPertenece1.setVisible(true);
			if(nivelDeCredenciales!=0) {
				comboBox_3.setVisible(true);
				lblvendocob.setVisible(true);
			}

			
		}else if(tabla.equals("Supervisor")) {
			
			lblNombre.setVisible(true);
			lblIDDep.setVisible(true);
			lblTelefono.setVisible(true);
			lblApellidos.setVisible(true);
			lblId.setVisible(true);
			comboBox_1.setVisible(true);
			
		}else if(tabla.equals("Contrato")) {
			
			lblTipoDeContrato.setVisible(true);
			lblFecha.setVisible(true);
			lblIdVendedor.setVisible(true);
			lblInversioninicial.setVisible(true);
			lblNumerodecontrato.setVisible(true);
			lblIdCliente.setVisible(true);
			textField_2.setVisible(false);
			textField_3.setVisible(true);
			textField_1.setVisible(false);
			comboBox_1.setVisible(true);
			comboBox_2.setVisible(true);
			comboBox_3.setVisible(true);
			
		}else if(tabla.equals("Credenciales")) {
			comboBox_1.setVisible(true);
			lblId.setVisible(true);
			lblPermisos_1.setVisible(true);
			lblContrasea.setVisible(true);
			textField_2.setVisible(false);
			textField_4.setVisible(false);
			textField_3.setVisible(false);
			
		}else {
			btnAceptar.setVisible(true);
			textField.setVisible(false);
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			textField_4.setVisible(false);
			textField_3.setVisible(false);

			
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

	
	private String createInsertQuery() {
		
		String tabla =  equivalenciaTablas.get((String) comboBox.getSelectedItem());
		String q;
		if(tabla.equals("Telefono")) {
			 q ="INSERT INTO ";
			if(nivelDeCredenciales==0) {
				q+="Telefonocl";
			}else {
				if(((String)comboBox_3.getSelectedItem()).equals("Vendedor")) {
					q+="Telefonov";					
				}else {
					q+="Telefonoco";
				}
			}
			q+=" VALUES(" +"'"+((String)comboBox_1.getSelectedItem())+"'"+" ,"
					+textField_4.getText()+" "
					+")";
			
		}else {
			q ="INSERT INTO "+tabla+" VALUES(" ;
	
			if(tabla.equals( "Cliente")) {
				
				q+="'"+textField.getText()+"'"+" ,"
				+"'"+textField_1.getText()+"'"+" ,"
				+"'"+textField_2.getText()+"'"+" ,"
				+"'"+calle_field.getText()+"'"+" ,"
				+textField_4.getText()+" ,"
				+"'"+textField_3.getText()+"'"+" "
				+")";
			}else if(tabla.equals(  "Departamento")) {
				
				q+="'"+textField.getText()+"'"+" ,"
				+"'"+textField_1.getText()+"'"+" ,"
				+"'"+textField_3.getText()+"'"+" "
				+")";
				
			}else if(tabla.equals(  "Supervisor")) {
	
				q+="'"+textField.getText()+"'"+" ,"
				+"'"+textField_1.getText()+"'"+" ,"
				+"'"+textField_2.getText()+"'"+" ,"
				+textField_4.getText()+" ,"
				+"'"+(String)comboBox_1.getSelectedItem()+"'"+" "
				+")";		
			}else if(tabla.equals( "Vendedor")) {
	
				q+="'"+textField.getText()+"'"+" ,"
				+"'"+(String)comboBox_1.getSelectedItem()+"'"+" ,"
				+"'"+textField_1.getText()+"'"+" ,"
				+"'"+textField_2.getText()+"'"+" ,"
				+"'"+textField_3.getText()+"'"+" "
				+")";
			}else if(tabla.equals(  "TipoDeContrato")) {
	
				q+="'"+textField.getText()+"'"+" ,"
					+"'"+textField_1.getText()+"'"+" ,"
				+textField_2.getText()+" ,"
				+textField_3.getText()+" ,"
				+textField_4.getText()+" "
				+")";
			}else if(tabla.equals(  "Contrato")) {
	
				q+="'"+(String)comboBox_3.getSelectedItem()+"'"+" ,"
						+"'"+textField.getText()+"'"+" ,"
						+"'"+(String)comboBox_2.getSelectedItem()+"'"+" ,"
						+"'"+(String)comboBox_1.getSelectedItem()+"'"+" ,"
						+"'"+textField_4.getText()+"'"+" ,"

						+textField_3.getText()+" ,"
						+" 0 "
						+")";
	
			}else if(tabla.equals( "Pago")) {
	 
				q+="'"+textField.getText()+"'"+" ,"
						+"'"+(String)comboBox_3.getSelectedItem()+"'"+" ,"
						+"'"+(String)comboBox_2.getSelectedItem()+"'"+" ,"
						+textField_3.getText()+" ,"
						+"'"+textField_4.getText()+"'"+" ,"
						+"'"+(String)comboBox_1.getSelectedItem()+"'"+" "
						+")";
			}else if(tabla.equals( "TelefonoCo")||tabla.equals( "TelefonoCl") ||tabla.equals( "TelefonoV")) {
	
				q+="'"+textField.getText()+"'"+" ,"
				+textField_4.getText()+" "
				+")";
				;
			}else if(tabla.equals( "Cobrador")) {
				
				q+="'"+textField.getText()+"'"+" ,"
					+"'"+textField_1.getText()+"'"+" ,"
					+"'"+textField_2.getText()+"'"+" ,"
					+"'"+textField_3.getText()+"'"+" ,"
					+"'"+(String)comboBox_1.getSelectedItem()+"'"+" "
					+")";
			}else {
				// TODO USUARIOS GET QUERY nivel de credenciales
				int permisos;
				if(((String)comboBox_1.getSelectedItem()).equals("Administrador")) {
					permisos=2;
				}else if(((String)comboBox_1.getSelectedItem()).equals("Supervisor")) {
					permisos=1;
				}else {
					permisos=0;
				}
				q+="'"+textField.getText()+"'"+" ,"
						+"'"+textField_1.getText()+"'"+" ,"
						+permisos+" "
						+")";
			}

		}
		return q;
	}

	private void close() {
		dc.endConection();
		System.exit(0);
	}
	private void refIdTel(String tabla) {
		JComboBox<String> cb;
		cb= comboBox_1;
		String q, selectfromtable;
		if(tabla.equals("Vendedor") ) {
		// ref to vend
		selectfromtable="Vendedor";
		}else {
			selectfromtable="Cobrador";
		}
		cb.removeAllItems();
		cb.addItem("");
		if(!tabla.equals("")) {
			q=createIDSelectQ(selectfromtable);
			LinkedList<String> options = dc.rowSelectQuery(q);
			for(String id : options) {
				cb.addItem(id);
			}
		}	
	}
	private void refreshIDElements(int i, String tabla) {
		JComboBox<String> cb;
		boolean specialcase=false;
		String q, selectfromtable;
		selectfromtable="";
		if(i==1) {
			cb = comboBox_1;
			cb.removeAllItems();
			
			if(tabla.equals("Vendedor") || tabla.equals("Cobrador") ) {
				// ref to Sup
				selectfromtable="Supervisor";
				
			}else if(tabla.equals("Telefono") ) {
				// ref to client
				String getfrom  = (String)comboBox_3.getSelectedItem();
				if(getfrom!=null) {
					if(nivelDeCredenciales==0) {
						selectfromtable = "Cliente";
					}else {
						
						if(getfrom.equals("Vendedor")) {
							selectfromtable="Vendedor";
						
						}else {
							selectfromtable="Cobrador";
						}
					}
				}
				
			}else if(tabla.equals("Contrato") ) {
				// ref to vend
				selectfromtable="Vendedor";
				
			}else if(tabla.equals("Supervisor") ) {
				// ref to dep
				selectfromtable="Departamento";
				
			}else if(tabla.equals("Credenciales")) {
				selectfromtable="Credenciales";
				specialcase=true;
			}else {
				selectfromtable="Cobrador";
			}

		}else if(i==2) {
			cb = comboBox_2;
			cb.removeAllItems();
			if(tabla.equals("Contrato") ) {
				selectfromtable="Cliente";
			}else{
				selectfromtable="Contrato";	
			}
		}else {
			cb = comboBox_3;
			cb.removeAllItems();
			if(tabla.equals("Telefono")) {
				cb.addItem("");
				cb.addItem("Cobrador");
				cb.addItem("Vendedor");
			}else {
				selectfromtable="TipoDeContrato";

			}
		}
		
		if(specialcase) {
			cb.removeAllItems();
			cb.addItem("Administrador"); 
			cb.addItem("Supervisor"); 
			cb.addItem("Vendedor"); 
		}else {
			if(!(tabla.equals("Telefono"))) {
				cb.addItem("");
				q=createIDSelectQ(selectfromtable);
				LinkedList<String> options = dc.rowSelectQuery(q);
				for(String id : options) {
					cb.addItem(id);
				}
			}
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAceptar) {

			String tabla=equivalenciaTablas.get((String)comboBox.getSelectedItem());
			if(tabla.equals("Telefono")) {
				
				if(!(comboBox_1.getSelectedItem()).equals("")) {
					if(isValid(textField_4.getText())) {
						String  q = createInsertQuery();
						if(!lastQuery.equals(q)) {
							lastQuery=q;
							if(dc.getModoPrueba()) {
								lblresult.setText(q);
								lblresult.setVisible(true);
							}else {
								boolean resultado = dc.ResultInsertQuery(q);
								lblresult.setText((resultado?"Se insertó una fila exitosamente.":"No se pudo insertar la fila."));

								lblresult.setVisible(true);
								disable( btnAceptar, 1500);
							}
						}
					}else {
						lblresult.setText(("Inserte valores numéricos en la sección de teléfono."));
						lblresult.setVisible(true);
					}
				}else {
					lblresult.setText(("No debe dejar el campo de ID vacío."));
					lblresult.setVisible(true);
				}
				
				
			}else {
				if(!textField.getText().equals("")) {
					//System.out.println(tabla);
					if(tabla.equals("Cliente")) {
						String text= textField_4.getText();
						//System.out.println(text);
						if(isValid(text)) {
							String q = createInsertQuery();
							if(!lastQuery.equals(q)) {
								lastQuery=q;
								if(dc.getModoPrueba()) {
									lblresult.setText(q);
									lblresult.setVisible(true);
								}else {
									boolean resultado = dc.ResultInsertQuery(q);
									lblresult.setText((resultado?"Se insertó una fila exitosamente.":"No se pudo insertar la fila."));
									lblresult.setVisible(true);
								}
							}
						}else {
							lblresult.setText("Inserte un valor numérico en el campo: Número de calle.");
							lblresult.setVisible(true);
						}
					}else if(tabla.equals("Pago")||tabla.equals("Contrato")) {
						String text= textField_3.getText();
						System.out.println(text);
						if(isValid(text)) {
							String q = createInsertQuery();
							System.out.println(q);
							if(dc.getModoPrueba()) {
								lblresult.setText(q);
								lblresult.setVisible(true);
							}else {
								boolean resultado = dc.ResultInsertQuery(q);
								lblresult.setText((resultado?"Se insertó una fila exitosamente.":"No se pudo insertar la fila."));
								lblresult.setVisible(true);
							}
						}else {
							lblresult.setText("Inserte un valor numérico en el campo: "+(tabla.equals("Pago")?"Cantidad.":"Inversión Inicial."));
							lblresult.setVisible(true);
						}
					
					}else if(tabla.equals("Usuario")){
						String credenciales = (String) comboBox_1.getSelectedItem();
						int indx;
						if(credenciales.equals("Vendedor")) {
							indx=0;
						}else if(credenciales.equals("Supervisor")){
							indx=1;
						}else {
							indx=2;
						}
						String q="INSERT INTO CREDENCIALES VALUES( '"+textField.getText()+"' , "+textField_1.getText()+" , "+indx +" )";
						if(dc.getModoPrueba()) {
							lblresult.setText(q);
							lblresult.setVisible(true);
						}else {
							boolean resultado = dc.ResultInsertQuery(q);
							lblresult.setText((resultado?"Se insertó una fila exitosamente.":"No se pudo insertar la fila."));
							lblresult.setVisible(true);
						}
					}else {

						String q = createInsertQuery();
						System.out.println(q);
						if(dc.getModoPrueba()) {
							lblresult.setText(q);
							lblresult.setVisible(true);
						}else {
							boolean resultado = dc.ResultInsertQuery(q);
							lblresult.setText((resultado?"Se insertó una fila exitosamente.":"No se pudo insertar la fila."));
							lblresult.setVisible(true);
						}
					}
				}else {
					lblresult.setText(("No debe dejar el campo de ID vacío."));
					lblresult.setVisible(true);
				}
			}	
		}
		else {
			SeleccionarAccion s = new SeleccionarAccion(dc, usuario, nivelDeCredenciales);
			s.setVisible(true);
			this.dispose();
		}
	}	
	
	private static void disable(final AbstractButton b, final long ms) {
	    b.setEnabled(false);
	    new SwingWorker<Object, Object>() {
	        @Override protected Object doInBackground() throws Exception {
	            Thread.sleep(ms);
	            return null;
	        }
	        @Override protected void done() {
	            b.setEnabled(true);
	        }
	    }.execute();
	}
}
