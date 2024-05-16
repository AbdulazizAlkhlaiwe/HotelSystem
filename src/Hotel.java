import java.io.*;  

	public class Hotel implements Serializable{
		  private String name;
		  private Reservation ReservationArr[];
		  private int countReser;
		  private int getresCounter;
		  public Hotel(String name) {

		  this.name = name;


		  ReservationArr=new Reservation[100];

		  countReser=0;

		  }


		  public boolean addReser(Reservation r) {
		  if(countReser<ReservationArr.length) {
		   
		  ReservationArr[countReser]=new Reservation(r);
		  countReser++;
		  
		  return true;
		}
		  else {
		  System.out.println("can't make Reservation");
		  return false;
		 }
		}
		  
		  public boolean removeReser(Reservation r) {

		  for(int i=0;i<countReser;i++) 
		   if(ReservationArr[i].getGuestName().equalsIgnoreCase(r.getGuestName())&&ReservationArr[i].getGuestPhoneNumber().equalsIgnoreCase(r.getGuestPhoneNumber())) {
		    ReservationArr[i]=ReservationArr[countReser-1];
		    ReservationArr[countReser-1]=null;
		    countReser--;
		  return true;
		  }
		  System.out.println("Reservation not found");

		  return false;
		}

		  public Reservation findReser(String GuestName,String phoneNumber) {
		   Reservation FoundResr = null;
		   for(int i=0;i<countReser;i++) {
		    if(ReservationArr[i].getGuestName().equalsIgnoreCase(GuestName)&&ReservationArr[i].getGuestPhoneNumber().equalsIgnoreCase(phoneNumber))
		      FoundResr =ReservationArr[i];
		   }
		   
		   return FoundResr;
		   
		  }
		  public Reservation getReservation2() {
		         
		             return ReservationArr[getresCounter++];}
		      
		  
		  
		  
		  
		  //Write---output  
		  public void savetofile(String file) throws IOException{  
		        File f=new File(file);;  
		        FileOutputStream s1=new FileOutputStream(f);  
		        ObjectOutputStream s2= new ObjectOutputStream(s1);  
		        for(int i=0;i<countReser;i++)  
		        s2.writeObject(ReservationArr[i]);  
		          
		        s1.close();  
		        s2.close();  
		    }  
		      
		    //Write-->output  
		public void savetofile(String name,String file) throws IOException{  
		    File f=new File(file);;  
		    FileOutputStream s1=new FileOutputStream(f);  
		    ObjectOutputStream s2= new ObjectOutputStream(s1);  
		    for(int i=0;i<countReser;i++)  
		        if( ReservationArr[i].getGuestName().equalsIgnoreCase(name))
		            s2.writeObject( ReservationArr[i]);  
		      
		    s1.close();  
		    s2.close();  
		  
		    }  
		  
		  
	
		//read-----input  
		public void LoadFromfile(String filename) throws IOException{  
		    int index=0;  
		    File f=new File(filename);  
		    FileInputStream read= new FileInputStream(f);  
		    ObjectInputStream readObject=new ObjectInputStream(read);  
		    try {  
		    while(true) {  
		    try {  
		     Reservation R=(Reservation)readObject.readObject(); 
		     System.out.println(R);
		    }catch(ClassNotFoundException e) {  //checked excpetion
		        System.out.println(e);  
		      
		    }}  
		      
		}catch(EOFException e) {  //unchecked exception
		    System.out.println("End of read");  
		    read.close();  
		    readObject.close();  
		}  
		      
		}  
		
		
		public Reservation[] getReservation() {  
		    return ReservationArr; // The array of reservation 
		}
		  
		  
		  
		  
		  
	}

