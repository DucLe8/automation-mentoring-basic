package core;

import static io.restassured.RestAssured.given;

public class CommonHandle {
    public String getContentType(String url) {
        return given().when().get(url).then().extract()
                .contentType();
    }

    public String getResponseBody(String url) {
        return given().get(url).body().asString();
    }
}
