package Weather;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestXML {

public static void main(String argv[]) {

    try {

		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London&mode=xml&units=metric&appid=923996da3072923ad97652f6411ae647");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		InputStream in = conn.getInputStream();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(in);
				
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
		
		/*for(int i=0; i<nList.getLength();i++){
			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element :" + nList.item(i).getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nList.item(i);
                for(int j = 0; j<eElement.getAttributes().getLength();j++){
	                System.out.println(eElement.getAttributes().item(j));
                }
            }
		}*/
		
    } catch (Exception e) {	
    	e.printStackTrace();
    }
  }

}