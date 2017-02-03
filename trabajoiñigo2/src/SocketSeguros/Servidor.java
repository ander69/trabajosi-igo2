package SocketSeguros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		int puerto=6000;
		int num1,num2,suma,resta,multi;
		String respuesta;
		SSLServerSocketFactory sfact=(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		SSLServerSocket servidorSSL=(SSLServerSocket) sfact.createServerSocket(puerto);
		SSLSocket clienteConectado=null;
		DataInputStream flujoEntrada=null;
		DataOutputStream flujoSalida=null;
			System.out.println("Servidor iniciado");
			clienteConectado=(SSLSocket) servidorSSL.accept();
			flujoEntrada=new DataInputStream(clienteConectado.getInputStream());
			num1=flujoEntrada.readInt();
			num2=flujoEntrada.readInt();
			suma=num1+num2;
			resta=num1-num2;
			multi=num1*num2;
			flujoSalida=new DataOutputStream(clienteConectado.getOutputStream());
			
			flujoSalida.writeUTF("Suma: "+String.valueOf(suma)+" \nResta: "+String.valueOf(resta)+" \nMultiplicacion: "+String.valueOf(multi));
	
		
		
		flujoEntrada.close();
		flujoSalida.close();
		clienteConectado.close();
		servidorSSL.close();
		
	}

}