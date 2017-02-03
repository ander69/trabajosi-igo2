package urls;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.awt.event.ActionEvent;

public class Descargarfoto extends JFrame {

	private JPanel contentPane;
	private JTextField tfUrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Descargarfoto frame = new Descargarfoto();
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
	public Descargarfoto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(40, 25, 46, 14);
		contentPane.add(lblUrl);
		
		tfUrl = new JTextField();
		tfUrl.setBounds(80, 22, 415, 20);
		contentPane.add(tfUrl);
		tfUrl.setColumns(10);
		
		JButton btnDescargar = new JButton("Descargar");
		btnDescargar.addActionListener(new ActionListener() {
			private Component contentPanel;

			public void actionPerformed(ActionEvent arg0) {
				
				String pagina;

				try {
					pagina = tfUrl.getText().toString();
					URL u = new URL(pagina);
					URLConnection uc = u.openConnection();
					String ct = uc.getContentType();
					int cl = uc.getContentLength();
					if (ct.startsWith("text/") || cl == -1) {
						System.out.println("ERROR: Esta URL" + " es de tipo texto");
						return;
					}
					InputStream is = uc.getInputStream();
					BufferedInputStream in = new BufferedInputStream(is);
					String fich = u.getFile();
					fich = fich.substring(fich.lastIndexOf('/') + 1);
					FileOutputStream fout = new FileOutputStream(fich);
					BufferedOutputStream out = new BufferedOutputStream(fout);
					int i;
					while ((i = in.read()) != -1)
						out.write(i);
					out.flush();
					in.close();
					out.close();

				} catch (MalformedURLException e) {
					System.out.println("URL erronea: ");
				} catch (Exception e) {
					System.out.println("Error" + e.getMessage());
				}
				JOptionPane.showMessageDialog(contentPanel, "Descargado correctamente mira en la raiz ");
				tfUrl.setText("");

			
				
			}
		});
		btnDescargar.setBounds(224, 94, 137, 23);
		contentPane.add(btnDescargar);
	}
}
