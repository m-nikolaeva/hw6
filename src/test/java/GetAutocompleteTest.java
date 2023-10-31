import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic(value = "Тестирование API https://developer.accuweather.com/accuweather-locations-api/apis")
@Feature(value = "Домашнее задание #6")
public class GetAutocompleteTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("AutocompleteTest")
    @Description("GET AutocompleteCodeSuccessful")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода AutoComplete")
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
    @DisplayName("AutocompleteTest")
    @Description("GET AutocompleteListHasTexas")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода AutoComplete")
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
    @DisplayName("AutocompleteTest")
    @Description("GET AutocompleteTypeIsJson")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода AutoComplete")
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
