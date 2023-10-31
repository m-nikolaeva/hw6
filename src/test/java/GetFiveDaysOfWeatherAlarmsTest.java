import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetFiveDaysOfWeatherAlarmsTest extends AccuweatherAbstractTest{
    @Test
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
