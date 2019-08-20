Feature: Rental price for new movies

    User wants to check the rental price for a new movies

    @MovieRentalPrice
    Scenario Outline: Rental price for new movies
        Given the new movies are available
        When user request to check the rental for "<movie>" of "<category>"
        Then user get the rental details "<rentperday>" for new movie

        Examples:
            | movie            | category | rentperday |
            | Avengers EndGame | New      | 10.0       |