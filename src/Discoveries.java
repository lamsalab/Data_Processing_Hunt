
public class Discoveries {
	int year;
	int discoveries;

	public Discoveries(String line) {
		String[] data = line.split(",");
		this.year = Integer.parseInt(data[1]);
		this.discoveries = Integer.parseInt(data[2]);
	}
	public Discoveries(){
		this.year= 0;
		this.discoveries = 0;
	}

	public int getYear() {
		return year;
	}

	public int getDiscoveries() {
		return discoveries;
	}
	
	public Discoveries higherDiscoveries(Discoveries other){
		if (this.discoveries > other.discoveries){
			return this;
		} else 
		{
			return other;
		}
	}

}
