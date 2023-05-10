package Academy.StepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

	
	StepDefinition04 sd04 = new StepDefinition04();
	
	@Before("@DeletePlaceTag")
	public void beforeScenario() throws Throwable
	{
		
		//Here we need a code for getting a placeID
		//And Execute this code only when a placeID is null
		
		//So, we are gonna call a method(s) from the StepDefinition04 that will do all the things that we need for this DeletePlaceAPI
		
		//If a variable is static, we can call it class.variable (StepDefinition04.placeIdFromResponse), if not static then object.variable
		//Here since it is static we can do both ways
		if(sd04.placeIdFromResponse==null)
		{
			sd04.the_addplace_payload_is_prepared_with_and_and("Jovan", "French", "Nelson Mandela avenue 101");
			sd04.a_user_calls_the_something_with_the_something_http_request("AddPlaceAPI", "post");
			sd04.the_response_body_has_the_something_of_something("status", "OK");
		}
		
	}
	
}
