
public class Olympic {
	String country;
	String symbols;
	int totalMedals;
	int goldMedal;
	int silverMedal;
	int bronzeMedal;

	public Olympic(String line) {
		String[] data = line.split(",");
		this.country = data[0];
		this.symbols = data[1];
		this.totalMedals = Integer.parseInt(data[2]);
		this.goldMedal = Integer.parseInt(data[3]);
		this.silverMedal = Integer.parseInt(data[4]);
	}
	
	public Olympic(){
		this.totalMedals= 0;
	}

	public String getCountry() {
		return country;
	}
	
	public int getTotalMedal() {
		return totalMedals;
	}

	public int getGoldMedal() {
		return goldMedal;
	}
	public String getSymbol(){
		return symbols;
	}
	
	public boolean checkSymbol(){
		if (this.symbols.equals("")){
			return true;
		}
		return false;
	}
	
	public Olympic checkTotalMedal(Olympic other) {
		if (this.totalMedals > other.totalMedals) {
			return this;
		} else {
			return other;
		}
	}
}
