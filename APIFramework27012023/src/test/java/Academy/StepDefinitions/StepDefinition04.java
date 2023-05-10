package Academy.StepDefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import Academy.POJO.AddPlace71;
import Academy.POJO.Location;
import Academy.Resources.APIResourcesENUM;
import Academy.Resources.Payload;
import Academy.Resources.TestDataBuild;
import Academy.Resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition04 extends Utils {

	
	//RequestSpecification req = requestSpecificationMethod();
	
	TestDataBuild tdb = new TestDataBuild();
	
	RequestSpecification response01;
	ResponseSpecification res;
	Response response02;
	//String responseString;
	static String placeIdFromResponse;
	
	
	@Given("^The AddPlace Payload is prepared with (.+) and (.+) and (.+)$")
    public void the_addplace_payload_is_prepared_with_and_and(String name, String language, String address) throws Throwable {
        
				AddPlace71 ap = tdb.AddPlacePayload(name, language, address);
		
				
			/*	
				//Request Spec Builder
				RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
				// RequestSpecification req for RequestSpecBuilder()
				*/
		
				/*
				//Response Spec Builder
				 res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
				 */
				
				//RestAssured.baseURI = "https://rahulshettyacademy.com"; //Not needed when we have RequestSpecification req
				
				 response01 = given().log().all().spec(requestSpecificationMethod()) //.spec(req) instead of baseURI, QueryParam, header ContentType
				.body(ap); //Place the java object as a body (json, payload)
				 
				 //requestSpecificationMethod() instead of req
		
    }

    @When("^A user calls the \"([^\"]*)\" with the \"([^\"]*)\" http request$")
    public void a_user_calls_the_something_with_the_something_http_request(String apiResource, String httpMethod) throws Throwable {
        
    	//ENUM class usage. create an object (are) for this Enum calss and call the method are.getResource();
    	APIResourcesENUM are = APIResourcesENUM.valueOf(apiResource);
    	String wantedAPIResource = are.getResource();
    	
    	//Response Spec Builder
		 res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    	
		 //Choose http Method loop
		 if(httpMethod.equalsIgnoreCase("post"))
		 {
    	 response02 = response01.when().post(wantedAPIResource)   //.post("maps/api/place/add/json")
    			.then().log().all().spec(res)//.body("scope", equalTo("APP"))
    			.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response();
    			
    			System.out.println(response02.asString());
		 }
		 else if(httpMethod.equalsIgnoreCase("get"))
		 {
	    	 response02 = response01.when().get(wantedAPIResource)   //.post("maps/api/place/add/json")
	    			.then().log().all().spec(res)//.body("scope", equalTo("APP"))
	    			.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response();
	    			
	    			System.out.println(response02.asString());
		 }
		 else if(httpMethod.equalsIgnoreCase("delete"))
		 {
	    	 response02 = response01.when().delete(wantedAPIResource)   //.post("maps/api/place/add/json")
	    			.then().log().all().spec(res)//.body("scope", equalTo("APP"))
	    			.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response();
	    			
	    			System.out.println(response02.asString());
		 }
		 
    }

    @Then("^Verify that the new places is added successfully$")
    public void verify_that_the_new_places_is_added_successfully() throws Throwable {
        
    }

    @And("^The response body has the \"([^\"]*)\" of \"([^\"]*)\"$")
    public void the_response_body_has_the_something_of_something(String key, String value) throws Throwable {
        
    	String responseString = response02.asString();
    	
    	JsonPath jp01 = new JsonPath(responseString);
    	String keyFromResponseBody = jp01.getString(key);
    	Assert.assertEquals(keyFromResponseBody, value);
    	
    	 placeIdFromResponse = jp01.getString("place_id");
    	 System.out.println(placeIdFromResponse+" attention");
    }

    @And("^The response has the Status code of \"([^\"]*)\"$")
    public void the_response_has_the_status_code_of_something(String statusCode) throws Throwable {
        
    	response02.getStatusCode();
    	int number = Integer.parseInt(statusCode);
    	Assert.assertEquals(response02.getStatusCode(), number);
    	System.out.println(response02.getStatusCode());
    	System.out.println(number);
    	
    }

    @And("^Verify that the place_id corresponds to the (.+) using the \"([^\"]*)\" with the \"([^\"]*)\" http request$")
    public void verify_that_the_placeid_corresponds_to_the_using_the_something_with_the_something_http_request(String name, String apiResource, String httpMethod) throws Throwable {
        

    	
    	response01 = given().log().all().spec(requestSpecificationMethod()).queryParam("place_id", placeIdFromResponse);
    	
    	a_user_calls_the_something_with_the_something_http_request(apiResource, httpMethod); //This is the method from the second step definition
    	//this will go through the loop for that ENUM class and get for us this response02
    	

    	
    	String responseString = response02.asString();
    	JsonPath jp02 = new JsonPath(responseString);
    	String nameFromResponse = jp02.getString("name");
    	//String languageFromResponse = jp02.getString("language");
    	//String addressFromResponse = jp02.getString("address");
    	
    	System.out.println(nameFromResponse);
    	//System.out.println(languageFromResponse);
    	//System.out.println(addressFromResponse);
    	
    	Assert.assertEquals(nameFromResponse, name);
    	//Assert.assertEquals(languageFromResponse, language);
    	//Assert.assertEquals(addressFromResponse, address);
    	
    }
    
    
    
    
    //GetPlace
    @Given("^The AddPlace functionality has been successfully completed$")
    public void the_addplace_functionality_has_been_successfully_completed() throws Throwable {
        
    	response01 = given().log().all().spec(requestSpecificationMethod()).queryParam("place_id", placeIdFromResponse);
    }
    
    @Then("^Verify that the previously added place is retrieved successfully with the according (.+) and (.+) and (.+)$")
    public void verify_that_the_previously_added_place_is_retrieved_successfully_with_the_according_and_and(String name, String language, String address) throws Throwable {
        
    	String responseString = response02.asString();
    	JsonPath jp02 = new JsonPath(responseString);
    	String nameFromResponse = jp02.getString("name");
    	String languageFromResponse = jp02.getString("language");
    	String addressFromResponse = jp02.getString("address");
    	
    	System.out.println(nameFromResponse);
    	System.out.println(languageFromResponse);
    	System.out.println(addressFromResponse);
    	
    	Assert.assertEquals(nameFromResponse, name);
    	Assert.assertEquals(languageFromResponse, language);
    	Assert.assertEquals(addressFromResponse, address);
    }
    
    
    
    //DeletePlace
    @Given("^The AddPlace Payload is prepared$")
    public void the_addplace_payload_is_prepared() throws Throwable {
        
    	response01 = given().log().all().spec(requestSpecificationMethod()) //.spec(req) instead of baseURI, QueryParam, header ContentType
				.body(tdb.deletePlacePayload(placeIdFromResponse)); //.body(Payload.deletePlacePayload(placeIdFromResponse));
    }
    
    @Then("^Verify that the place is deleted successfully$")
    public void verify_that_the_place_is_deleted_successfully() throws Throwable {
        
    }

	
}
