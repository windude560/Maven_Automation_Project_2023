package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogleHome {

    public static void main(String[] args) throws InterruptedException {

//setup you driver through web drive manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for testing
        WebDriver driver = new ChromeDriver();

//navigate to google home
        driver.navigate().to("https://www.google.com");

//maximize the browser
        driver.manage().window().maximize();  //for windows
//driver.manage().window().fullscreen();  //for mac

//wait for 2 seconds
        Thread.sleep(2000);

//enter keyword bmw to search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("BMW");

//click on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

//wait for 2 seconds, when new page, always wait 2-3 seconds to pause script for a bit
        Thread.sleep(2000);

//capture the search results using .getText()
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
//System.out.println("Search results: " + result);
//print out only the number
        String newResult = result.replace("(", "").replace(")", "");
        System.out.println("New Result: " + newResult);
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number: " + arrayResult[1] + " " + arrayResult[3] + " " + arrayResult[4]);

        Thread.sleep(1000);
//simply close the driver/browser
        driver.quit();

    }//end of main
}//end of class
