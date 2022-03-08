package surya.automation.api.framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import surya.automation.web.framework.AppConfig;


/**
 * This class is used to handle different type of requests like GET, POST, DELETE, PUT
 * <p>
 * The syntax of RestAssured is like BDD format as belows
 * GIVEN
 * WHEN
 * THEN
 * <p>
 * given() : Provide headers, query and path param.
 * when() : define specific conditions or actions. for e.g. when you get/post/put something, do something else.
 * then() : assert & matcher conditions go here.
 */
public class APIHandler {

    public APIHandler() {
        AppConfig.init();
        RestAssured.baseURI = AppConfig.apiBaseUrl;
        RestAssured.given().auth().oauth2("bearerToken");
        RestAssured.useRelaxedHTTPSValidation();
    }

    public Response getRequest(String endPoint) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get(endPoint)
                .andReturn();
        return response;
    }

    public Response postRequest(String endPoint, Object bodyObject) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .body(bodyObject)
                .post(endPoint)
                .andReturn();
        return response;
    }
}
