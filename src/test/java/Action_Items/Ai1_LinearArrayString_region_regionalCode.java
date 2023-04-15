package Action_Items;

public class Ai1_LinearArrayString_region_regionalCode {

    public static void main(String[] args) {

        //create a linear array of regions
        String[] region = new String[]{"Brooklyn, New York","San Antonio, Texas","Lee County, Florida","Jersey City, New Jersey","Wichita, Kansas"};
        //create a linear array of regionCode
        int[] regionCode = new int[]{718,210,239,201,316};
        //print region with regionCode using while loop
        int i = 0;
        while (i < region.length){
            System.out.println("My region is " + region[i] + ", and my region code is " + regionCode[i]);
            i = i+1;
        }//end of loop

    }//end of main
}//end of class
