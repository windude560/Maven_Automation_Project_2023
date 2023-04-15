package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_SelectDropDownByClick {

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
        //click on drop down value by using xpath text
        driver.findElement(By.xpath("//*[text()='Apr']")).click();
        //click on empty area to close the dropdown
        driver.findElement(By.xpath("//*[@class='content-area']"));


    }//end of main
}//end of class
