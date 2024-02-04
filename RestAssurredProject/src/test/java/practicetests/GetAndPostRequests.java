package practicetests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostRequests {
//@Test
public void testGet() {
baseURI = "https://reqres.in/api";
given().
get("/users?page=2").
then().
statusCode(200).
body("data[4].first_name",equalTo("George")).
log().all();
}
@Test
public void testPost() {
Map<String, Object> map = new HashMap<String,Object>();
JSONObject request = new JSONObject();
request.put("name", "Ankit");
request.put("job", "Tester");
System.out.println(request.toJSONString());
baseURI = "https://reqres.in/api";
given().
header("Conten-Type", "application/json").
body(request.toJSONString()).
when().
post("/users").
then().
statusCode(201).
log().all();
}
}
