package Action_Items;

public class Ai2_Grade_Conditional_Statements {

    public static void main(String[] args) {

        //using multiple conditional statements assign grade to grade range.
        int grade = 83;
        if (grade >= 90 && grade <= 100) { //A grade for 90-100 range
            System.out.println("Grade: A");
        } else if (grade >= 80 && grade <= 89) { //B grade for 80-89 range
            System.out.println("Grade: B");
        } else if (grade >= 70 && grade <= 79) { //C grade for 70-79 range
            System.out.println("Grade: C");
        } else if (grade >= 60 && grade <= 69) { //D grade for 60-69 range
            System.out.println("Grade: D");
        } else if (grade >= 0 && grade <= 59) {  //F grade for 0-59 range
            System.out.println("Grade: F");
        }//end of conditionals

    }//end of main
}//end of class
