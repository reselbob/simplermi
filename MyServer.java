
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


public class MyServer extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;

    protected MyServer() throws RemoteException {

        super();

    }

    @Override
    public String echo(String message) throws RemoteException{
        Date date = new Date();
        System.err.println( "[" + message + "] is trying to echo at: " + date.toString() );
        return "Echoing: " + message;
    }

    public static void main(String[] args){
        try {

            Naming.rebind("//localhost:5000/MyServer", new MyServer());           
            System.err.println("Server is up and running!");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }
    }
}
