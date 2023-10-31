import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetCityNeighborsByLocationkeyTest extends AccuweatherAbstractTest{
    @Test
    void getCityNeighborsByLocationkeyCodeSuccessful(){
        given()
                .param("apikey", getApiKey())
                .pathParam("locationKey", "35")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/neighbors/{locationKey}")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    void getCityNeighborsByLocationkeyHasGeorgetown(){
        given()
                .param("apikey", getApiKey())
                .pathParam("locationKey", "35")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/neighbors/{locationKey}")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .assertThat()
                .body("[0].LocalizedName", equalTo("Georgetown"));
    }

    @Test
    void getCityNeighborsByLocationkeyTypeIsJson(){
        given()
                .param("apikey", getApiKey())
                .pathParam("locationKey", "35")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/neighbors/{locationKey}")
                .then()
                .assertThat().contentType(Matchers.containsString("json"));
    }
}
