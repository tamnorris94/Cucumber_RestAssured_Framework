package com.nfautomationframework;

public class NumberComparer {

    public static String compareTwoNumbers(String x, String y) {
        //default response
        String response = "One or both x and y are 0 or x is positive but y is negative";
        try {
            Float X = Float.parseFloat(x);
            Float Y = Float.parseFloat(y);
            //If both x and y are greater than 0
            if(X>0) {
                if (Y>0) {
                    response = "Positive";
                }
            }
            //If x is less than 0
            if(X<0){
                response = "Negative";
            }
        }
        catch (NumberFormatException e) {
            response = "One or more of inputs was not an int";
            System.out.println(e);
        }
        return response;
    }
}
