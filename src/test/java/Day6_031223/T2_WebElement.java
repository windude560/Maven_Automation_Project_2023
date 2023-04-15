package Day6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_WebElement {

    public static void main(String[] args) throws InterruptedException {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //add maximize for windows
        options.addArguments("start-maximized");
        //add --kiosk for mac
        //options.addArguments("--kiosk");
        //add incognito mode to option
        options.addArguments("incognito");
        //add options to run your driver on the background(headless)
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com/");

        Thread.sleep(1000);

        //clear the auto-populated date from purchase price
        WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
        pPrice.clear();
        //enter new purchase price
        pPrice.sendKeys("250000");

        //click on calculate
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        Thread.sleep(2000);

        //if you want you use findElements as a web element variable, you need to store it as an Array List
        //capture the monthly payment & total 360
        ArrayList<WebElement> paymentList = new ArrayList<>(driver.findElements((By.xpath("//*[@style='font-size: 32px']"))));
        //print monthly payment
        String mntPayment = paymentList.get(0).getText();
        System.out.println("Monthly Payment: " + mntPayment);

        //print total 360 payment
        String total360pay = paymentList.get(1).getText();
        System.out.println("Total 360 Payment: " + total360pay);

    }//end of main
}//end of class
