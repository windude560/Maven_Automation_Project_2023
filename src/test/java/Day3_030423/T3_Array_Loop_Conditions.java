package Day3_030423;

import java.util.ArrayList;

public class T3_Array_Loop_Conditions {

    public static void main(String[] args) {

        /*
        iterate through list of fruits using ArrayList
        but only print when fruit is grape or apple
         */

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("strawberry");
        fruits.add("grape");

        for (int i = 0; i < fruits.size(); i++) {
      /*      if(fruits.get(i) == "apple"){
                System.out.println("fruit: " + fruits.get(i));
            } else if(fruits.get(i) == "grape"){
                System.out.println("fruit: " + fruits.get(i));
            }//end of conditions
            */
        //using the OR operator
        if (fruits.get(i) == "apple" || fruits.get(i) == "grape") {
            System.out.println(" fruit: " + fruits.get(i));
        }//end of conditions

    }//end of loop

    }//end of main
}//end of class
