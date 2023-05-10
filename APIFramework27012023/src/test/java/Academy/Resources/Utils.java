package Academy.Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	
	
	public static RequestSpecification req; //With this amends regarding static and if(req==null) loop, now in the logging.txt for every TC logs will be presented, no overwritten responses from TCs
	//If it is not static, in every run req will be null. Now in a single execution it is not null for every TC that we have parameterized
	
	public RequestSpecification requestSpecificationMethod() throws IOException 
	{
		
		if(req==null)
		{
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		
		//Request Spec Builder
		 req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123") //.setBaseUri("https://rahulshettyacademy.com")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		// RequestSpecification req for RequestSpecBuilder()
		return req;
		}
		return req;
	}
	
	
	//Method to extract values from the global.properties
	public String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Academy\\Resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
	
}
