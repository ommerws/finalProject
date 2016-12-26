package Weather;

interface IWeatherDataService{
	public WeatherData WeatherDataService(Location location) throws WeatherDataServiceException ;
	
}
