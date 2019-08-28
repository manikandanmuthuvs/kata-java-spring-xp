package cucumber.stepdefs.videostore.deletemovie;

import java.io.FileReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.web.server.LocalServerPort;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.stepdefs.StepDefsContext;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class DeleteMovieStepDefs {

        @LocalServerPort
        private int port;

        private String baseUrl = "http://localhost:";

        StepDefsContext context = StepDefsContext.CONTEXT;

        @When("^User request to delete movie by title$")
        public void user_request_to_delete_movie_by_title() throws Exception {
                String url = baseUrl + port + "/api/v1/movie";

                JSONObject jsonRequest = (JSONObject) new JSONParser().parse(new FileReader(
                                "src/test/java/cucumber/stepdefs/videostore/deletemovie/request.to.delete.movie.json"));
                Response response = given().log().all().contentType("application/json")
                                .queryParam("title", jsonRequest.getAsString("title")).when().delete(url).andReturn();

                response.then().log().all();
                context.response(response);
        }

        @Then("^the movie should be deleted in video store$")
        public void the_movie_should_be_deleted_in_video_store() throws Exception {
                Response response = context.response();
                String actualResponse = response.body().asString();
                assertEquals(response.getStatusCode(), 200);

                JSONObject expectedResponse = (JSONObject) new JSONParser().parse(new FileReader(
                                "src/test/java/cucumber/stepdefs/videostore/deletemovie/response.from.delete.movie.json"));

                assertThatJson(expectedResponse.toString()).whenIgnoringPaths("id").isEqualTo(actualResponse);
        }
}