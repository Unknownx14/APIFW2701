package Academy.Resources;

public enum APIResourcesENUM {

	
	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	
	private String resource;
	
	//Create a Constructor that accepts the same variable as the methods above
	APIResourcesENUM(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
}
