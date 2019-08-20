Feature: Rent movies

    User wants to rent movies

    @RentMovie
    Scenario Outline: User checks availablity of movies for rent
        Given the movies are available
        When user request to check the availability of movie "<movie>" of category "<category>"
        Then user get the availability "<available>" of movie

        Examples:
            | movie             | category | available |
            | Avenger's EndGame | New      | Yes       |