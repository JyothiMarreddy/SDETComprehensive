package restAssuredCapitalAPICode;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CapitalAPI {

	    @Test
	    public void positiveTest_Tallinn() {
	        Response response = RestAssured
	            .given()
	            .when()
	            .get("https://restcountries.com/v3.1/capital/tallinn");

	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertTrue(response.getBody().asString().contains("Estonia"));
	        Assert.assertTrue(response.getBody().asString().contains("Northern Europe"));


	    }

	    @Test
	    public void negativeTest_InvalidCapital() {
	        Response response = RestAssured
	            .given()
	            .when()
	            .get("https://restcountries.com/v3.1/capital/invalidcapital");

	        Assert.assertEquals(response.getStatusCode(), 404);
	    }
	
}
