import java.rmi.*;

public interface RoomManager extends Remote {

    //Prints the available rooms with individual Pricing
    public String list() throws RemoteException ;

    // Books specified room, and attaches the Guest's name
    public String book(String roomType, String guestName)throws RemoteException ;

    //Prints the available guests
    public String guests() throws RemoteException ;

    //prints the revenue based on the type of rooms booked.
    public String revenue() throws RemoteException ;
}
