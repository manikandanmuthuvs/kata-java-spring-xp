Feature: Rent movies

    User wants to rent movies

    @RentMovie
    Scenario Outline: User checks availablity of movies with genere for rent
        Given the movie "<movie>" is available
        When user request to check the availability of movie with genere "<genere>"of category "<category>"
        Then user get the availability "<available>" of movie

        Examples:
            | movie             | genere   | category | available |
            | Avenger's EndGame | Thriller | New      | Yes       |