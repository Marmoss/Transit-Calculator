package com.example.transitcalculator;
/* Program that determines the best price wise option when using NYC transit system */
import java.util.Arrays;

public class TransitCalculator{
    int days;
    int rides;
    String[] rideOption = {"Pay-per-ride", "7-day Unlimited Rides","30-day Unlimited Rides"};
    double[] rideCost = {2.75,33,127};

    //Constructor method
    public TransitCalculator(int numDays, int numRides){
        days = numDays;
        rides = numRides;
    }

    //Returns price per ride using the 7-day card option
    public double unlimited7Price(){
        double sevenDayPurchases = Math.ceil(days / 7.0);
        double total7DayCost = sevenDayPurchases * rideCost[1];

        return total7DayCost / rides;
    }

    //Ride prices for each option
    public double[] getRidePrices(){
        double prices[] = new double[3];
        prices[0] = rideCost[0];
        prices[1] = unlimited7Price();
        prices[2] = rideCost[2] / rides;

        return prices;
    }

    //Returns the best option to buy alongside the cost for each ride
    public String getBestFare(){
        double ridePrices[] = getRidePrices();
        int bestIndex = 0;
        for(int i =0; i<=2; i++){
            if(ridePrices[i] < ridePrices[bestIndex])
                bestIndex = i;
        }
        return "You should get the " +rideOption[bestIndex]+" option at " +ridePrices[bestIndex] +" per ride.";
    }


    public static void main(String[] args){
        int myRides = 54;
        int myDays = 26;

        TransitCalculator calculator = new TransitCalculator(myDays, myRides);
        //  System.out.println(calculator.unlimited7Price());
        System.out.println(calculator.getBestFare());
    }
}