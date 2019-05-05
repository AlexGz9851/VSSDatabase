import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionarAccion extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DatabaseConnection dc;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JButton btnEliminar;
	private JButton btnAgregar ;
	private JButton btnConsultar;
	private String user;
	private JButton btnActualizar ;
	private int nivelDeCredenciales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnection dc = new DatabaseConnection(true);
					SeleccionarAccion frame = new SeleccionarAccion(dc, null, 0);
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
	public SeleccionarAccion(DatabaseConnection dc, String user, int credenciales) {
		this.dc=dc;
		this.user=user;
		this.nivelDeCredenciales = credenciales;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		
		int h=450;
		int v=300;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		//setBounds((screenSize.width-h)/2, (screenSize.height-v)/2, h, v);
		setBounds((screenSize.width-h)/2, (screenSize.height-v)/2, h, v);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAgregar.setBackground(new Color(0, 153, 204));
		btnAgregar.setBounds(21, 131, 107, 41);
		btnAgregar.addActionListener(this);
		contentPane.add(btnAgregar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 18));
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(new Color(0, 153, 204));
		btnConsultar.setBounds(157, 131, 126, 41);
		btnConsultar.addActionListener(this);
		contentPane.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(0, 153, 204));
		btnEliminar.setBounds(305, 131, 119, 41);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(this);
		
		lblNewLabel = new JLabel("Seleccione acci\u00F3n a realizar:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(21, 72, 367, 34);
		contentPane.add(lblNewLabel);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 18));
		btnCancelar.setBackground(new Color(0, 153, 204));
		btnCancelar.setBounds(311, 212, 113, 34);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
		
		JLabel lblB = new JLabel("Bienvenido "+user );
		lblB.setForeground(Color.WHITE);
		lblB.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblB.setBounds(21, 11, 367, 34);
		contentPane.add(lblB);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 18));
		btnActualizar.setBackground(new Color(0, 153, 204));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(21, 209, 126, 41);
		contentPane.add(btnActualizar);
	}
	private void close() {
		dc.endConection();
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConsultar) {
			Select frame = new Select(dc, user, nivelDeCredenciales);
			frame.setVisible(true);
			this.dispose();
		}else if(e.getSource()==btnEliminar){
			Delete frame = new Delete(dc, user, nivelDeCredenciales);
			frame.setVisible(true);
			this.dispose();
		}else if(e.getSource()==btnAgregar){
			Insertar frame = new Insertar(dc, user,nivelDeCredenciales );
			frame.setVisible(true);
			this.dispose();
		}else if(e.getSource() == btnActualizar) {
			Update frame = new Update(dc, user, nivelDeCredenciales);
			frame.setVisible(true);
			this.dispose();
		}else {
			dc.endConection();
			log_in frame = new log_in();
			frame.setVisible(true);
			this.dispose();
		}
		
	}
}
