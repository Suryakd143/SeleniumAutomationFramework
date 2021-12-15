package surya.automation.api.tests;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import surya.automation.api.framework.APIHandler;
import surya.automation.api.framework.EndPoints;
import surya.automation.api.modals.User;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserTests {
    private APIHandler apiHandler;

    @BeforeClass
    public void beforeClass() {
        apiHandler = new APIHandler();
    }

    @Test(priority = 1)
    public void getUserDetailsAndPrintResponseAndLogs() {
        Response response = apiHandler.getRequest(EndPoints.GET_ALL_USERS);
        List<User> listOfUsers = response.jsonPath().getList("data", User.class);
        System.out.println(listOfUsers.get(0).getFirstName());
        response.then().log().body();
        response.then().log().cookies();
        response.then().log().headers();
    }

    @Test(priority = 1)
    public void getUserDetailsAndValidateStatusCode() {
        Response response = apiHandler.getRequest(EndPoints.GET_ALL_USERS);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status Code verification.");
    }

    @Test(priority = 1)
    public void getUserDetailsAndValidateTheResponseTime() {
        Response response = apiHandler.getRequest(EndPoints.GET_ALL_USERS);
        System.out.println("RESPONSE TIME : " + response.timeIn(TimeUnit.SECONDS) + " Seconds");
    }

    @Test(priority = 1)
    public void getUserDetailsAndExtractASpecificAttributeValue() {
        Response response = apiHandler.getRequest(EndPoints.GET_ALL_USERS);
        Integer totalPages = response.then().extract().body().jsonPath().get("total_pages");
        System.out.println("TOTAL NUMBER OF PAGES : " + totalPages);
    }

    @Test(priority = 1)
    public void createUserAndValidateTheStatusCode() {
        User userObj = new User();
        userObj.setFirstName("Surya");
        userObj.setLastName("Dhal");
        userObj.setEmail("surya.dhal@gmail.com");
        userObj.setId(143);
        Response response = apiHandler.postRequest(EndPoints.POST_CREATE_USER,userObj);
        response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

}
