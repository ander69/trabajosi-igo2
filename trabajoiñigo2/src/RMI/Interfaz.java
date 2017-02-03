package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote {
	String pregunta() throws RemoteException;
	String informacion(int num) throws RemoteException;

}
