Feature: Search movies in video store

    User wants to search movies in video store

    @SearchMovie
    Scenario: Search movie in VideoStore
        Given the movie available in video store
        When User request to search movie by title
        Then the movie should be found in video store
