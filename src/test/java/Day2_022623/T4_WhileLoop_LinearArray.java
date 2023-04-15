package Day2_022623;

public class T4_WhileLoop_LinearArray {

    public static void main(String[] args) {
        //create a linear array of countries
        String[] countries = new String[]{"USA","Canada","Bangladesh","Argentina"};
        //create a linear array of areaCode
        int[] areaCode = new int[]{111,222,333,444};

        int i = 0;
        while (i < countries.length){
            System.out.println("Country is " + countries[i] + ", area code is " + areaCode[i]);

            i = i+1;
        }//end of loop
    }//end of main
}//end of java class
