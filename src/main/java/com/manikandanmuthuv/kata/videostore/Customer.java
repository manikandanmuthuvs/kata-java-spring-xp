package com.manikandanmuthuv.kata.videostore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rental = (Rental) rentals.nextElement();

            frequentRenterPoints += calculateFrequentRenterPoints(rental);

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(calculateRentalCharge(thisAmount, rental)) + "\n";
            totalAmount += calculateRentalCharge(thisAmount, rental);
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private int calculateFrequentRenterPoints(Rental rental) {
        int frequentRenterPoints = 0;
        // add frequent renter points
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private double calculateRentalCharge(double thisAmount, Rental each) {
        // determine amount for each line
        switch (each.getMovie().getPriceCode()) {
        case Movie.REGULAR:
            thisAmount += 2;
            if (each.getDaysRented() > 2)
                thisAmount += (each.getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            thisAmount += each.getDaysRented() * 3;
            break;
        case Movie.CHILDREN:
            thisAmount += 1.5;
            if (each.getDaysRented() > 3)
                thisAmount += (each.getDaysRented() - 3) * 1.5;
            break;
        }
        return thisAmount;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }
}