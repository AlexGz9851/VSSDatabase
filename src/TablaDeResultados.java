import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class TablaDeResultados extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea textarea1;
	JScrollPane scrollpane1;
	JButton btnRegresar;
	private JLabel lblResultadosDeLa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnection dc = new DatabaseConnection(true);
					DatabaseConnection.Tabla t = dc.new Tabla();
					TablaDeResultados frame = new TablaDeResultados( dc, t);
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
	public TablaDeResultados(DatabaseConnection dc, DatabaseConnection.Tabla t ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textarea1=new JTextArea();        
        scrollpane1=new JScrollPane(textarea1);    
        scrollpane1.setBounds(10,80,450,350);
        textarea1.setEditable(false);
        getContentPane().add(scrollpane1);

        
        
        btnRegresar = new JButton("Regresar");
        btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnRegresar.setBounds(36, 447, 101, 33);
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(this);
		
		String title= ":::Resultados de la consulta:::";
		
		String text =title+"\n\n";
		text+= t.voidt ? "La consulta arrojó una tabla sin datos.\n" :"";
		text+=t.toString();
		
		textarea1.setText(text);
		
		lblResultadosDeLa = new JLabel("Resultados de la consulta de datos");
		lblResultadosDeLa.setForeground(Color.WHITE);
		lblResultadosDeLa.setFont(new Font("Arial", Font.BOLD, 26));
		lblResultadosDeLa.setBounds(10, 23, 450, 33);
		contentPane.add(lblResultadosDeLa);
	}

	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
