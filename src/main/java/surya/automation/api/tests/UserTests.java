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

public class UserTests {
    private APIHandler apiHandler;

    @BeforeClass
    public void beforeClass() {
        apiHandler = new APIHandler();
    }

    @Test
    public void getUserDetails() {
        Response response = apiHandler.getRequest(EndPoints.GET_ALL_USERS);
        List<User> listOfUsers = response.jsonPath().getList("data", User.class);
        for (User user : listOfUsers) {
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getEmail());
            System.out.println(user.getAvatar());
        }
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status Code verification.");
//        User[]  listOfUsers = apiHandler.getRequest(EndPoints.GET_ALL_USERS).as(User[].class);
    }
}
