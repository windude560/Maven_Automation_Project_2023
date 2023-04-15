package Interview_review;

import java.util.ArrayList;

public class InterviewArrayList {

    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Bronx");

        for (int i = 0; i < cities.size();i++){
            if (cities.get(i) == "Brooklyn" || cities.get(i) == "Queens"){
                System.out.println("Cities: " + cities.get(i));
            }
        }
    }
}
