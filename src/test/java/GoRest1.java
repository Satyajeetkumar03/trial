import Util.APIUtil;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GoRest1{
    public static String baseURI = "https://gorest.co.in";
    public static String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";

    @Test
    void testPost() {
        JSONObject obj = new JSONObject();
        obj.put("id", 1234567);
        obj.put("name", "ABCDEF");
        obj.put("email", "ABCDEF@example.com");
        obj.put("gender", "male");
        obj.put("status", "active");

        APIUtil.performPostRequest(baseURI, "/public/v2/users", authToken, obj)
                .then()
                .statusCode(201)
                .log().all();
    }

    @Test
    void testGet() {

        APIUtil.performGetRequest(baseURI, "/public/v2/users", authToken)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testPatch() {
        JSONObject obj = new JSONObject();
        obj.put("id", 6140489);
        obj.put("name", "Devangana Asan");
        obj.put("email", "devangana_asan@mraz.example");
        obj.put("gender", "female");
        obj.put("status", "active");

        APIUtil.performPatchRequest(baseURI, "/public/v2/users/6140489", authToken, obj)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testDelete() {
        JSONObject obj = new JSONObject();
        obj.put("id", 6140489);
        obj.put("name", "Devangana Asan");
        obj.put("email", "devangana_asan@mraz.example");
        obj.put("gender", "male");
        obj.put("status", "active");

        APIUtil.performDeleteRequest(baseURI, "/public/v2/users/6140489", authToken)
                .then()
                .statusCode(204)
                .log().all();
    }
}
