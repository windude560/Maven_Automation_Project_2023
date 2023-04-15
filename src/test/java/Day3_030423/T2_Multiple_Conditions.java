package Day3_030423;

public class T2_Multiple_Conditions {

    public static void main(String[] args) {

        //using multiple conditional statements verify when A+B > C & A+B == C
        int a = 4;
        int b = 2;
        int c = 13;

        if(a+b >c){
            System.out.println("a+b is greater than c");
        } else if (a+b < c) {
            System.out.println("a and b is less than c");
        }else if (a+b == c){
            //when comparing 2 values it will always be == double equal sign
            System.out.println("a and b equals to c");
        }//end of conditionals

    }//end of main
}//end of class
