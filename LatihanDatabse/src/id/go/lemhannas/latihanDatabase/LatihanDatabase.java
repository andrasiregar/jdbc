package id.go.lemhannas.latihanDatabase;

import java.sql.*;

public class LatihanDatabase {
	// JDBC driver name dan database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/namadatabase";
	
	// Database username dan password
	static final String USER = "root";
	static final String PASS = "Lemhannas123";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsst = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
		
			//STEP 3: Open a connection
			System.out.println("mengkoneksikan diri ke database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Koneksi OK Boss!");
		
			stmt = conn.createStatement();
			String sqlquery;

		
			
			//contoh INSERT data ke database
			String insertquery;
			insertquery = "INSERT INTO data (id,nama,alamat) VALUES ('1','Andra','Jakarta')";
			stmt.executeUpdate(insertquery);
			System.out.println("Penambahan data sukses");
		
			sqlquery = "SELECT * FROM data";
			rsst = stmt.executeQuery(sqlquery);
			
			while (rsst.next()){
				int id = rsst.getInt(1);
				String nama = rsst.getString(2);
				String alamat = rsst.getString(3);
			
				System.out.println("No :" + id);
				System.out.println("Nama :" + nama);
				System.out.println("Alamat :" + alamat);
			}
		
			
			
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Koneksi Gagal");
		}
		
		System.out.println("Goodbye!");
	}
}