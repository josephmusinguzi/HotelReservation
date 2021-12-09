import java.util.*;
import java.util.HashMap; // import the HashMap class
import java.rmi.*;

public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager {

    public RoomManagerImpl() throws RemoteException {
        super();
    }

    // Guest List
    ArrayList<String> guests = new ArrayList<String>();

    // Declaring Revenue Variables
    double totalRevenue = 0;

    double type0Revenue = 0;
    double type1Revenue = 0;
    double type2Revenue = 0;
    double type3Revenue = 0;
    double type4Revenue = 0;

    // Declaring Room type Variables
    int type_0_rooms = 10;
    int type_1_rooms = 20;
    int type_2_rooms = 5;
    int type_3_rooms = 3;
    int type_4_rooms = 2;

    // Declaring Room prices based on the room type Variables
    double type_0_price = 55000;
    double type_1_price = 75000;
    double type_2_price = 80000;
    double type_3_price = 150000;
    double type_4_price = 230000;

    // To implement the list method
    public String list() throws RemoteException {

        String result = "";

        result = result.concat("\n List of available rooms with Prices ");
        String type0result = (type_0_rooms > 0)
                ? type_0_rooms + " rooms of type 0 Single Room are available for " + type_0_price + " UGX per night"
                : "No Single rooms available";
        String type1result = (type_1_rooms > 0)
                ? type_1_rooms + " rooms of type 1 Double Room are available for " + type_1_price + " UGX per night"
                : "No Double rooms available";
        String type2result = (type_2_rooms > 0)
                ? type_2_rooms + " rooms of type 2 Twin Room are available for " + type_2_price + " UGX per night"
                : "No Twin rooms available";
        String type3result = (type_3_rooms > 0)
                ? type_3_rooms + " rooms of type 3 Tripple Room are available for " + type_3_price + " UGX per night"
                : "No Tripple rooms available";
        String type4result = (type_4_rooms > 0)
                ? type_4_rooms + " rooms of type 4 Quad Room are available for " + type_4_price + " UGX per night"
                : "No Quad rooms available";

        result = result.concat("\n" + type0result +"\n" +type1result +"\n" +type2result+"\n" +type3result +"\n" +type4result);

        return result;
    }

    // To implement the book method
    public String book (String roomType, String guestName) throws RemoteException {

        String result = "";
        switch (roomType) {
        case "0":
            if (type_0_rooms > 0) {
                guests.add(guestName);
                type0Revenue += type_0_price;
                type_0_rooms -= 1;
                result = result.concat("\n You have booked 1 room of type 0 Single room at " + type_0_price + "UGX");
            } else {
                result = result.concat("\n No  Single rooms available");
            }
            break;
        case "1":
            if (type_1_rooms > 0) {
                guests.add(guestName);
                type1Revenue += type_1_price;
                type_1_rooms -= 1;
                result = result.concat("\n You have booked 1 room of type 1 Double room at " + type_1_price + "UGX");
            } else {
                result = result.concat("\n No  Double rooms available");
            }
            break;
        case "2":
            if (type_2_rooms > 0) {
                guests.add(guestName);
                type2Revenue += type_2_price;
                type_2_rooms -= 1;
                result = result.concat("\n You have booked 1 room of type 2 Twin room at " + type_2_price + "UGX");
            } else {
                result = result.concat("\n No  Twin rooms available");
            }
            break;
        case "3":
            if (type_3_rooms > 0) {
                guests.add(guestName);
                type3Revenue += type_3_price;
                type_3_rooms -= 1;
                result = result.concat("\n You have booked 1 room of type 3 Tripple room at " + type_3_price + "UGX");
            } else {
                result = result.concat("\n No  Tripple rooms available");
            }
            break;
        case "4":
            if (type_4_rooms > 0) {
                guests.add(guestName);
                type4Revenue += type_4_price;
                type_4_rooms -= 1;
                result = result.concat("\n You have booked 1 room of type 4 Quad room at " + type_4_price + "UGX");
            } else {
                result = result.concat("\n No  Quad rooms available");
            }
            break;
        }

        return result;
    }

    // Printing available guests
        public String guests() throws RemoteException {
        String result = "";
        
        if (guests.size() == 0) {
            result = result.concat("\n No registered Guests");
        } else {
            result = result.concat("\n Registered Guests");
            for (int i = 0; i < guests.size(); i++) {
                result = result.concat("\n" + (i + 1) + ". " + guests.get(i));
            }
        }
        return result;
    }

  
    // Summing up the revenue and displaying the total, Per room with respective pricing.
    public String revenue() throws RemoteException {
        String result = "";

        totalRevenue = type0Revenue + type1Revenue + type2Revenue + type3Revenue + type4Revenue;
        if (totalRevenue == 0) {
            result = result.concat("No revenue accumulated");
        } else {
            result = result.concat("\n Revenue Information Summary");
            result = result.concat("\nType 0 revenue: " + type0Revenue + "UGX");
            result = result.concat("\nType 1 revenue: " + type1Revenue + "UGX");
            result = result.concat("\nType 2 revenue: " + type2Revenue + "UGX");
            result = result.concat("\nType 3 revenue: " + type3Revenue + "UGX");
            result = result.concat("\nType 4 revenue: " + type4Revenue + "UGX");

            result = result.concat("\n\nTotal Revenue: " + totalRevenue + "UGX");
        }

        return result;
    }

}
