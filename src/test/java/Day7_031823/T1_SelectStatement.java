package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectStatement {

    public static void main(String[] args) throws InterruptedException {

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

        driver.navigate().to("https://www.mortgagecalculator.org");

        //wait 2 seconds
        Thread.sleep(2000);

        //select the start month as April from the dropdown using select function
        //store the start month locator as a WebElement
        WebElement strMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //call select function to store the dropdown locator
        Select startMonthDropDown = new Select(strMonth);
        //select by visible text
        startMonthDropDown.selectByVisibleText("Apr");
        //select by value
        //startMonthDropDown.selectByValue("4");
        //select by index
        //startMonthDropDown.selectByIndex(3);


    }//end of main
}//end of class
