package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_Xpath_Contain_Text {
    public static void main(String[] args) throws InterruptedException {

        //set up driver through web driver manager
        WebDriverManager.chromedriver().setup();

//define the chrome driver that you will use for automation test
        WebDriver driver = new ChromeDriver();

//navigate to yahoo home
        driver.navigate().to("https://www.yahoo.com/");

        Thread.sleep(2000);

//using xpath contains click on the mail link by ignoring the white space on the text property for that element

        driver.findElement(By.xpath("//a[contains(text(),'Mail')]")).click();

    }//end of main
}//end of class
