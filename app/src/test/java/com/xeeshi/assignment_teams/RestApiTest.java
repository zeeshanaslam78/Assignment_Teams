package com.xeeshi.assignment_teams;

import com.xeeshi.assignment_teams.data.network.model.Team;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RestApiTest {

    private String BASE_URL = "https://s3-eu-west-1.amazonaws.com";
    private String TEAM_JSON = "/forza-assignment/android/teams.json";

    @Test
    public void makeSureApiIsUp() {
        RestAssured.given().when().get(BASE_URL+TEAM_JSON)
                .then().assertThat().statusCode(200);
    }

    @Test
    public void checkFirstObjectIsSame() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
        Response response = request.get(TEAM_JSON);
        ResponseBody responseBody = response.getBody();
        Team[] teamList = responseBody.as(Team[].class);

        //System.out.println("Teams " + teamList.toString());
        //System.out.println("Name " + teamList[0].getName());

        Assert.assertEquals("Arsenal FC", teamList[0].getName());
        Assert.assertEquals(false, teamList[0].getNational());
        Assert.assertEquals("England", teamList[0].getCountryName());

    }


}