package Cucumber_StepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import Cucumber_Resources.API_calls_Enum;
import Cucumber_Resources.Test_Data;
import Cucumber_Resources.Utils1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinitions extends Utils1 {

	RequestSpecification res;
	ResponseSpecification response;
	Response resp;
	API_calls_Enum apiR;
	Test_Data testD = new Test_Data();
	public static String place_id;

	@Given("Add place Payload with {string}, {string}, {string}")
	public void add_place_payload_with(String name, String address, String language) throws IOException {

	    res = given().spec(requestSpecification()).body(testD.getMeTestDataPayload(name,address,language));
	}



	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String apiResourses, String method) {

		//Constructor will be called with valueOf resourse which you passes from it.
	      apiR = API_calls_Enum.valueOf(apiResourses);
	    System.out.println(apiR.getResoursess());
		response =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();
		if(method.equalsIgnoreCase("POST")) {
			resp = res.when().post(apiR.getResoursess()).then().spec(response).extract().response();
		} else if(method.equalsIgnoreCase("GET")) {
			resp = res.when().post(apiR.getResoursess()).then().spec(response).extract().response();
		}

	}

	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(Integer int1) {
	     assertEquals(resp.getStatusCode(), 200);
		// assertEquals(resp.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
//		String responsss = resp.asString();
//		JsonPath js = new JsonPath(responsss);
	    assertEquals(getJsonPath(resp,keyValue), expectedValue);

	}
	@Then("Verify Place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExpectedName ,String resourse) throws IOException {
	    //Prepare requestSpec
		place_id = getJsonPath(resp,"place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		 user_calls_with_http_request(resourse,"GET");
		 String ActualName = getJsonPath(resp,"name");
		 assertEquals(ActualName,ExpectedName);

	}

	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
	  res= given().spec(requestSpecification()).body(testD.deletePayload(place_id));
	}
	
}
