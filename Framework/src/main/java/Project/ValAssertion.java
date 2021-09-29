package Project;

import org.testng.Assert;
import org.testng.TestNGUtils;

import Utility.TestUtil;
import io.restassured.response.Response;

public class ValAssertion {
	
	public static void verifystatuscode(Response response, int status)
	{
		Assert.assertEquals(TestUtil.getstatuscode(response), status);
	}

}
