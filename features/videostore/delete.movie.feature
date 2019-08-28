Feature: Delete movies in video store

    User wants to delete movies in video store

    @SearchMovie
    Scenario: Delete movie in VideoStore
        Given the movie available in video store
        When User request to delete movie by title
        Then the movie should be deleted in video store
