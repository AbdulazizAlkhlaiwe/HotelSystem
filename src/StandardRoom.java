

	public class StandardRoom extends Room {
		private  final int TotalStandardRoom=200;

		public StandardRoom( int price) {
		super(1499); //in riyadh
		 
		 
		numOfBalcony=1;
		numOfBathrooms=1;
		numOflivingRoom=1;
		numOfBedRoom=1;

		}



		public double calculateCost(int numOfRoom) {
		 return numOfRoom*1499;
		}



		@Override
		public String toString() {
		 return "Room is Standard "+super.toString();
		}



		}

