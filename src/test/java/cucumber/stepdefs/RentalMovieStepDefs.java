package cucumber.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RentalMovieStepDefs {
    @Given("^the new movies are available$")
    public void the_new_movies_are_available() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^user request to check the rental for \"([^\"]*)\" of \"([^\"]*)\"$")
    public void user_request_to_check_the_rental_for_of(String movie, String category) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^user get the rental details \"([^\"]*)\" for new movie$")
    public void user_get_the_rental_details_for_new_movie(String rentDetails) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
