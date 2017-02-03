package RMI;

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		String servidor;
		int numCliente;
		Scanner sc = new Scanner(System.in);
		try {

			Interfaz obj = (Interfaz) Naming.lookup("//localhost/informacion");
			servidor = obj.pregunta();
			System.out.println(servidor);
			numCliente = sc.nextInt();
			servidor = obj.informacion(numCliente);
			System.out.println(servidor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
