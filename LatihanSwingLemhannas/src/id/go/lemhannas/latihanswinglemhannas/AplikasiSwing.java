package id.go.lemhannas.latihanswinglemhannas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class AplikasiSwing extends JFrame {

	private JPanel contentPane;
	private JTextField txtInputBilangan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplikasiSwing frame = new AplikasiSwing();
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
	public AplikasiSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPencetTombolDibawh = new JLabel("PENCET TOMBOL DIBAWAH");
		lblPencetTombolDibawh.setBounds(155, 117, 159, 40);
		contentPane.add(lblPencetTombolDibawh);
		
		JButton btnTampilkan = new JButton("PERIKSA");
		btnTampilkan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPencetTombolDibawh.setText("BAGOOESS");
				int angka = txtInputBilangan.getText
			}
		});
		btnTampilkan.setBounds(156, 148, 136, 23);
		contentPane.add(btnTampilkan);
		
		JLabel lblAplikasiPengujiBilangan = new JLabel("Aplikasi Penguji Bilangan Prima");
		lblAplikasiPengujiBilangan.setBounds(150, 11, 185, 14);
		contentPane.add(lblAplikasiPengujiBilangan);
		
		JLabel lblMasukkanBilanganYang = new JLabel("Masukkan Bilangan yang ingin anda uji");
		lblMasukkanBilanganYang.setBounds(136, 36, 246, 14);
		contentPane.add(lblMasukkanBilanganYang);
		
		txtInputBilangan = new JTextField();
		txtInputBilangan.setText("input bilangan");
		txtInputBilangan.setBounds(163, 61, 129, 37);
		contentPane.add(txtInputBilangan);
		txtInputBilangan.setColumns(10);
		

	}
}
