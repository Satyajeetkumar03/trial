import Util.APIUtil;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

public class GoRest2 {
    public static String baseURI = "https://gorest.co.in";
    public static String authToken = "b6a35233b6ccd6670029335ffafcbd99dcfa8d80bde9612d1a2c302a2db5297b";
    @Test
    void testPost() {
        JSONObject obj = new JSONObject();
        obj.put("name", "Aagam Dutta IV");
        obj.put("email", "aagam_iv_dutta@little-corwin.example");
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
    void testDelete() {
        JSONObject obj = new JSONObject();
        obj.put("id", 6140486);
        obj.put("name", "Mani Nair");
        obj.put("email", "mani_nair@fay.test");
        obj.put("gender", "female");
        obj.put("status", "inactive");

        APIUtil.performDeleteRequest(baseURI, "/public/v2/users/6140486", authToken)
                .then()
                .statusCode(204)
                .log().all();
    }

    @Test
    void testGet1() {

        APIUtil.performGetRequest(baseURI, "/public/v2/users/6140486", authToken)
                .then()
                .statusCode(404)
                .log().all();
    }
}
