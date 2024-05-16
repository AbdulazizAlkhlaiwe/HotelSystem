

	public class SuiteRoom extends Room {
		private  final int TotalSuites=100;

		 
		 
		 
		public SuiteRoom( int price) {
		super(2999);  //in riyadh


		numOfBalcony=2;
		numOfBathrooms=2;
		numOflivingRoom=2;
		numOfBedRoom=3;
		;
		}







		public double calculateCost(int numOfRoom) {
		 return numOfRoom*3000;
		}
		@Override
		public String toString() {
		return "Room is suite "+super.toString();
		}


		 
		}

