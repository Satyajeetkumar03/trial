package Util;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class APIUtil {
    static Response response;
    public static Response performPostRequest(String baseURI, String endpoint, String authToken, JSONObject requestBody) {
        return response =given()
                .baseUri(baseURI)
                .header("Authorization", "Bearer " + authToken)
                .body(requestBody.toJSONString())
                .when()
                .post(endpoint);
    }

    public static Response performGetRequest(String baseURI, String endpoint, String authToken) {
        return given()
                .baseUri(baseURI)
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get(endpoint);
    }

    public static Response performPatchRequest(String baseURI, String endpoint, String authToken, JSONObject requestBody) {
        return response= given()
                .baseUri(baseURI)
                .header("Authorization", "Bearer " + authToken)
                .body(requestBody.toJSONString())
                .when()
                .patch(endpoint);
    }

    public static Response performDeleteRequest(String baseURI, String endpoint, String authToken) {
        return response= given()
                .baseUri(baseURI)
                .header("Authorization", "Bearer " + authToken)
                .when()
                .delete(endpoint);
    }
}


