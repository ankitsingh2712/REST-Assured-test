package practicetests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoapRequest {
@Test
public void SoapRequest() throws IOException {

File file = new File("./SoapRequest/Add.xml");
if(file.exists())
System.out.println("**Request file found**");
FileInputStream fileInputStream = new FileInputStream(file);
String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
baseURI = "http://www.dneonline.com";
given().
contentType("text/xml").
accept(ContentType.XML).
body(requestBody).
when().
post("calculator.asmx").
then().
statusCode(200).
log().all();
}

}
