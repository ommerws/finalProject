package Weather;

import java.util.Date;

public class Location {
	private String cityName;
	private String contryCode;
	private long lon,lat;
	private int cityID;
	private Date sunrise, sunset;
	
	public Location(String name, String countryCode)
	{
		setCityName(name);
		setContryCode(countryCode);
	}
	
	public Location(String name)
	{
		setCityName(name);
	}
	
	public Location(int id)
	{
		setCityID(id);
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getContryCode() {
		return contryCode;
	}
	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}
	public long getLon() {
		return lon;
	}
	public void setLon(long lon) {
		this.lon = lon;
	}
	public long getLat() {
		return lat;
	}
	public void setLat(long lat) {
		this.lat = lat;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public Date getSunrise() {
		return sunrise;
	}
	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}
	public Date getSunset() {
		return sunset;
	}
	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}
}
