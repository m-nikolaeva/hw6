import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic(value = "Тестирование API https://developer.accuweather.com/accuweather-locations-api/apis")
@Feature(value = "Домашнее задание #6")
public class GetGeopositionSearchTest extends AccuweatherAbstractTest{
    @Test
    @DisplayName("GeopositionSearchTest")
    @Description("GET GeopositionSearchCodeSuccessful")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода Geoposition")
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
    @DisplayName("GeopositionSearchTest")
    @Description("GET GeopositionSearchTypeIsJson")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода Geoposition")
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
