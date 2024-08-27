package Cucumber_StepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	 @Before("@deletePlace")
		public void runPre_requisitesTests() throws IOException {
			StepDefinitions sd = new StepDefinitions();
			if(StepDefinitions.place_id==null) {
				sd.add_place_payload_with("Dhanraj","Baroda","Gujarathi");
				sd.user_calls_with_http_request("addPlaceAPI","POST");
				sd.verify_place_id_created_maps_to_using("Dhanraj","getPlaceAPI");
			}
		}

}
