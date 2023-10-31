import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetAutocompleteTest extends AccuweatherAbstractTest{

    @Test
    void getAutocompleteCodeSuccessful(){
        given()
                .param("apikey", getApiKey())
                .param("q", "tex")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    void getAutocompleteListHasTexas(){
        given()
            .param("apikey", getApiKey())
            .param("q", "tex")
            .when()
            .get(getBaseUrl() + "/locations/v1/cities/autocomplete")
            .then()
            .statusCode(200)
            .time(Matchers.lessThan(2000L))
            .assertThat()
            .body("[4].LocalizedName", equalTo("Texas City"));
    }

    @Test
    void getAutocompleteTypeIsJson(){
        given()
                .param("apikey", getApiKey())
                .param("q", "tex")
                .when()
                .get(getBaseUrl() + "/locations/v1/cities/autocomplete")
                .then()
                .assertThat().contentType(Matchers.containsString("json"));
    }
}
