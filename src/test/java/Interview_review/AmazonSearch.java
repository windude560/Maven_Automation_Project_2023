package Interview_review;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Iphone");
        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
        Thread.sleep(2000);
        String result = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println("Search result is: " + result);
    }
}
