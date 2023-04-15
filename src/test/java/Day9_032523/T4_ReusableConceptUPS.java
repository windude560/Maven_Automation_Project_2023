package Day9_032523;

import Reusables.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T4_ReusableConceptUPS {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to ups
        driver.navigate().to("https://www.ups.com/us");

        //declare the explicit wait command
        WebDriverWait wait = new WebDriverWait(driver,20);

        //click on shipping
        //your explicit wait condition replaces your driver.findElement(s)
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mainNavDropdown1']"))).click();
        ReusableMethods.clickMethod(driver,"//*[@id='mainNavDropdown1']","shipping link");

        //click on Schedule a pick up
        //when you see element not interactable exception then you have to use Thread.sleep for few seconds before
        Thread.sleep(2000);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Schedule a Pickup']"))).click();
        ReusableMethods.clickMethod(driver,"//*[text()='Schedule a Pickup']","Schedule a pick up");

        //click on Freight
        ReusableMethods.clickMethod(driver,"//*[text()='Freight']","Freight");

        //enter a tracking number on the box
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='tracknumlist']"))).sendKeys("12345666");

    }//end of main
}//end of class
