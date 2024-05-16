import java.io.*;
public class Reservation implements Serializable {


		private String ReservationDate;
		private String guestName;
		private String guestPhoneNumber;
		private String paymentMethod;
		private Room[] Rooms;
		private int countRoom;
		
	    
		private int numOfStandard;
		private int numOfSuite;



		public Reservation(String guestName, String reservationDate, String guestPhoneNumber, String paymentMethod) throws ReservationExcpetion {  
	        if ( guestName == null || guestName.trim().isEmpty() || guestPhoneNumber == null || guestPhoneNumber.trim().isEmpty()) {  
	            throw new ReservationExcpetion("Invalid PhoneNumber or Name");  
	        }  
	        Rooms=new Room[3];


			this.ReservationDate = reservationDate;
			this.guestName = guestName;
			this.guestPhoneNumber = guestPhoneNumber;
			this.paymentMethod = paymentMethod;
			countRoom=0; 
	    }  




		public String getGuestName() {
		return guestName;

		}

		public String getGuestPhoneNumber() {
		return guestPhoneNumber;

		}

		public Reservation(Reservation r) {
		this.ReservationDate = r.ReservationDate;
		this.guestName = r.guestName;
		this.guestPhoneNumber = r.guestPhoneNumber;
		this.paymentMethod = r.paymentMethod;
		this.Rooms=new Room[r.Rooms.length];

		for(int i=0;i<r.countRoom;i++) {
		this.Rooms[i]=r.Rooms[i];
		}
		}

		public boolean addRoom(Room R) {
		if(R instanceof StandardRoom) {
		    Rooms[countRoom] = R;
		    countRoom++;
		    numOfStandard++;
		    return true;
		}
		else
		 Rooms[countRoom] = R;
		 countRoom++;
		 numOfSuite++;
		 return true;
		}


		public boolean removeRoom(Room R) {
		    for (int i=0; i <countRoom; i++) 
		    {
		    	if(Rooms[i] instanceof StandardRoom) 
		    		Rooms[i]=Rooms[countRoom-1];
		    		Rooms[countRoom-1]=null;
		     
		    	if(Rooms[i] instanceof SuiteRoom)     
		        Rooms[i]=Rooms[countRoom-1];
		         Rooms[countRoom-1]=null; 
		    
		 }
		    countRoom--;
		    return true;


		}
		
		public void savetofile(String file) throws IOException{  
	        File f=new File(file);;  
	        FileOutputStream s1=new FileOutputStream(f);  
	        ObjectOutputStream s2= new ObjectOutputStream(s1);  
	        for(int i=0;i<countRoom;i++)  
	        s2.writeObject( Rooms[i]);  
	          
	        s1.close();  
	        s2.close();  
	    }  
	      
	    //Write-->output  
	
	public String getReservationDate() {
			return ReservationDate;
		}


		public String getPaymentMethod() {
			return paymentMethod;
		}


	//read-----input  
	public void LoadFromfile(String filename) throws IOException{  
	    File f=new File(filename);  
	    FileInputStream read= new FileInputStream(f);  
	    ObjectInputStream readObject=new ObjectInputStream(read);  
	    try {  
	    while(true) {  
	    try {  
	     Room Rom=(Room)readObject.readObject(); 
	     
	    }catch(ClassNotFoundException e) {  
	        System.out.println(e);  
	      
	    }}  
	      
	}catch(EOFException e) {  
	    System.out.println("End of read");  
	    read.close();  
	    readObject.close();  
	}  
	      
	}  
		
		

	public Room[] getRooms() {  
	    return Rooms; // The array of room 
	}
	  
		@Override
		public String toString() {
		 String resFormat="ReservationDate : " + ReservationDate + ", guestName : " + guestName + ", guestPhoneNumber : "
		   + guestPhoneNumber + ", paymentMethod : " + paymentMethod + ", Rooms : " 
		   + ", number of rooms" + countRoom+"\n" ;
		 
		 for(int i=0;i<countRoom;i++) {
		  if(Rooms[i] instanceof StandardRoom)
		  resFormat+=((StandardRoom)Rooms[i]).toString()+"\n Total : "+((StandardRoom)Rooms[i]).calculateCost(numOfStandard)+"\n";
		  else
		   resFormat+=((SuiteRoom)Rooms[i]).toString()+"\n Total : "+((SuiteRoom)Rooms[i]).calculateCost(numOfSuite)+"\n";
		 }
		 return resFormat;
		}
		}

