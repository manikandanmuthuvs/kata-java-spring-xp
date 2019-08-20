package cucumber.stepdefs.rentmovie;

import static org.junit.Assert.assertThat;

import java.util.UUID;

import com.manikandanmuthuv.kata.videostore.model.Movie;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.*;

public class RentalMovieStepDefs {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost:";
    RestTemplate restTemplate = new RestTemplate();

    @Given("^the movies are available$")
    public void the_movies_are_available() throws Exception {
        String url = baseUrl + port + "/api/v1/movies";

        Movie movie = Movie.builder().id(UUID.randomUUID()).title("Avengers EndGame").category("Fantasy").build();
        HttpEntity<Movie> request = new HttpEntity<>(movie);
        ResponseEntity<Movie> response = restTemplate.exchange(url, HttpMethod.POST, request, Movie.class);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    }

    @When("^user request to check the availability of movie \"([^\"]*)\" of category \"([^\"]*)\"$")
    public void user_request_to_check_the_availability_of_movie_of_category(String arg1, String arg2) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user get the availability \"([^\"]*)\" of movie$")
    public void user_get_the_availability_of_movie(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
