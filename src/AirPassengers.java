public class AirPassengers {
	String year;
	int passengers;

public AirPassengers(String line){
	String [] data = line.split(",");
	this.year= data[1];
	this.passengers= Integer.parseInt(data[2]);			
}


	public String getYear() {
		return year;
	}

	public int getPassengers() {
		return passengers;
	}
}
