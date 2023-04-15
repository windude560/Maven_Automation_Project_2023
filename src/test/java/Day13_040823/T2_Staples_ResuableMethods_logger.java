package Day13_040823;

import Reusables.ReusableAnnotations;
import Reusables.ReusableMethods;
import Reusables.ReusableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class T2_Staples_ResuableMethods_logger extends ReusableAnnotations {


    @Test(priority = 1)
    public void SearchForKeyWordOnStaple() {
        logger.log(LogStatus.INFO, "Navigate to Staples home page");
        //navigate to staples home page
        driver.navigate().to("https://www.staples.com/");
        //type on search field
        ReusableMethods_Loggers.sendKeysMethod(driver, "//*[@id='searchInput']", "iphone", logger, " Search Field");
        //click on the search icon
        ReusableMethods_Loggers.clickMethod(driver, "//*[@class='search-bar-input__searchIcon']", logger, " Search Button");

    }//end of test 1

    @Test(priority = 2)
    public void captureTextForIphoneOnStaples() throws InterruptedException {
        //click on first image by index
        ReusableMethods_Loggers.clickMethodByIndex(driver, "//*[@class='standard-tile__image standard-tile__image_hover']", 0, logger, "Iphone Image");

        //click on add to the cart button
        ReusableMethods_Loggers.clickMethodByIndex(driver, "//*[@id='ctaButton']", 0, logger, "Add to cart");

        //capture the starting price and print it out
        Thread.sleep(3000);
        String result = ReusableMethods_Loggers.captureTextMethod(driver, "//*[contains(text(),'starting at')]", logger, "Starting Price");
        System.out.println("Iphone result is " + result);
        logger.log(LogStatus.INFO, "Iphone result is " + result);
    }//end of test 2

}//end of class
