import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic(value = "Тестирование API https://developer.accuweather.com/accuweather-locations-api/apis")
@Feature(value = "Домашнее задание #6")
public class GetCityNeighborsByLocationkeyTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("CityNeighborsByLocationkeyTest")
    @Description("GET CityNeighborsByLocationkeyCodeSuccessful")
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода Location Key")
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
    @DisplayName("CityNeighborsByLocationkeyTest")
    @Description("GET CityNeighborsByLocationkeyHasGeorgetown")
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода Location Key")
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
    @DisplayName("CityNeighborsByLocationkeyTest")
    @Description("GET CityNeighborsByLocationkeyTypeIsJson")
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода Location Key")
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
