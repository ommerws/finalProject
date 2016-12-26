package Weather;

public class WeatherData {
	private long temarture, tempMin, tempMax, humidity;
	private Location location;
	
	public WeatherData(String city)
	{
		location = new Location(city);
	}
	
	public WeatherData(int city)
	{
		//send to API
	}
}
