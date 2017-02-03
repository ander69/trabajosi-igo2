package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements Interfaz {
	protected Servidor() throws RemoteException {
		super();
	}

	public String pregunta() throws RemoteException {
		String pregunta;
		pregunta = "De que numero quieres que te de informacion?";
		return pregunta;

	}

	public String informacion(int num) throws RemoteException {
		String esprimo = "SI";
		String sumar;
		String multiplos = "";
		int numSiguente;
		int numAnterior;
		String informacion;

		numSiguente = num + 1;
		numAnterior = num - 1;

		if (num % 2 == 0) {
			esprimo = "NO";
		}

		for (int i = 0; i < 10; i++) {

			num = num + num;
			sumar = String.valueOf(num);
			multiplos = multiplos + " , " + sumar;

		}

		informacion = "Es un numero primo:" + esprimo + "\nSu numero anterio es el : " + numAnterior
				+ " y su numero siguiente es el : " + numSiguente + "\nEstos son sus multiplos" + multiplos;

		return informacion;
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			Servidor obj = new Servidor();
			Naming.rebind("//localhost/informacion", obj);

		} catch (RemoteException | MalformedURLException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		System.out.println("servidor ejecutado");

	}

}
