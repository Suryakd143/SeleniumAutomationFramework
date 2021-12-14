package surya.automation.api.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import surya.automation.web.framework.AppConfig;

public class APIHandler {

    public APIHandler() {
        AppConfig.init();
        RestAssured.baseURI = AppConfig.apiBaseUrl;
        RestAssured.useRelaxedHTTPSValidation();
    }

    public Response getRequest(String endPoint) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(endPoint)
                .andReturn();
        return response;
    }

    public Response postRequest(String endPoint) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(endPoint)
                .andReturn();
        return response;
    }
}
