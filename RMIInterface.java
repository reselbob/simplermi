//package com.reselbob.rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public String echo(String message) throws RemoteException;

}