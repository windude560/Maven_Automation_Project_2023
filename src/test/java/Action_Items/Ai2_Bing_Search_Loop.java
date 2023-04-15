package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Ai2_Bing_Search_Loop {

    public static void main(String[] args) throws InterruptedException {

        //setup you driver through web drive manager
        WebDriverManager.chromedriver().setup();

        //define the chrome driver that you will use for testing
        WebDriver driver = new ChromeDriver();

        //create list of sports
        ArrayList<String> sports = new ArrayList<>();
        sports.add("basketball");
        sports.add("baseball");
        sports.add("soccer");
        sports.add("football");
        sports.add("golf");

        //iterate through the list of sports and print out the search number for each sport
        for (int i = 0; i < sports.size(); i++) {
            //navigate to google home page
            driver.navigate().to("https://www.bing.com/");

            //maximize the browser
            driver.manage().window().maximize(); //for windows
            //driver.manage().window().fullscreen(); //for mac

            //wait for 2 seconds
            Thread.sleep(2000);

            //enter keyword basketball to search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(i));

            //click on Bing search button
            driver.findElement(By.xpath("//*[@name='q']")).submit();

            //wait 2 seconds
            Thread.sleep(2000);

            //capture the search results using .getText()
            String result = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();
            //System.out.println("Search results: " + result);
            /*print out result, Bing sometimes have "About" in front of result number and sometimes doesn't.
            I'm assuming I need an IF statement, but im not sure how to define the variable, so I have arrayResult[0] and
            arrayResult[1] so at least the number is always printed.
             */
            String[] arrayResult = result.split(" ");
            System.out.println("For " + sports.get(i) + " the search number is " + arrayResult[0] + " " + arrayResult[1]);

        }//end of loop
        Thread.sleep(1000);
        //outside of loop is where you quit/close the driver
        driver.quit();


    }//end of main
}//end of class
