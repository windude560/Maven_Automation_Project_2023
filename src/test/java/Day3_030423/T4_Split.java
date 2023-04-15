package Day3_030423;

public class T4_Split {

    public static void main(String[] args) {

        //declare string variable
        String message = "My name is John";
        //print only john from above string
        String[] arrayMessage = message.split(" ");
        System.out.println("Result: " + arrayMessage[0]) ;

    }//end of main
}//end of class
