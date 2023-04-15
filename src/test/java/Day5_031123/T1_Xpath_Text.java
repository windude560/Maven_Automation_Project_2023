package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Xpath_Text {

    public static void main(String[] args) throws InterruptedException {

        //set up driver through web driver manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

//navigate to google home
        driver.navigate().to("https://www.google.com/");

        Thread.sleep(2000);

//click on About text link
        driver.findElement(By.xpath("//*[text()='About']")).click();

    }//end of main
}//end of class
