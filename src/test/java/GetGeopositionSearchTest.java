import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetGeopositionSearchTest extends AccuweatherAbstractTest{
    @Test
    void getGeopositionSearchCodeSuccessful(){
        given()
                .param("apikey", getApiKey())
                .param("q", "40.79, 77.86")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/geoposition/search")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    void getGeopositionSearchTypeIsJson(){
        given()
                .param("apikey", getApiKey())
                .param("q", "40.79, 77.86")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/geoposition/search")
                .then()
                .assertThat().contentType(Matchers.containsString("json"));

        given()
                .param("apikey", getApiKey())
                .param("q", "40.79, 77.86")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/geoposition/search")
                .then()
                .assertThat()
                .contentType(equalTo("application/json; charset=utf-8"));
        given().log().body();
    }
}
