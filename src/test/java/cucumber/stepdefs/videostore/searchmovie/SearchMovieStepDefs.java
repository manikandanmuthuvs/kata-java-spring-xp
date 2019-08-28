package cucumber.stepdefs.videostore.searchmovie;

import java.io.FileReader;
import org.springframework.boot.web.server.LocalServerPort;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.stepdefs.StepDefsContext;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class SearchMovieStepDefs {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost:";

    StepDefsContext context = StepDefsContext.CONTEXT;

    @Given("^the movie available in video store$")
    public void the_movie_available_in_video_store() throws Exception {
        String url = baseUrl + port + "/api/v1/movie";

        JSONObject jsonRequest = (JSONObject) new JSONParser()
                .parse(new FileReader("src/test/java/cucumber/stepdefs/videostore/addmovie/request.to.addmovie.json"));

        Response response = given().log().all().contentType("application/json").body(jsonRequest.toString()).when()
                .post(url).andReturn();

        response.then().log().all();
        context.response(response);
    }
   

    @When("^User request to search movie by title$")
    public void user_request_to_search_movie_by_title() throws Exception {
        String url = baseUrl + port + "/api/v1/movie";

        JSONObject jsonRequest = (JSONObject) new JSONParser()
                .parse(new FileReader("src/test/java/cucumber/stepdefs/videostore/searchmovie/request.to.search.movie.json"));
        Response response = given().log().all().contentType("application/json").queryParam("title",jsonRequest.getAsString("title"))
                .when().get(url).andReturn();

        response.then().log().all();
        context.response(response);
    }

    @Then("^the movie should be found in video store$")
    public void the_movie_should_be_found_in_video_store() throws Exception {
        Response response = context.response();
        String actualResponse = response.body().asString();
        assertEquals(response.getStatusCode(), 200);

        JSONObject expectedResponse = (JSONObject) new JSONParser()
                .parse(new FileReader("src/test/java/cucumber/stepdefs/videostore/searchmovie/response.from.search.movie.json"));

        assertThatJson(expectedResponse.toString()).whenIgnoringPaths("id").isEqualTo(actualResponse);

    }
   
}