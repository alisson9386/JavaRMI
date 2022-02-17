package alisson.rmi;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.*;
@SuppressWarnings("serial")
public class ContaImpl extends UnicastRemoteObject implements Conta {

	@SuppressWarnings("unused")
	private int numero;
	private double saldo = 0.0;
	public ContaImpl (int n) throws RemoteException {
		super();
		numero= n;
	}
	public double obterSaldo () throws RemoteException {
		System.out.println("Metodo remoto em execucao: Retornar Saldo");
		return saldo;
	}
	public void setSaldo (double s) throws RemoteException {
		System.out.println("Metodo remoto em execucao: Atualizar saldo");
		saldo = s;
	}
	public static void main (String[] args)
			throws RemoteException, MalformedURLException {
		Conta c = new ContaImpl (804);
		Naming.rebind ("Conta804", c); // registra este objeto
		System.out.println("Servidor ativo!");
	}
}
