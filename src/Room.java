import java.io.Serializable;  
public abstract class Room  implements Serializable {

  // Number of bathrooms in the room
  protected int numOfBathrooms;

  // Number of balconies in the room
  protected int numOfBalcony;

  // Number of bedrooms in the room
  protected int numOfBedRoom;

  // Number of living rooms in the room
  protected int numOflivingRoom;


  // Price of the room per night
  protected double price;

  // Constructor that sets the price of the room
  public Room(int price) {
    this.price = price;
  }

  // Getter method to retrieve the price of the room
  public double getPrice() {
    return price;
  }

  // Abstract method that needs to be implemented by subclasses to calculate the cost
  // for a given number of days and rooms
  public abstract double calculateCost( int numOfRoom);

  // Overridden toString method to provide a textual representation of the room details
  @Override
  public String toString() {
    return "\nThe Price :" + price + 
           "\nThe number of Balcony :" + numOfBalcony +
           "\nNumber of BathRoom :" + numOfBathrooms +
           "\nNumber of LivingRoom :" + numOflivingRoom +
           "\nNumber of BedRooms :" + numOfBedRoom;
  }}