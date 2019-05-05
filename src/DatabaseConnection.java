
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DatabaseConnection {
	
	private boolean modoPrueba;
	private Connection con;
	private String usuario;
	private Statement stmt;
	private ResultSet rs;
	private final String user = "XXXXXXX";
	private final String cont= "XXXXXXX";
	public DatabaseConnection( boolean modoPrueba) {
		this.modoPrueba=modoPrueba;
		if(!modoPrueba) {
			try{  
				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				con=DriverManager.getConnection(  "jdbc:oracle:thin:@10.40.53.10:1521:alum",user,cont);  
				//step3 create the statement object  
				stmt=con.createStatement();  
//				//step4 execute query  
//				rs=stmt.executeQuery("select * from credenciales");  
//				System.out.println("Todo bien");
//				while(rs.next()) { 
//				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//				}
				//endConection();

				
			}catch (SQLException e) {

				System.out.println(e.getMessage());
			}catch (ClassNotFoundException  e) {

				System.out.println("sfgdhgnfh");
				System.out.println(e.getMessage());
			}
		}
	}
	public static void main(String[] a) {
		DatabaseConnection dc = new DatabaseConnection(true);
		System.out.println(dc.getNivelDeCredenciales("USERB", "b1"));
		//dc.ResultInsertQuery("INSERT INTO TelefonoCo VALUES(  'CB003' , 99999999)");
	}
	
	public boolean getModoPrueba() {
		return modoPrueba;
	}
	
	public String getUsuario() {
		return modoPrueba?"prueba":usuario;
	}
	
	public int getNivelDeCredenciales(String usuario, String contrasena) {
		int credenciales = -1;
		//step4 execute query 
		if(modoPrueba) {
			return 0;
		}
		try {
			String s;
			s= "select contrasena from credenciales where usuario = "+"'"+usuario+"'";
			System.out.println(s);
			rs=stmt.executeQuery(s);
			String contra="";
			while(rs.next()) {
				contra= rs.getString(1);
			}
			System.out.println(contra);
			System.out.println(contrasena);
			if(contra.equals(contrasena)) {
				String s2 = "select credenciales  from credenciales where usuario = "+"'"+usuario+"'";
				System.out.println(s2);
				rs=stmt.executeQuery(s2); 
				while(rs.next()) {
					credenciales = Integer.parseInt(rs.getString(1));
				}
			}else {
				credenciales =-2;// usuario incorrecto
			}
		}catch (Exception e) {
			
		}
		return credenciales;
		
	}
	
	public String strCredenciales(int c) {
		if(c==2) {
			return "Administrador";
		}else if(c==1) {
			return "Supervisor";
		}else {
			return "Vendedor";
		}
	}
	
	public void endConection() {
		if(!modoPrueba) {
			try {
				if(con!=null || !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("Hubo un problema y no se pudo desconectar.");
			}
		}
		else {
			System.out.println("Modo prueba, no se desconecta.");
		}
		System.out.println("Se desconecto");
	}
	
	public boolean ResultInsertQuery(String q) {
		System.out.println(q);
		boolean bo = resultUpdateQuery(q);
		System.out.println(bo);
		return bo;
	}
	public boolean resultDeleteQuery(String q) {
		return resultUpdateQuery(q);
	}
	public Tabla resultSelectQuery(String q){
		//TODO para select
		Tabla result = new Tabla();
		try {
			rs = stmt.executeQuery(q);
			ResultSetMetaData rsmd = rs.getMetaData();
			int j=0;
			while(rsmd!=null) {
				try {	
					String z = rsmd.getColumnName(j+1).strip();
					result.metadata.tupla.add(z);
					result.voidt=false;
					j++;
				}catch (SQLException e)
				{
					break;
				}
			}

			//System.out.println(rs.toString());
			while(rs.next()) {
				Tupla tupla = new Tupla();
					int i=0;
					while(rs!=null) {
					try {	
						String z = rs.getString(i+1).strip();
						tupla.tupla.add(z);
						i++;
					}catch (SQLException e)
					{
						break;
					}
					
				}
				result.tabla.add(tupla);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		result.exito=true;
		return result;
	}
	
	public boolean resultUpdateQuery(String q) {
		try {
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.executeUpdate();
			return true;
		}catch(Exception ee) {
			System.out.println(ee.getMessage());
			return false;
		}
	}
	

	public LinkedList<String> rowSelectQuery(String q){
		LinkedList<String> ex= new LinkedList<String>();
		if(modoPrueba) {
			ex.add("df");
			ex.add("sd");
			ex.add("gds");
		}else {

			try {
				rs = stmt.executeQuery(q);
				while(rs.next()) {
					String z = rs.getString(1).strip();
					ex.add(z);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		return ex;
	}
	
	public class Tabla{
		LinkedList<Tupla> tabla;
		boolean exito, voidt;
		Tupla metadata;
		
		public Tabla() {
			tabla = new LinkedList<DatabaseConnection.Tupla>();
			metadata = new Tupla();
			exito=false;
			voidt=true;
		}
		public String toString() {
			String result="";
			result += metadata.toString()+"\n\n";
			for(Tupla t: tabla) {
				result+= t.toString()+"\n";
			}
			return result;
		}
		
	}
	public class Tupla{
		public LinkedList<String> tupla;
		public Tupla() {
			tupla = new LinkedList<String>();
		}
		public String toString() {
			String result="";
			for(String s: tupla) {
				result+=s+" ,\t";
			}
			return result;
		}
	}

}
