import io.qameta.allure.*;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic(value = "Тестирование API https://developer.accuweather.com/accuweather-locations-api/apis")
@Feature(value = "Домашнее задание #6")
public class GetFiveDaysOfWeatherAlarmsTest extends AccuweatherAbstractTest{
    @Test
    @DisplayName("FiveDaysOfWeatherAlarmsTest")
    @Description("GET FiveDaysOfWeatherAlarmsCodeSuccessful")
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода: 5 Days of Weather Alarms")
    void getFiveDaysOfWeatherAlarmsCodeSuccessful(){
        given()
                .param("apikey", getApiKey())
                .pathParam("locationKey", "46")
                .when()
                .get(getBaseUrl() + "/alarms/v1/5day/{locationKey}")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    @DisplayName("FiveDaysOfWeatherAlarmsTest")
    @Description("GET FiveDaysOfWeatherAlarmsTypeIsJson")
    @Owner("Николаева Марина")
    @Story(value = "Тестирование метода: 5 Days of Weather Alarms")
    void getFiveDaysOfWeatherAlarmsTypeIsJson(){
        given()
                .param("apikey", getApiKey())
                .pathParam("locationKey", "46")
                .when()
                .get(getBaseUrl() + "/alarms/v1/5day/{locationKey}")
                .then()
                .assertThat().contentType(Matchers.containsString("json"));
    }
}
