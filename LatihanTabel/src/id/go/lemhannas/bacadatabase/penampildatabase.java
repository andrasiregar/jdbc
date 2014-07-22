package id.go.lemhannas.bacadatabase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class penampildatabase extends JFrame {

	private JPanel contentPane;
	private JTextField nama;
	private JTextField alamat;
	
	// JDBC driver name dan database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/namadatabase";
	
	// Database username dan password
	static final String USER = "root";
	static final String PASS = "Lemhannas123";

	Statement stmt = null;
	ResultSet rsst = null;
	Connection conn = null;
	private JTable table;
	private JTable table_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					penampildatabase frame = new penampildatabase();
					frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public penampildatabase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProgramBacaTulis = new JLabel("PROGRAM BACA TULIS DATABASE MENGGUNAKAN JAVA");
		lblProgramBacaTulis.setBounds(5, 5, 424, 14);
		contentPane.add(lblProgramBacaTulis);
		
		JLabel lblNama = new JLabel("NAMA");
		lblNama.setBounds(50, 111, 72, 14);
		contentPane.add(lblNama);
		
		JLabel lblAlamat = new JLabel("ALAMAT");
		lblAlamat.setBounds(50, 136, 72, 14);
		contentPane.add(lblAlamat);
		
		nama = new JTextField();
		nama.setBounds(118, 108, 86, 20);
		contentPane.add(nama);
		nama.setColumns(10);
		
		alamat = new JTextField();
		alamat.setBounds(118, 133, 86, 20);
		contentPane.add(alamat);
		alamat.setColumns(10);
		
		DefaultTableModel tabelnya = new DefaultTableModel();
		table = new JTable(tabelnya);
		table.setBounds(0, 0, 369, -38);
		
		
		
		tabelnya.addColumn("ID");
		tabelnya.addColumn("NAMA");
		tabelnya.addColumn("ALAMAT");
		
		JButton btnSimpanKeDatabase = new JButton("SIMPAN KE DATABASE");
		btnSimpanKeDatabase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String namapeserta = nama.getText();
				String alamatpeserta = alamat.getText();
				String insertquery;
				String sqlquery;
	
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("mengkoneksikan diri ke database...");
					conn = DriverManager.getConnection(DB_URL,USER,PASS);
					System.out.println("Koneksi OK Boss!");
				
					insertquery = "INSERT INTO data (nama,alamat) VALUES (\""+namapeserta+"\",\""+alamatpeserta+"\")";
					stmt = conn.createStatement();
					stmt.executeUpdate(insertquery);
				
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Penambahan data gagal");
				}
				
				System.out.println("Penambahan data sukses");
				
				sqlquery = "SELECT * FROM data";
				try {
					rsst = stmt.executeQuery(sqlquery);
					
					rsst.first();
					
					tabelnya.insertRow(0, new Object[]{rsst.getInt(1), rsst.getString(2), rsst.getString(3)});
					
					//while (rsst.next()){
					//	int id_baru = rsst.getInt(1);
					//	String nama_baru = rsst.getString(2);
					//	String alamat_baru = rsst.getString(3);
					//
					//	System.out.println("No :" + id_baru);
					//	System.out.println("Nama :" + nama_baru);
					//	System.out.println("Alamat :" + alamat_baru);
					//}
									
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSimpanKeDatabase.setBounds(281, 157, 143, 23);
		contentPane.add(btnSimpanKeDatabase);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 231, 369, -38);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(table);
		
		
		
		
		
	}
}
