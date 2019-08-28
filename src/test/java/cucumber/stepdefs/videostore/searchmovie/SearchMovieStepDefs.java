package cucumber.stepdefs.videostore.searchmovie;

import java.io.FileReader;
import com.fasterxml.jackson.databind.ObjectMapper;

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
import static net.javacrumbs.jsonunit.JsonAssert.*;
import static net.javacrumbs.jsonunit.core.Option.*;
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

    // @When("^User request to add movie \"([^\"]*)\" of genre \"([^\"]*)\" in video
    // store$")
    // public void user_request_to_add_movie_of_genre_in_video_store(String
    // movieName, String genre) throws Exception {

    // String url = baseUrl + port + "/api/v1/movie";

    // JSONObject jsonRequest = (JSONObject) new JSONParser()
    // .parse(new
    // FileReader("src/test/java/cucumber/stepdefs/videostore/addmovie/request.json"));
    // // JSONObject movieDetails = new JSONObject();
    // // movieDetails.put("id", UUID.randomUUID().toString());
    // // movieDetails.put("title", movieName);
    // // movieDetails.put("genre", genre);
    // // JSONObject movieObject = new JSONObject();
    // // movieObject.put("movie", movieDetails);
    // // movieObjectAsString = movieDetails.toString();

    // Response response =
    // given().log().all().contentType("application/json").body(jsonRequest.toString()).when()
    // .post(url).andReturn();

    // response.then().log().all();
    // context.response(response);
    // }

    // @Then("^the movie should be added in video store$")
    // public void the_movie_should_be_added_in_video_store() throws Exception {
    // ObjectMapper mapper = new ObjectMapper();
    // Response response = context.response();
    // String actualResponse = response.body().asString();
    // assertEquals(response.getStatusCode(), 200);

    // JSONObject expectedResponse = (JSONObject) new JSONParser().parse(new
    // FileReader("src/test/java/cucumber/stepdefs/videostore/addmovie/response.json"));
    // //assertEquals(mapper.readTree(expectedResponse.toString()),
    // mapper.readTree(actualResponse));
    // assertThatJson(expectedResponse.toString()).whenIgnoringPaths("id")
    // .isEqualTo(actualResponse);
    // }
}