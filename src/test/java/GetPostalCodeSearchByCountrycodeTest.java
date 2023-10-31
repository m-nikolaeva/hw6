import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic(value = "Тестирование API https://developer.accuweather.com/accuweather-locations-api/apis")
@Feature(value = "Домашнее задание #6")
public class GetPostalCodeSearchByCountrycodeTest extends AccuweatherAbstractTest{

    @Test
    @DisplayName("PostalCodeSearchByCountryСodeTest")
    @Description("GET PostalCodeSearchByCountrycodeCodeSuccessful")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода Text Search")
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
    @DisplayName("PostalCodeSearchByCountryСodeTest")
    @Description("GET PostalCodeSearchByCountrycodeHasYork")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода Text Search")
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
    @DisplayName("PostalCodeSearchByCountryСodeTest")
    @Description("GET PostalCodeSearchByCountrycodeTypeIsJson")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода Text Search")
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
