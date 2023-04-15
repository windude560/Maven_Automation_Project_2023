package Action_Items;

import java.util.ArrayList;

public class Ai1_ArrayList_Country_countryCode {
    public static void main(String[] args) {

        //create an ArrayList of countries
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("India");
        country.add("Bangladesh");
        country.add("China");
        country.add("Russia");

        //create an Integer ArrayList of countryCode
        ArrayList <Integer> countryCode = new ArrayList<>();
        countryCode.add(1);
        countryCode.add(91);
        countryCode.add(880);
        countryCode.add(86);
        countryCode.add(7);

        //print country and country code using for loop
        for (int i = 0; i < country.size(); i++){
            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));
        }//end of loop

    }//end of main
}//end of class
