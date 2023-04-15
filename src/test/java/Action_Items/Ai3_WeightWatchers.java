package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;

public class Ai3_WeightWatchers {

    public static void main(String[] args) throws InterruptedException {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //add maximize for windows
        //add incognito mode to option
        options.addArguments("start-maximized", "incognito");
        //add options to run your driver on the background(headless)
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11219");
        zipcode.add("11218");
        zipcode.add("11217");

        for (int i = 0; i < zipcode.size(); i++) {

            //navigate to weightwatchers.com
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");

            Thread.sleep(1000);


            //click on find a workshop on the top right
            driver.findElement(By.xpath("//*[contains(text(),'Find a Workshop')]")).click();

            Thread.sleep(1000);

            //clear field and enter zip code and store as a WebElement variable
            WebElement zipCode = driver.findElement(By.xpath("//*[@id='location-search']"));
            zipCode.clear();
            zipCode.sendKeys(zipcode.get(i));
            zipCode.submit();

            Thread.sleep(1000);

            //create list of studio links and IF conditional statement to click on different links
            ArrayList<WebElement> studioLink = new ArrayList<>(driver.findElements(By.xpath("//*[contains(text(),'WW Studio @ ')]")));

            if (i == 0) {
                studioLink.get(1).click();
            } else if (i == 1) {
                studioLink.get(2).click();
            } else if (i == 2) {
                studioLink.get(0).click();
            }// end of conditional

            //Get address and print
            String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
            String[] result = address.split("In-Person");
            System.out.println(("Address is " + result[0]));

            //use JavascriptExecutor go to Studio Workshop schedule
            WebElement schedule = driver.findElement(By.xpath("//*[@class='title-bEfSM']"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView(true);", schedule);
            //capture schedule table and print
            String sched = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(0).getText();;

            System.out.println(" Schedule is " + sched);

            Thread.sleep(1000);

        }

        driver.quit();

    }//end of main
}//end of class
