Feature: Add movies in video store

    User wants to add movies in video store

    @AddMovie
    Scenario Outline: Add movie in VideoStore
        When User request to add movie "<movie>" in video store
        Then the movie should be added in video store

        Examples:
        | movie | 
        | Avenger's Endgame  | 