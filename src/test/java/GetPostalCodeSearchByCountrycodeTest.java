import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPostalCodeSearchByCountrycodeTest extends AccuweatherAbstractTest{

    @Test
    void getPostalCodeSearchByCountrycodeCodeSuccessful(){
        given()
                .param("apikey", getApiKey())
                .param("q", "YO30 7")
                .pathParam("countryCode", "GB")
                .when()
                .get(getBaseUrl() + "/locations/v1/postalcodes/{countryCode}/search")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    void getPostalCodeSearchByCountrycodeHasYork(){
        given()
                .param("apikey", getApiKey())
                .param("q", "YO30 7")
                .pathParam("countryCode", "GB")
                .when()
                .get(getBaseUrl() + "/locations/v1/postalcodes/{countryCode}/search")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(2000L))
                .assertThat()
                .body("[0].LocalizedName", equalTo("York"));
    }

    @Test
    void getPostalCodeSearchByCountrycodeTypeIsJson(){
        given()
                .param("apikey", getApiKey())
                .param("q", "YO30 7")
                .pathParam("countryCode", "GB")
                .when()
                .get(getBaseUrl() + "/locations/v1/postalcodes/{countryCode}/search")
                .then()
                .assertThat().contentType(Matchers.containsString("json"));
    }
}
