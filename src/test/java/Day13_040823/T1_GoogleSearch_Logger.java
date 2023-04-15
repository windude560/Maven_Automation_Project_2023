package Day13_040823;

import Reusables.ReusableAnnotations;
import Reusables.ReusableMethods_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T1_GoogleSearch_Logger extends ReusableAnnotations {

    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void defineReport(){
        reports = new ExtentReports("src/main/java/HTML_Report/automationReport.html",true);
    }//end of before suite
    @Test(priority = 1)
    public void searchForCricket() {
        //give a name to the test
        logger = reports.startTest("Search for Cricket");
        //navigate to google home
        logger.log(LogStatus.INFO,"Navigate to Google Home page");
        driver.navigate().to("https://www.google.com");
        //type the word cricket on search field
        ReusableMethods_Loggers.sendKeysMethod(driver,"//*[@name='q']","Cricket",logger,"Search Field");
        //hit submit on google search
        ReusableMethods_Loggers.submitMethod(driver,"//*[@name='btnK']",logger,"Google Search Button");

    }//end of test 1

    @Test(priority = 2)
    public void printOutSearchNumber() {
        logger = reports.startTest("Print Search Number For Cricket");
        //capture the search result
        String result = ReusableMethods_Loggers.captureTextMethod(driver,"//*[@id='result-stats']",logger,"Search result");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number for cricket: " + arrayResult[1]);
        logger.log(LogStatus.INFO,"Search number for cricket: " + arrayResult[1]);

    }//end of test 2

    @AfterSuite
    public void writeBacktoReport(){
        reports.endTest(logger);
        reports.flush();

    }//end of after suite

}//end of class
