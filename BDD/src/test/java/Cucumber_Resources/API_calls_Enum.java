package Cucumber_Resources;

public enum API_calls_Enum {

	addPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");

	private String apiResourses;

	API_calls_Enum (String apiResourses) {
		this.apiResourses=apiResourses;
	}
	 public String getResoursess() {
		 return apiResourses;
	 }
}
