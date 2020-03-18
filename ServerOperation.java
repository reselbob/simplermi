//package com.reselbob.rmiserver;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//import com.reselbob.rmiinterface.RMIInterface;

public class MyServer extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;

    protected MyServer() throws RemoteException {

        super();

    }

    @Override
    public String echo(String message) throws RemoteException{

        System.err.println(message + " is trying to make a connection!");
        return "Echoing: " + message;

    }

    public static void main(String[] args){

        try {

            Naming.rebind("//localhost:5000/MyServer", new ServerOperation());            
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }

    }

}
