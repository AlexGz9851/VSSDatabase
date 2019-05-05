import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Select extends JFrame implements ActionListener{

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
	
	private JLabel lblUsuario;
	private JLabel lblPermisos;
	private JLabel lblInsertarElementos ;
	private JLabel lblInsertarEn;

	private JLabel lblId;
	private JLabel lblApellidos;
	private JLabel lblNombre;
	
	private JLabel lblId2;
	private JLabel lblApellidos2;
	private JLabel lblNombre2;
	private JLabel lblCondicin ;
	private JLabel lblDias;
	
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3;


	private JLabel lblNumero;
	private int nivelDeCredenciales;
	private String usuario;
	
	JLabel lblVendedor ;
	JLabel lblCobrador;
	private JLabel lblDelTipoDe;
	private JLabel lblZona;
	private JLabel lblCantidad;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnection dc = new DatabaseConnection(true);
					Select frame = new Select(dc, "", 1);
					
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

	public Select(DatabaseConnection dc, String user,int credenciales) {
		this.dc = dc;
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
		
		usuario =user.strip(); 
		nivelDeCredenciales = credenciales;
		
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
		
		lblInsertarElementos = new JLabel("Consultas de datos");
		lblInsertarElementos.setForeground(Color.WHITE);
		lblInsertarElementos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblInsertarElementos.setBounds(61, 24, 318, 34);
		contentPane.add(lblInsertarElementos);
		
		lblInsertarEn = new JLabel("Seleccionar: ");
		lblInsertarEn.setForeground(Color.WHITE);
		lblInsertarEn.setFont(new Font("Arial", Font.BOLD, 30));
		lblInsertarEn.setBounds(76, 94, 188, 34);
		contentPane.add(lblInsertarEn);
		
		lblId = new JLabel("ID:");
		lblId.setVisible(false);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Arial", Font.BOLD, 30));
		lblId.setBounds(126, 211, 40, 34);
		contentPane.add(lblId);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setVisible(false);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 30));
		lblNombre.setBounds(42, 211, 124, 34);
		contentPane.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setVisible(false);
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 30));
		lblApellidos.setBounds(22, 256, 154, 34);
		contentPane.add(lblApellidos);
		
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
		
		lblId2 = new JLabel("ID:");
		lblId2.setVisible(false);
		lblId2.setFont(new Font("Arial", Font.BOLD, 30));
		lblId2.setForeground(Color.WHITE);
		lblId2.setBounds(125, 301, 51, 34);
		lblId2.setVisible(false);
		contentPane.add(lblId2);
		
		lblNombre2 = new JLabel("Nombre:");
		lblNombre2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNombre2.setForeground(Color.WHITE);
		lblNombre2.setBounds(42, 301, 141, 34);
		lblNombre2.setVisible(false);
		contentPane.add(lblNombre2);
		
		lblApellidos2 = new JLabel("Apellidos:");
		lblApellidos2.setVisible(false);
		lblApellidos2.setFont(new Font("Arial", Font.BOLD, 30));
		lblApellidos2.setForeground(Color.WHITE);
		lblApellidos2.setBounds(22, 346, 154, 26);
		contentPane.add(lblApellidos2);
		
		refreshTablesOptions(comboBox, nivelDeCredenciales);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(186, 221, 336, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setVisible(false);
		textField_1.setBounds(186, 266, 336, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		textField_2.setBounds(186, 305, 336, 26);
		contentPane.add(textField_2);
		
		
		textField_3 = new JTextField();
		textField_3.setVisible(false);
		textField_3.setColumns(10);
		textField_3.setBounds(186, 346, 336, 26);
		contentPane.add(textField_3);
		

		
		lblNumero = new JLabel("Número:");
		lblNumero.setVisible(false);
		lblNumero.setFont(new Font("Arial", Font.BOLD, 30));
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setBounds(42, 346, 131, 26);
		contentPane.add(lblNumero);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 24));
		comboBox_1.setEditable(false);
		comboBox_1.setVisible(false);
		comboBox_1.setBounds(186, 153, 538, 34);
		contentPane.add(comboBox_1);
		
		lblCondicin = new JLabel("Condici\u00F3n: ");
		lblCondicin.setForeground(Color.WHITE);
		lblCondicin.setFont(new Font("Arial", Font.BOLD, 30));
		lblCondicin.setBounds(22, 153, 163, 34);
		contentPane.add(lblCondicin);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(186, 221, 108, 26);
		contentPane.add(comboBox_2);
		comboBox_2.setVisible(false);
		
		comboBox_3= new JComboBox<String>();
		comboBox_3.setBounds(186, 301, 108, 26);
		comboBox_3.setVisible(false);
		contentPane.add(comboBox_3);
		
		lblDias = new JLabel("Dias:");
		lblDias.setVisible(false);
		lblDias.setForeground(Color.WHITE);
		lblDias.setFont(new Font("Arial", Font.BOLD, 30));
		lblDias.setBounds(86, 216, 80, 34);
		contentPane.add(lblDias);
		
		lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(545, 211, 169, 34);
		lblVendedor.setVisible(false);
		lblVendedor.setForeground(Color.WHITE);
		lblVendedor.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblVendedor);
		
		lblCobrador = new JLabel("Cobrador");
		lblCobrador.setBounds(545, 301, 147, 26);
		lblCobrador.setVisible(false);
		lblCobrador.setForeground(Color.WHITE);
		lblCobrador.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblCobrador);
		
		lblDelTipoDe = new JLabel("Del tipo de contrato");
		lblDelTipoDe.setBounds(23, 256, 300, 26);
		lblDelTipoDe.setVisible(false);
		lblDelTipoDe.setForeground(Color.WHITE);
		lblDelTipoDe.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblDelTipoDe);
		
		lblZona = new JLabel("Zona:");
		lblZona.setVisible(false);
		lblZona.setForeground(Color.WHITE);
		lblZona.setFont(new Font("Arial", Font.BOLD, 30));
		lblZona.setBounds(86, 211,154, 26);
		contentPane.add(lblZona);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(28, 211, 154, 26);
		lblCantidad.setVisible(false);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblCantidad);


		
		btnAceptar.addActionListener(this);
		
		comboBox.addItemListener(new ItemListener() {

			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
			          //Eligió tabla
					
					String entidad = (String) comboBox.getSelectedItem();
					//refreshVisibleElements(nivelDeCredenciales, entidad,  "");
					comboBox_1.setVisible(!entidad.equals(""));
					refreshSelectQueryOptions(comboBox_1, nivelDeCredenciales, entidad);
				}
			}
		});
		
		comboBox_1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
				// eligió opción
					String entidad = (String) comboBox.getSelectedItem();
					String opcion = (String) comboBox_1.getSelectedItem();
					btnAceptar.setVisible(!opcion.equals("") && !entidad.equals(""));
					refreshVisibleElements(nivelDeCredenciales, entidad,  opcion);
					
				}
				
				
			}
		});
		
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
			String entidad = (String) comboBox.getSelectedItem();
			String opcion = (String) comboBox_1.getSelectedItem();
			if(!entidad.equals("") && !opcion.equals("")) {
				String q = getQuery(entidad, opcion, nivelDeCredenciales);
				if(dc.getModoPrueba()) {
					if(opcion.equals("Del periodo:") || opcion.equals("Clientes con N cantidad de pagos")) {
						if(isValid(textField.getText())) {
							lblresult.setText(q);
							lblresult.setVisible(true);
							}
						else {
							lblresult.setText("Inserte valores numéricos en el campo.");
							lblresult.setVisible(true);
						}
					}else {
						lblresult.setText(q);
						lblresult.setVisible(true);
					}

				}else {
					if(opcion.equals("Del periodo:") || opcion.equals("Clientes con N cantidad de pagos")) {
						if(isValid(textField.getText())) {
							System.out.println(q);
							DatabaseConnection.Tabla result=dc.resultSelectQuery(q);
							
							lblresult.setText(result.exito?"Exito en la consulta.":"No se pudo concretar la consulta.");
							lblresult.setVisible(true);
							if(result.exito) {
								TablaDeResultados tr = new TablaDeResultados(dc, result);
								tr.setVisible(true);
							}
						}else {
							lblresult.setText("Inserte valores numéricos en el campo.");
							lblresult.setVisible(true);
						}
						
					}else {
						System.out.println(q);
						DatabaseConnection.Tabla result=dc.resultSelectQuery(q);
						
						lblresult.setText(result.exito?"Exito en la consulta.":"No se pudo concretar la consulta.");
						lblresult.setVisible(true);
						if(result.exito) {
							TablaDeResultados tr = new TablaDeResultados(dc, result);
							tr.setVisible(true);
						}
					}

					
					
				}
			}else {
				System.out.println("Inalcanzable");
			}
				
		}
		else {
			SeleccionarAccion s = new SeleccionarAccion(dc, usuario, nivelDeCredenciales);
			s.setVisible(true);
			this.dispose();
		}
	}
	
	private void refreshTablesOptions(JComboBox<String> cb , int nivelDeCredenciales) {
		cb.removeAllItems();
		String[][] listaDeTablas =
		{
				{"Cliente(s)", "Contrato(s)"},
				{"Ganancias", "Vendedor(es)","Cliente(s)","Cobrador(es)"},
				{"Supervisor(es)", "Vendedor(es)", "Cliente(s)", "Contrato(s)", "Tipo de contrato", "Ganancias" }
				                
		};
		// 0 --> vendedor
		// 1 --> supervisor
		// 2--> administrador
		cb.addItem("");
		for(int j=0;j<listaDeTablas[nivelDeCredenciales].length;j++) {
				cb.addItem(listaDeTablas[nivelDeCredenciales][j]);
		}		
	}
	
	private void refreshSelectQueryOptions(JComboBox<String> cb, int nivelDeCredenciales, String entidad) {
		// 0 --> vendedor
		// 1 --> supervisor
		// 2--> administrador
		cb.removeAllItems();
		cb.addItem("");
		if(nivelDeCredenciales==2) {
			if(entidad.equals("Supervisor(es)")){
				cb.addItem("De cierto departamento");
			}else if(entidad.equals("Contrato(s)")){
				cb.addItem("Contratos del tipo:");
			}else if(entidad.equals("Vendedor(es)")){
				cb.addItem("De cierto departamento");
				cb.addItem("De cierto supervisor");
			}else if(entidad.equals("Cliente(s)")){
				cb.addItem("Con mismo cobrador y vendedor");
			}else if(entidad.equals("Tipo de contrato")){
				cb.addItem("Que se han vendido más");
				cb.addItem("Qué genera más tipos de pagos");
				//TODO GANANCIAS
//			}else if( entidad.equals("Ganancias")){
//				cb.addItem("Del mes");
//				cb.addItem("Del periodo:");
//				cb.addItem("Ganancias por departamento por mes");
			}else {
				
			}

		}else if(nivelDeCredenciales==1) {
			if(entidad.equals("Cobrador(es)")) {
				cb.addItem("Cobros realizados en la semana");
				cb.addItem("Lista de mis cobradores");
				cb.addItem("Telefonos del cobrador");
				cb.addItem("Información de cierto cobrador");
			}else if(entidad.equals("Vendedor(es)")){
				cb.addItem("Quién ha realizado más contratos en el mes");
				cb.addItem("Quién ha vendido más contratos de cierto tipo");
				cb.addItem("Teléfonos del vendedor"); 
				cb.addItem("Información de cierto vendedor");
				cb.addItem("Lista de mis vendedores");
			}else if(entidad.equals("Cliente(s)")){
				cb.addItem("Clientes de cierto vendedor");
			}else if( entidad.equals("Ganancias")){
				cb.addItem("Ganancias de cada vendedor este mes");
			}else {
				
			}
		}else {
			if(entidad.equals("Cliente(s)")) {
				cb.addItem("Datos generales");
				cb.addItem("Lista de mis clientes");
				cb.addItem("Teléfonos de cierto cliente");
				cb.addItem("Adeudos de todos mis clientes");
				cb.addItem("Adeudos de cierto cliente");
				cb.addItem("Clientes con al menos N cantidad de pagos");
				cb.addItem("Con cierto tipo de contrato");
				cb.addItem("Por zona");
				cb.addItem("Morosos");
				
			}else if(entidad.equals("Contrato(s)")){

				cb.addItem("Contratos de los cuales aún no me pagan comisión");
			}else {
				
			}
		}
		
	}
	
	private String getQuery(String entidad, String opcion, int nivelDeCredenciales) {
		String q;
		q="";
		if(nivelDeCredenciales==2) {
			if(entidad.equals("Supervisor(es)")){
				if(opcion.equals("De cierto departamento")){
					q= "select supervisorID, supervisor.nombre, apellidos from  departamento   "
							+ "  join supervisor "
							+ "on departamento.departamentoid = "
							+ " supervisor.departamentoid "
							+"where departamento.nombre ='" +textField.getText()+"'";// 111111111111
				}
			}else if(entidad.equals("Contrato(s)")){
				if(opcion.equals(	"Contratos del tipo:")){
					//---Dado tipo de contrato---
					q= "select * from contrato "
					+"where tipodeContratoID = (select tipodecontratoid from tipodecontrato "
					+"where nombre= '"+  textField.getText()+"')";//1111111111111
					;
				}
			}else if(entidad.equals("Vendedor(es)")){
				if(opcion.equals("De cierto departamento")){

					//---Quiero todos los vendedores de cierto departamento:

					q="select idVendedor, vendedor.nombre, vendedor.apellidos, horariosDeOficina "
					+"from vendedor join ( "
					    +"select * " 
					    +"from supervisor   join departamento "  
					    +"on departamento.departamentoid = supervisor.departamentoid "
					    +"where departamento.nombre = '"+ textField.getText() +"' "//111111111111111
					    +") on idSupervisor = supervisorID";
				}
				else if(opcion.equals("De cierto supervisor")){
					//---Quiero los vendedores de cierto supervisor:

					q="select idVendedor, vendedor.nombre, vendedor.apellidos, horariosDeOficina "
					+"from vendedor join supervisor on idSupervisor = supervisorID "
					+"where supervisor.nombre = '"+ textField.getText()  +"' and supervisor.apellidos = '"+textField_1.getText() +"'";////////21212121112121
				}
			}else if(entidad.equals("Cliente(s)")){
				if(opcion.equals("Con mismo cobrador y vendedor")){
					//---Quiero los clientes con mismo cobrador y vendedor:
					//--- Dado el cobrador nombre, apellido y vendedor nombre, apellido ---

					q="select distinct clienteid, nombre, apellidos, calle, numero, colonia "
					+"from cliente join "+
						"(select * from "+
							"(select tipoDeContratoID, numContrato, idCliente "+
							"from Contrato "+
							"where idVendedor =   ( select idVendedor from vendedor "+
								"where nombre = '"+textField.getText()+ "' and apellidos = '"+textField_1.getText()+"' ))  "+//////71212212121212
						"natural join "+
							"(select tipoDeContratoID  , numContrato "+
							"from pago "+
							"where idCobrador =  "+
								"(select idCobrador from cobrador "+
								"where nombre = '"+textField_2.getText()+"' and apellidos = '"+textField_3.getText()+ "' ))"//34343434343343
						+")"
					+"on clienteid = idCliente";
				}else { // TODO GANANCIAS
					
				}
			}else if(entidad.equals("Tipo de contrato")){
				if(opcion.equals("Que se han vendido más")){

					q="select *"
					+" from (select  tipoDecontratoid, nombre, count(numContrato) as numeroDeVentas"
					+" from contrato natural join tipodecontrato"
					+" group by tipodecontratoid, nombre"
					+" order by numerodeventas desc)"
					+" where rownum <= 3";
				}
				else if(opcion.equals("Qué genera más( tipos de pagos")){
					//---Quiero saber el contrato que genera más ganancias en pagos:

					q="select *"
					+" from (select  tipoDecontratoid, nombre, sum(cantidad) as ganancias"
				+		" from pago natural join tipodecontrato"
				+		" group by tipodecontratoid, nombre"
				+		" order by ganancias desc)"
				+	" where rownum <= 1";
				}
			}else if( entidad.equals("Ganancias")){
				if(opcion.equals("Del mes")){
					//---Quiero todas las ganancias en pagos del último mes:

					q="select sum(cantidad)  as gananciasMensuales"
					+" from pago "
					+" where fecha > sysdate - 30";

				}
				else if(opcion.equals("Del periodo:")){
					//---Quiero todas las ganancias en pagos DE LOS ULTIMOS N DIAS.

						q="select sum(cantidad)  as gananciasEnElPeriodo "
						+"from pago "
						+"where fecha > sysdate - "+textField.getText(); //111111111

				}
				else if(opcion.equals("Suma de comisiones iniciales, por departamento en el mes")){
					q="select Departamento.nombre , sum(inversionInicial) as ganancias"
					+" from (contrato natural join vendedor) join (supervisor   join departamento on supervisor.departamentoid = departamento.departamentoid)" 
					+" on idSupervisor = supervisorID"
					+" group by Departamento.nombre"
					+" ORDER BY ganancias DESC";
					
				}
			}else {
				
			}

		}else if(nivelDeCredenciales==1) {
			if(entidad.equals("Cobrador(es)")) {
				if(opcion.equals("Cobros realizados en la semana")){
					//---Quiero saber cuantos  y cuales cobros ha hecho el cobrador X en la semana:

						q="select   * from pago "
						+"where fecha > sysdate - 7 and idCobrador= "
						+	"(select idCobrador from cobrador"
						+	" where nombre ='"+ textField.getText() +"' and apellidos = '"+ textField_1.getText() + "' and supervisor ='"+usuario+"')"; //11222122121
				}

				else if(opcion.equals("Lista de mis cobradores")){
					q="select * from cobrador where supervisor='"+usuario +"'";
				}
				else if(opcion.equals("Telefonos del cobrador")){
					//---Quiero los teléfonos de cierto cobrador:

					q="select telefono from telefonoCo "
					+"where idCobrador = ("
					+" select idCobrador"
					+" from cobrador "
					+" where nombre='"+textField.getText()+"' and apellidos = '"+textField_1.getText()+"')"; // 1212121212121
				}
				else if(opcion.equals("Información de cierto cobrador")){
					q="select * from cobrador "
							+"where idCobrador = ("
							+" select idCobrador"
							+" from cobrador "
							+" where nombre='"+textField.getText()+"' and apellidos = '"+textField_1.getText()+"' and supervisor ='"+usuario+ "')"; // 1212121212121
					
				}
			}else if(entidad.equals("Vendedor(es)")){
				if(opcion.equals("Quién ha realizado más contratos en el mes")){
					//---Quien ha vendido mas (realizado más contratos nuevos) ( en el mes)

					q="select idvendedor, nombre, apellidos, ganancia"
					+" from vendedor natural join ("
					+" select idvendedor, sum(inversioninicial) as ganancia"
					+ " from contrato"
					+    " where fechaalta > sysdate - 30"
					+    " group by idVendedor"
					+    " order by ganancia desc"
					    +")"
					    +"where rownum <= 1";
				}
				else if(opcion.equals("Quién ha vendido más contratos de cierto tipo")){
					//---Quiero saber quien(quienes en caso de empate) de mis vendedores ha vendido mas (nuevos contratos) de cierto tipo:

						q="select idvendedor , count(tipodecontratoid) as ventas"
						+"from contrato"
						+"where tipodecontratoid =" 
						+	"("
						+	"select tipodecontratoid "
						+	"from tipodecontrato "
						+	"where nombre='BASICO' )"
					+	"group by idvendedor"
					+	"having count(*) = (select *" 
					+	"from ("
					+	    "select  count(tipodecontratoid) as ventas"
					+	            "from contrato"
					+	            "where tipodecontratoid =" 
					+	            "("
					+	            "select tipodecontratoid "
					+	            "from tipodecontrato "
					+	            "where nombre='"+textField.getText()+"' )"//1111111
					+	            "group by idvendedor"
					+	            "order by ventas desc"
					+	        ")"
					+	"where rownum=1)";
				}
				else if(opcion.equals("Teléfonos del vendedor")){
					//---Quiero los teléfonos de cierto vendedor:

					q=" select telefono from telefonov"
					+" where idVendedor = ("
					+"			select idVendedor" 
					+"			from vendedor "
					+"			where nombre='"+textField.getText()+"' and apellidos = '"+textField_1.getText()+"')"; // 12121221212
				}
				else if(opcion.equals("Información de cierto vendedor")){
					q="select * from vendedor where nombre='"+textField.getText()+"' and apellidos = '"+textField_1.getText()+"' and idsupervisor='"+usuario +"'";
				}
				else if(opcion.equals("Lista de mis vendedores")){
					q="select * from vendedor where idsupervisor='"+usuario +"'";
				}
			}else if(entidad.equals("Cliente(s)")){
				if(opcion.equals("Clientes de cierto vendedor")){
					//---Quiero los clientes de cierto vendedor:

						q=" Select distinct clienteid, cliente.nombre, cliente.apellidos"
						+" From contrato join cliente on idcliente = clienteid"
						+" Where idvendedor =  ("
						+"			select idVendedor" 
						+"			from vendedor "
						+"			where nombre='"+textField.getText()+"' and apellidos = '"+textField_1.getText()+"')";//2112122121212
				}
			}else if( entidad.equals("Ganancias")){
				if(opcion.equals("Ganancias de cada vendedor este mes")){
					//---Quiero las ganancias de todos los vendedores a mi cargo

					q="select idvendedor, nombre, apellidos, gananciastotales "
					+"from vendedor natural join "
					+"(select idvendedor, sum(ganancia) as gananciastotales "
					+"from "
						+"(select idvendedor, inversioninicial as ganancia "
						+"from contrato "
						+"where fechaalta > sysdate - 30 "
						+"union "
						+"select idvendedor, cantidad as ganancia "
						+"from pago natural join contrato "
						+"where fecha > sysdate - 30) "
					+"group by idvendedor) "
					+"where idVendedor in (select idvendedor from supervisor "
					+" where idsupervisor='"+usuario +"')";//0000000000000



				}
			}else {
				
			}
		}else {
			//and supervisor ='"+usuario+
			if(entidad.equals("Cliente(s)")) {
				if(opcion.equals("Datos generales")){
					//---Quiero consultar los datos de cierto cliente:

						q="Select * from cliente  "
						+"Where nombre = '"+textField.getText()+ "' and apellidos = '" +textField_1.getText()+"'";//12212121221
						
				}
				else if(opcion.equals("Lista de mis clientes")){

					//---Quiero consultar todos mis clientes:

					q="Select DISTINCT clienteid, cliente.nombre, cliente.apellidos "
					+"From contrato join cliente on idcliente = clienteid "
					+"Where idvendedor =  '"+usuario+"'";/////1111111111111
				}
				else if(opcion.equals("Teléfonos de cierto cliente")){
					//---Quiero los teléfonos de cierto cliente: 
						
						q="select telefono from telefonocl "
						+"where clienteID = (select clienteID from cliente "
						+" where nombre = '"+textField.getText()+"' and apellidos = '"+textField_1.getText()+"' )"	;////122121212212121
				}
				else if(opcion.equals("Adeudos de todos mis clientes")){
					//---Quiero ver los adeudos de mis clientes
					q="SELECT clienteid, nombre, apellidos , sum(deuda)"
					+" from ("
					+"    select clienteid, cliente.nombre, cliente.apellidos, costo - inversioninicial - pagos as deuda"
					+"    from cliente join (contrato natural join tipodecontrato) natural join (select tipodecontratoid, numcontrato, sum(cantidad) as pagos"
					+"        from pago"
					+"        group by tipodecontratoid, numcontrato)"
					+"    on clienteid = idcliente"
					+"    where idVendedor ='"+usuario+"'"//00000000000000
					+"        )"
					+" group by clienteid, nombre, apellidos";
				}
				else if(opcion.equals("Adeudos de cierto cliente")){
					//TODO
				}
				else if(opcion.equals("Clientes con al menos N cantidad de pagos")){
					//--- Quiero los clientes que llevan mas de N pagos
					q =" SELECT * "
					+"FROM CLIENTE natural join (SELECT IDCLIENTE as clienteid "
					+"		FROM CONTRATO NATURAL JOIN PAGO "
					+"       group by idcliente "
					+"		HAVING COUNT(idpago) > "+textField.getText()//Q1111111111111111111111111
					+		" )";
				}
				else if(opcion.equals("Con cierto tipo de contrato")){
					//---Quiero los clientes que me pertenezcan y posean cierto tipo de contrato:

						q="select distinct * "
						+" from cliente join ("
						+"    select idcliente"
						+"            from contrato natural join tipodecontrato"
						+"            where idVendedor = '"+usuario+"'"//00000000000
						+"            and tipodecontrato.nombre ='"+textField.getText()+"') "//11111111111111111
						+"    on cliente.clienteid = idcliente";
				}
				else if(opcion.equals("Por zona")){
					//---Quiero mis clientes de cierta zona con su domicilio:

						q="select distinct * " 
						+"from cliente join "
						+"	(Select idCliente "
						+"		from Contrato natural join pago natural join cobrador "
						+"		where cobrador.zona='"+textField.getText()+"' and idVendedor = '"+usuario+"') "//12121212121212122121212
						+"    on cliente.clienteid = idcliente ";
				}
				else if(opcion.equals("Morosos")){
					//---Quiero  a mis clientes morosos


					q="select clienteid, cliente.nombre, cliente.apellidos, calle, numero, colonia "
					+"from cliente join "
					+  " (select distinct idcliente, idvendedor"
					+   " from contrato"
					+    " minus"
					+    " select distinct idcliente, idVendedor"
					+      "  from contrato natural join ("
					+       "     select   * from pago"
					+		" where fecha > sysdate - 7"
					+        " )"
					+    " )"
					+    " on cliente.clienteid = idcliente"
					+    " where idvendedor = '"+usuario+"'";

				}
				
			}else if(entidad.equals("Contrato(s)")){

				if(opcion.equals("Contratos de los cuales aún no me pagan comisión")){
					/*---Quiero conocer de que contratos ya me deberían haber pagado comisión
					La comisión de los vendedores se paga cuando la suma de pagos e inversión inicial  de cierto contrato supera 
					el monto a pagar de comisión, más 100 pesos extras ( por  gastos de papelería). 
					Con este query, los vendedores sabrán automaticamente de cuales contratos la empresa les debe la comisión.
					Anteriormente, debido a la gran redundancia de datos, los vendedores tenían un dificil control de lo que les deberían pagar, por lo que la empresa tomaba la libertad de retrasarles los pagos.
					*/
					
					//TODO
					
				}
			}else {
				
			}
		}
		return q;
	}
	
	private void refreshVisibleElements(int nivelDeCredenciales,String entidad, String opcion) {
		btnAceptar.setVisible(true);
		lblresult.setVisible(false);
		
		lblCondicin.setVisible(true);
		comboBox_1.setVisible(true);

		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		textField_3.setVisible(false);
		

		lblDias.setVisible(false);
		lblId.setVisible(false);
		lblApellidos.setVisible(false);
		lblNombre.setVisible(false);
		
		lblId2.setVisible(false);
		lblApellidos2.setVisible(false);
		lblNombre2.setVisible(false);
		
		comboBox_2.setVisible(false);
		comboBox_3.setVisible(false);
		
		lblVendedor.setVisible(false);
		lblCobrador.setVisible(false);
		lblDelTipoDe.setVisible(false);
		lblZona.setVisible(false);
		lblCantidad.setVisible(false);
		
		if(nivelDeCredenciales==2) {
			if(entidad.equals("Supervisor(es)")) {
				if(opcion.equals("De cierto departamento")){
					textField.setVisible(true);
					lblNombre.setVisible(true);
					
				}
			}else if(entidad.equals("Vendedor(es)")) {
				if(opcion.equals("De cierto departamento")){
					textField.setVisible(true);
					lblNombre.setVisible(true);
					
				}
				else if(opcion.equals("De cierto supervisor")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);
				}
			}else if(entidad.equals("Cliente(s)")){
				if(opcion.equals("Con mismo cobrador y vendedor")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					textField_2.setVisible(true);
					textField_3.setVisible(true);
					
					lblNombre.setVisible(true);
					lblNombre2.setVisible(true);
					lblApellidos.setVisible(true);
					lblApellidos2.setVisible(true);
					
					lblVendedor.setVisible(true);
					lblCobrador.setVisible(true);
				}
			}else if(entidad.equals("Contrato(s)")){
				if(opcion.equals(	"Contratos del tipo:")){
					textField.setVisible(true);
					lblNombre.setVisible(true);
					lblDelTipoDe.setVisible(true);
				}
			}else if(entidad.equals("Tipo de contrato")){
				if(opcion.equals("Que se han vendido más")){

				}
				else if(opcion.equals("Qué genera más tipos de pagos")){
				
				}
			}else if(entidad.equals("Ganancias" )) {
				if(opcion.equals("Del periodo:")) {
					lblDias.setVisible(true);
					textField.setVisible(true);
				}
				else if(opcion.equals("Del mes")){
					
				}
				else if(opcion.equals("Suma de comisiones iniciales, por departamento en el mes")){
									
				}
				
			}else {
				btnAceptar.setVisible(false);
				comboBox_1.setVisible(false);
				lblCondicin.setVisible(false);
			}
			
		}else if(nivelDeCredenciales==1) {
			if(entidad.equals("Cobrador(es)")) {
				if(opcion.equals("Cobros realizados en la semana")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);
				}

				else if(opcion.equals("Lista de mis cobradores")){
					
				}
				else if(opcion.equals("Telefonos del cobrador")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);

				}
				else if(opcion.equals("Información de cierto cobrador")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);
				}
			}else if(entidad.equals("Vendedor(es)")){
				if(opcion.equals("Quién ha realizado más contratos en el mes")){
					
				}
				else if(opcion.equals("Quién ha vendido más contratos de cierto tipo")){
					textField.setVisible(true);
					lblNombre.setVisible(true);
					lblDelTipoDe.setVisible(false);
				}
				else if(opcion.equals("Teléfonos del vendedor")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);
				}
				else if(opcion.equals("Información de cierto vendedor")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);
				}
				else if(opcion.equals("Lista de mis vendedores")){

				}
			}else if(entidad.equals("Cliente(s)")){
				if(opcion.equals("Clientes de cierto vendedor")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);
					
				}
			}else if( entidad.equals("Ganancias")){
				if(opcion.equals("Ganancias de cada vendedor este mes")){
					
				}
			}else {
				btnAceptar.setVisible(false);
				comboBox_1.setVisible(false);
				lblCondicin.setVisible(false);
			}
		} else {			
			if(entidad.equals("Cliente(s)")) {
				if(opcion.equals("Datos generales")){
					textField.setVisible(true);
					textField_1.setVisible(true);	
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);
				}
				else if(opcion.equals("Lista de mis clientes")){
					
				}
				else if(opcion.equals("Teléfonos de cierto cliente")){
					textField.setVisible(true);
					textField_1.setVisible(true);
					lblNombre.setVisible(true);
					lblApellidos.setVisible(true);

				}
				else if(opcion.equals("Adeudos de todos mis clientes")){


				}
				else if(opcion.equals("Adeudos de cierto cliente")){
					//TODO
				}
				else if(opcion.equals("Clientes con al menos N cantidad de pagos")){
					textField.setVisible(true);
					lblCantidad.setVisible(true);
				}
				else if(opcion.equals("Con cierto tipo de contrato")){
					textField.setVisible(true);
					lblNombre.setVisible(true);
					lblDelTipoDe.setVisible(false);
				}
				else if(opcion.equals("Por zona")){
					textField.setVisible(true);
					lblZona.setVisible(true);
				}
				else if(opcion.equals("Morosos")){

				}
				
			}else if(entidad.equals("Contrato(s)")){

				if(opcion.equals("Contratos de los cuales aún no me pagan comisión")){

				}
			}else {
				btnAceptar.setVisible(false);
				comboBox_1.setVisible(false);
				lblCondicin.setVisible(false);
			}
		}

	}
	

	private void close() {
		dc.endConection();
		System.exit(0);
	}
}