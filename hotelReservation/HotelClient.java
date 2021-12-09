import java.net.MalformedURLException;
import java.rmi.Naming;

public class HotelClient {

  public static void main(String[] args) {
    try {
      RoomManager obj = (RoomManager) Naming.lookup("rmi://localhost:5000/HotelServices");

      if (args.length == 2) {
        switch (args[0]) {

        case "list":
          System.out.println(obj.list());
          break;
        case "guests":
          System.out.println(obj.guests());
          break;
        case "revenue":
          System.out.println(obj.revenue());
          break;

        }

      }else if(args.length >= 4){
        switch (args[0]) {
          case "book":
            System.out.println(obj.book(args[2], args[3]));
            break;
        }

      }
      else{       
              // Display commands to choose from by the client

            System.out.println(">>>>>>>>>~~ Defined Shell Commands ~~<<<<<<<<<\n");
            System.out.println("1. java HotelClient list    <server address>: List the available number of rooms in each price range.");
            System.out.println("2. java HotelClient revenue <server address>: Prints the revenue based on the type of rooms booked");
            System.out.println("3. java HotelClient guests  <server address>: List the names of all the registered guests");
            System.out.println("4. java HotelClient book    <server address> <Room type> <Guest name>:books a  room of the specified type .");
      }
    } catch (Exception e) {
      System.out.println("Received Exception: ");
      System.out.println(e);
    }
  }
}
