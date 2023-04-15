package Day14_040923;

import Reusables.ReusableAnnotations;
import Reusables.ReusableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T1_Staples_XpathIndex extends ReusableAnnotations {


    @Test(priority = 1)
    public void SearchForKeyWordOnStaple() throws InterruptedException {
        logger.log(LogStatus.INFO, "Navigate to Staples home page");
        //navigate to staples home page
        driver.navigate().to("https://www.staples.com/");
        //type on search field
        ReusableMethods_Loggers.sendKeysMethod(driver, "//*[@id='searchInput']", "iphone", logger, " Search Field");
        //click on the search icon
        ReusableMethods_Loggers.clickMethod(driver, "//*[@class='search-bar-input__searchIcon']", logger, " Search Button");
        //click on third image by xpath index
        Thread.sleep(3000);
        ReusableMethods_Loggers.clickMethod(driver,"(//*[@class='standard-tile__image standard-tile__image_hover'])[3]",logger,"Result picture");
        Thread.sleep(2000);

    }//end of test 1


}//end of class
