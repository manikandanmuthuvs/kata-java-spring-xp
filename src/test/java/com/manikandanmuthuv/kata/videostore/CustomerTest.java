package com.manikandanmuthuv.kata.videostore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// import com.manikandanmuthuv.kata.refactoredvideostore.Customer;
// import com.manikandanmuthuv.kata.refactoredvideostore.Movie;
// import com.manikandanmuthuv.kata.refactoredvideostore.Rental;

import com.manikandanmuthuv.kata.videostore.service.Customer;
import com.manikandanmuthuv.kata.videostore.service.Movie;
import com.manikandanmuthuv.kata.videostore.service.Rental;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Arthur Dent");
    }

    @Test
    public void statementRentRegularMovieForOneDay() throws Exception {
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, 1));

        String expected = "Rental record for Arthur Dent\n" +
                "\tKiller Klowns from Outer Space\t2.0\n" +
                "Amount owed is 2.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentNewReleaseMovieForOneDay() throws Exception {
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, 1));

        String expected = "Rental record for Arthur Dent\n" +
                "\tAwesome New Release\t3.0\n" +
                "Amount owed is 3.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentChildrensMovieForOneDay() throws Exception {
        customer.addRental(getRental("Cars", Movie.CHILDREN, 1));

        String expected = "Rental record for Arthur Dent\n" +
                "\tCars\t1.5\n" +
                "Amount owed is 1.5\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentChildrensMovieForFourDays() throws Exception {
        customer.addRental(getRental("Cars", Movie.CHILDREN, 4));

        String expected = "Rental record for Arthur Dent\n" +
                "\tCars\t3.0\n" +
                "Amount owed is 3.0\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentRegularMovieForThreeDays() throws Exception {
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, 3));

        String expected = "Rental record for Arthur Dent\n" +
                "\tKiller Klowns from Outer Space\t3.5\n" +
                "Amount owed is 3.5\n"+
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statementRentNewReleaseMovieForTwoDays() throws Exception {
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, 2));

        String expected = "Rental record for Arthur Dent\n" +
                "\tAwesome New Release\t6.0\n" +
                "Amount owed is 6.0\n"+
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void rentOneOfEachTypeForFourDays() throws Exception {
        int daysRented = 4;
        customer.addRental(getRental("Killer Klowns from Outer Space", Movie.REGULAR, daysRented));
        customer.addRental(getRental("Awesome New Release", Movie.NEW_RELEASE, daysRented));
        customer.addRental(getRental("Cars", Movie.CHILDREN, daysRented));

        String expected = "Rental record for Arthur Dent\n" +
                "\tKiller Klowns from Outer Space\t5.0\n" +
                "\tAwesome New Release\t12.0\n" +
                "\tCars\t3.0\n" +
                "Amount owed is 20.0\n"+
                "You earned 4 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    private Rental getRental(String title, int priceCode, int daysRented) {
        Movie movie = new Movie(title, priceCode);
        return new Rental(movie, daysRented);
    }
}