package Weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class readXMLData {
	private HttpURLConnection conn;
	private InputStream in;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;
	private URL url;
	
	public readXMLData(String city, WeatherData wd)
	{
		try {
			url = createURL(city);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initXMLConnection();	
		fillWeatherData();
	}
	
	public readXMLData(int id, WeatherData wd)
	{
		try {
			url = createURL(id);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initXMLConnection();	
		fillWeatherData();
	}
	private URL createURL(Object city) throws MalformedURLException {
		// TODO Auto-generated method stub
		return new URL("http://api.openweathermap.org/data/2.5/weather?q="+city.toString()+"&type=accurate&mode=xml&units=metric&appid=923996da3072923ad97652f6411ae647");
	}
	private void fillWeatherData() {
		doc.getDocumentElement().normalize();
		System.out.println("Root element : "+ doc.getDocumentElement().getNodeName());
		NodeList nList;
		Element eElement;
		System.out.println("-----------------------");
		for(int i = 0 ; i < doc.getDocumentElement().getChildNodes().getLength() ; i++){
			System.out.println(doc.getDocumentElement().getChildNodes().item(i).getNodeName());
			nList = doc.getElementsByTagName(doc.getDocumentElement().getChildNodes().item(i).getNodeName());
			eElement = (Element) nList.item(0);
            for(int j = 0; j<eElement.getAttributes().getLength();j++){
                System.out.println(eElement.getAttributes().item(j));
            }
		}
	}
	private void initXMLConnection() {
		try{
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			in = conn.getInputStream();
			
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse(in);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
