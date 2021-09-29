package Project;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.Payloadconvertor;
import Utility.URL;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	
	static Response response;
	
	@Test
	public static String Login() throws IOException
	{
		//i am trying to do login
		//what is my first step//URL//body 
		
		String endpointurl = URL.getEndpoint("/user/login");
		
		String Loginpayload = Payloadconvertor.generatepayloadString("Login.json");
		
		//i have to call the method which i want run and fetch the response 
		
	response = 	RestCalls.postRequest(endpointurl, Loginpayload);
	
	//this is to fetcht he response body
	String res = response.getBody().asString();
	
	
	//i want to convert this in to json
	JsonPath jsonres = new JsonPath(res);
	String accesstoken = jsonres.getString("accessToken");
	return accesstoken;
	}

}
