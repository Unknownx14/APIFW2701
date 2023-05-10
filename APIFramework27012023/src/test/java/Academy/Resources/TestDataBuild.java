package Academy.Resources;

import java.util.ArrayList;
import java.util.List;

import Academy.POJO.AddPlace71;
import Academy.POJO.Location;

public class TestDataBuild {

	
	public AddPlace71 AddPlacePayload(String name, String language, String address)
	{
		//This is the serialization process for creating a json file from a java object
		AddPlace71 ap = new AddPlace71();
		ap.setAccuracy(50);
		ap.setName(name);
		ap.setLanguage(language);
		ap.setAddress(address);
		//ap.setName("RSA");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("https://www.rahulshettyacademy.com");
		//ap.setLanguage("French-IN");
		
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		ap.setTypes(myList);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		ap.setLocation(l);
		return ap;
	}
	
	
	public String deletePlacePayload(String placeId)
	{
		String body = "{\r\n"
				+ "\"place_id\": \""+placeId+"\"\r\n"
				+ "}";
		return body;
	}
	
}
