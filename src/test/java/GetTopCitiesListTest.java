import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic(value = "Тестирование API https://developer.accuweather.com/accuweather-locations-api/apis")
@Feature(value = "Домашнее задание #6")
public class GetTopCitiesListTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("TopCitiesListTest")
    @Description("GET TopCitiesListCodeSuccessful")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода List")
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
    @DisplayName("TopCitiesListTest")
    @Description("GET TopCitiesListHasSantiago")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода List")
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
