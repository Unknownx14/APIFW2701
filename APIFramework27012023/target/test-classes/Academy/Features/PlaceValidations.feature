Feature: Validating Place APIs


@AddPlaceTag @RegressionTag
Scenario Outline: Verify the AddPlace functionality is working as expected
	Given The AddPlace Payload is prepared with <name> and <language> and <address>
	When A user calls the "AddPlaceAPI" with the "post" http request
	Then Verify that the new places is added successfully
	And The response body has the "status" of "OK"
	And The response body has the "scope" of "APP"
	And The response has the Status code of "200"
	And Verify that the place_id corresponds to the <name> using the "GetPlaceAPI" with the "get" http request
	
	
Examples:
	|name   	|language   |address   				|
	|AA House   |English   	|Maple road				|
#	|BB House   |English   	|Nelson Mandela Ave		|
	
	
#Scenario Outline: Verify the GetPlace functionality is working as expected
	#Given The AddPlace functionality has been successfully completed
	#When A user calls the "GetPlaceAPI" with the "get" http request
	#And The response has the Status code of "200"
	#Then Verify that the previously added place is retrieved successfully with the according <name> and <language> and <address>

	
	
	#Examples:
	#|name   	|language   |address   				|
	#|AA House   |English   	|Maple road				|
#	|BB House   |English   	|Nelson Mandela Ave		|

@DeletePlaceTag @RegressionTag
Scenario: Verify the DeletePlace functionality is working as expected
	Given The AddPlace Payload is prepared
	When A user calls the "DeletePlaceAPI" with the "post" http request
	Then Verify that the place is deleted successfully
	And The response body has the "status" of "OK"
	And The response has the Status code of "200"