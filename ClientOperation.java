package com.reselbob.rmiclient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.mkyong.rmiinterface.RMIInterface;

public class ClientOperation {

	private static RMIInterface look_up;

	public static void main(String[] args) 
		throws MalformedURLException, RemoteException, NotBoundException {
		
		look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");

		System.out.print("Enter a message:");
		String input = System.console().readLine();
			
		String response = look_up.echo(input);

		System.out.print(response);
	}

}
