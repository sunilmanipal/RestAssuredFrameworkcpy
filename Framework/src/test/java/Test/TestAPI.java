package Test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project.BaseTest;
import Project.RestCalls;
import Project.ValAssertion;
import Utility.TestUtil;
import Utility.URL;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPI {
	public String accesstoken;
	public String id;
	Response response;
	@BeforeTest
	public void setup() throws IOException
	{
		accesstoken =BaseTest.Login();
		System.out.println(accesstoken);
	}
	
	@Test(priority=0)
	public void getalluser()
	{
		//what should i do here
		String endpointurl = URL.getEndpoint("/user");
		
		response = RestCalls.getRequestwithheader(endpointurl, accesstoken);
		
		//what was next step
		String res = TestUtil.getresponsestring(response);
		JsonPath jsonres = TestUtil.jsonparser(res);
		
		 id = jsonres.getString("users[2]._id");
		 System.out.println(id);
		 ValAssertion.verifystatuscode(response, 200);		
	}

	@Test(dependsOnMethods="getalluser")
    public void deleteuser()
    {
        String formedURL = URL.getEndpoint("/user/" + id);
        response = RestCalls.DeleteRequestwithheader(formedURL, accesstoken);
        
        String res = TestUtil.getresponsestring(response);
        
        System.out.println(res);
        
        //JsonPath jsonres = TestUtil.getJsonResponse(res);
        
        //DeleteID = jsonres.getString("users[2]._id");
        //System.out.println(DeleteID);    
        
        ValAssertion.verifystatuscode(response, 200);
    }
}
