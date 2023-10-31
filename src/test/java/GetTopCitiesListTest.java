import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetTopCitiesListTest extends AccuweatherAbstractTest{

    @Test
    void getTopCitiesListCodeSuccessful(){
        given()
                .param("apikey", getApiKey())
                .pathParam("group", 50)
                .when()
                .get(getBaseUrl() + "/locations/v1/topcities/{group}")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    void getTopCitiesListHasSantiago(){
        given()
                .param("apikey", getApiKey())
                .pathParam("group", 50)
                .when()
                .get(getBaseUrl() + "/locations/v1/topcities/{group}")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .assertThat()
                .body("[2].LocalizedName", equalTo("Santiago"));
    }
}
