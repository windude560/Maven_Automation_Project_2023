package Day9_032523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class T2_ImplicitWait {

    public static void main(String[] args) {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //add incognito mode to option
        options.addArguments("incognito");
        //add options to run your driver on the background(headless)
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //declare your implicit wait statement
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //set maximize for windows
        driver.manage().window().maximize();

        //navigate to usps
        driver.navigate().to("https://www.usps.com/");

        //declare and define the mouse action
        Actions mouseAction = new Actions(driver);

        //hover to send tab to open up submodules/functionalities
        try{
            WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            mouseAction.moveToElement(sendTab).perform();
            System.out.println("Successfully hover send tab");
        } catch (Exception e) {
            System.out.println("Unable to hover to Send Tab: " + e);
        }//end of send tab exception

        //click on Tracking using mouse click
        try{
            WebElement trackingLink = driver.findElements(By.xpath("//*[text()='Tracking']")).get(0);
            mouseAction.moveToElement(trackingLink).click().perform();
            System.out.println("Successfully click on Tracking");
        } catch (Exception e) {
            System.out.println("Unable to click on Tracking: " + e);
        }//end of tracking exception


        //type on Tracking Field using mouse click
        try{
            WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
            mouseAction.moveToElement(trackingField).click().sendKeys("12345678").perform();
            System.out.println("Successfully type in tracking field");
        } catch (Exception e) {
            System.out.println("Unable to type on Tracking Input: " + e);
        }//end of tracking input exception

        driver.quit();

    }//end of main
}//end of class
