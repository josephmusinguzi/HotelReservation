import java.rmi.Naming;
public class HotelServer {
  public HotelServer() {
    try {

      RoomManager c = new RoomManagerImpl();
      
      // It binds (registers) to the rmiregistry
      //The server Address is set to 5000, from the default
      Naming.rebind("rmi://localhost:5000/HotelServices", c);
    } catch (Exception e) {
      System.out.println("Trouble: _" + e);
    }
  }
    //creates a new server connection, which listens to 
    //incoming to requests from clients
  public static void main(String args[]) {
    new HotelServer();
  }
}
