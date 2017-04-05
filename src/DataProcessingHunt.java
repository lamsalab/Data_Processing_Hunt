import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DataProcessingHunt {
	public static void main(String[] args) throws IOException{
		//Air passengers
		Stream<String> passengers = Files.lines(Paths.get("AirPassengers.csv"));
		System.out.println("What is the lowest number of passengers?");
		int minNoOfPassengers= passengers.map(numOfPassengers -> new AirPassengers(numOfPassengers).getPassengers())
				.reduce(Integer.MAX_VALUE,(acc, x) -> Math.min(acc, x), (accl, accr) -> accl + accr);
		System.out.println("> " + minNoOfPassengers);
		System.out.println("(Source: New York State Department of Conservation (ozone data) and the National Weather Service)");
		passengers.close();
		
		Stream<String> year = Files.lines(Paths.get("AirPassengers.csv"));
		System.out.println("How many data-sets exists in 1949?");
		long noOfDataset= year.map(dataSet -> new AirPassengers(dataSet).getYear())
				.filter(x -> x.startsWith("1949")).count();
		System.out.println("> " + noOfDataset);
		System.out.println("Source: New York State Department of Conservation (ozone data) and the National Weather Service");
		year.close();
		
		Stream<String> firstEntry = Files.lines(Paths.get("AirPassengers.csv"));
		System.out.println("What is the first entry in the dataSet?");
		int firstData= firstEntry.map(Passengers -> new AirPassengers(Passengers).getPassengers())
				.findFirst().get();
		System.out.println("> " + firstData);
		System.out.println("Source: New York State Department of Conservation (ozone data) and the National Weather Service");
		firstEntry.close();
		
		//Discoveries
		Stream<String> noOfDiscoveries = Files.lines(Paths.get("discoveries.csv"));
		System.out.println("How many years had zero discoveries?");
		long zeroDiscoveries= noOfDiscoveries.map(discoveries -> new Discoveries(discoveries).getDiscoveries())
				.filter(x -> x.equals(0)).count();
		System.out.println("> " + zeroDiscoveries);
		System.out.println("(The World Almanac and Book of Facts, 1975 Edition, pages 315–318.)");
		noOfDiscoveries.close();
		
		Stream<String> highestDiscovery = Files.lines(Paths.get("discoveries.csv"));
		System.out.println("What is the highest number of discovery that any year had?");
		long highestNoOfDiscoveries = highestDiscovery.map(discoveries -> new Discoveries(discoveries).getDiscoveries())
				.reduce(Integer.MIN_VALUE, (acc, x) -> Math.max(acc,  x),(accl, accr) -> accl + accr);
		System.out.println(highestNoOfDiscoveries);
		System.out.println("(The World Almanac and Book of Facts, 1975 Edition, pages 315–318.)");
		highestDiscovery.close();
		
		Stream<String> moreDiscoveries = Files.lines(Paths.get("discoveries.csv"));
		System.out.println("What year had the highest number of discoveries?");
		int highestDiscoveriesYear = moreDiscoveries.map(discoveries -> new Discoveries(discoveries))
				.reduce(new Discoveries(), (acc, x) -> acc.higherDiscoveries(x)).year;
		System.out.println("> " + highestDiscoveriesYear);
		System.out.println("(The World Almanac and Book of Facts, 1975 Edition, pages 315–318.)");
		moreDiscoveries.close();
		
		//Olympic
		Stream<String> noOfCountriesContainsUnited = Files.lines(Paths.get("Olympic.csv"));
		System.out.println("How many countries' name in the list starts with the letter 'United'?");
		long noOfCountries = noOfCountriesContainsUnited.map(countries -> new Olympic(countries).getCountry())
				.filter(x -> x.contains("United")).count();
		System.out.println("> " + noOfCountries);
		System.out.println("(Source: https://www.theguardian.com/sport/datablog/2012/jun/25/olympic-medal-winner-list-data#data)");
		noOfCountriesContainsUnited.close();
		
		Stream<String> highMedalCount = Files.lines(Paths.get("Olympic.csv"));
		System.out.println("Which country has the highest number of total medals?");
		String country = highMedalCount.map(countries -> new Olympic(countries))
				.reduce(new Olympic(), (acc, x) -> acc.checkTotalMedal(x)).country;
		System.out.println("> " + country);
		highMedalCount.close();

		Stream<String> noSymbols = Files.lines(Paths.get("Olympic.csv"));
		System.out.println("Name one country with no symbol.");
		String symbol = noSymbols.map(countries -> new Olympic(countries))
				.filter(x -> x.checkSymbol()).collect(Collectors.toList()).get(0).country;
		System.out.println("> "+ symbol);
		noSymbols.close();
	}
	
}
