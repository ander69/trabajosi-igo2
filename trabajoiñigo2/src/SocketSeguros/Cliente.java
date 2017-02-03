package SocketSeguros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Cliente {

	public static void main(String[] args) {
		String host="Localhost";
		int puerto=6000;
		
		System.out.println("Cliente iniciado");
		SSLSocketFactory sfact=(SSLSocketFactory) SSLSocketFactory.getDefault();
		try {
			SSLSocket Cliente=(SSLSocket) sfact.createSocket(host, puerto);
			DataOutputStream flujoSalida=new DataOutputStream(Cliente.getOutputStream());
			DataInputStream flujoEntrada=new DataInputStream(Cliente.getInputStream());
			
			flujoSalida.writeInt(25);
			flujoSalida.writeInt(65);

			System.out.println(flujoEntrada.readUTF());
			
			flujoSalida.close();
			flujoEntrada.close();
			Cliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
