import core.CommonHandle;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTest {

    CommonHandle commonHandle = new CommonHandle();

    @Test
    public void verifyCode() {
        given().when().get("https://jsonplaceholder.typicode.com/users").then().assertThat().statusCode(200);
    }

    @Test
    public void verifyResponseHeader() {
        String expectedContentType = "application/json; charset=utf-8";
        Assert.assertTrue(commonHandle.getContentType("https://jsonplaceholder.typicode.com/users")
                .contains(expectedContentType));
    }

    @Test
    public void verifyResponseBody() {
        JsonPath jp = new JsonPath(commonHandle.getResponseBody("https://jsonplaceholder.typicode.com/users"));
        Assert.assertEquals((int) jp.get("id.size()"), 10);
    }
}
