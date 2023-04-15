package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T2_Google_Search_Loop_Array {

    public static void main(String[] args) throws InterruptedException {

        //setup you driver through web drive manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for testing
        WebDriver driver = new ChromeDriver();

        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Mercedes");
        cars.add("Honda");
        cars.add("Lexus");

//iterate through the list of cars and print out the search number for each car
        for (int i = 0; i < cars.size(); i++) {
            //navigate to google home page
            driver.navigate().to("https://www.google.com");

            //maximize the browser
            driver.manage().window().maximize(); //for windows
            //driver.manage().window().fullscreen(); //for mac

            //wait for 2 seconds
            Thread.sleep(2000);

            //enter keyword bmw to search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));

            //click on Google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //whenever you go to a new page or navigate, always use 2-3 seconds wait to pause your script a bit
            Thread.sleep(2000);

            //capture the search results using .getText()
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //System.out.println("Search results: " + result);
            //print out only the number
            String[] arrayResult = result.split(" ");
            System.out.println("For " + cars.get(i) + " the search number is " + arrayResult[1]);

        }//end of loop
        Thread.sleep(1000);
//outside of loop is where you quit/close the driver
        driver.quit();

    }//end of main
}//end of class
