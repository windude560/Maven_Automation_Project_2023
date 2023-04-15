package Action_Items;

import Reusables.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AI6_FidelisCare {

    //to make varable global, declare it outside of the annotation methods
    WebDriver driver;

    //create suite method to define chrome driver
    @BeforeSuite
    public void setUpDriver() {
        driver = ReusableMethods.defineChromeDriver();
    }//end of before suite

    //quit the driver
    @AfterSuite
    public void quitSession() {
        driver.quit();
    }//end of after suite

    //@Test 1 navigate to fideliscare and get to dental coverage
    @Test(priority = 1)
    public void searchForDentalCoverage(){
        //navigate to fideliscare.org
        driver.navigate().to("https://www.fideliscare.org/");
        //enter dental coverage on search element on the top right
        ReusableMethods.clickMethodByIndex(driver,"//*[@class='tool dropdown search']",0,"Search Button");
        ReusableMethods.sendKeysMethod(driver, "//*[@class='form-control search-input']", "dental coverage", "Search Field");
        //click on search icon
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='btn btn-primary btn-search']",0, "Search Dental Coverage");
        //capture the search results and print the search number
        String searchResult = ReusableMethods.captureTextMethod(driver,"//*[@class='gsc-result-info']","Search Result");
        String[] result = searchResult.split(" ");
        System.out.println("Search result is: " + result[1]);
        //click on Get Dental Coverage
        ReusableMethods.clickMethodByIndex(driver,"//*[@class='gs-title']",1,"Get Dental Coverage");

    }//end of test 1

    @Test(priority = 2)
    public void signUpForDental() {
        //switch tabs
        ReusableMethods.switchToTabByIndex(driver, 1, "Switch to new tab");
        //Fill out information
        //Fill out first name
        ReusableMethods.sendKeysMethod(driver,"//*[@id='firstName']","John","First Name");
        //Fill out last name
        ReusableMethods.sendKeysMethod(driver,"//*[@id='lastName']","Chen","Last Name");
        //Fill out Zip code
        ReusableMethods.sendKeysMethod(driver,"//*[@id='zipCode']","11219","Zipcode");
        //Select County
        ReusableMethods.dropDownByText(driver,"//*[@id='county']","Kings","County");
        //Fill out Phone number
        ReusableMethods.sendKeysMethod(driver,"//*[@id='phoneNumber']","6468256456","Phone number");
        //Fill out email
        ReusableMethods.sendKeysMethod(driver,"//*[@id='email']","hooverbeenie@gmail.com","Email");
        //click on check box for contact me
        ReusableMethods.clickMethodByIndex(driver,"//*[@for='contactMe']",1,"Check Box");
        //click on contact me
        ReusableMethods.clickMethod(driver,"//*[@type='submit']","Contact Me");
        //Capture the message that contains 'Thank you for your submission.' and print it.
        String result = ReusableMethods.captureTextMethod(driver,"//*[@role='alert']","Thank you message");
        System.out.println(result);
        //close tab
        driver.close();
    }//end of test 2

    @Test(priority = 3)
    public void helpfulHints() throws InterruptedException {
        //switch back to original tab
        ReusableMethods.switchToTabByIndex(driver,0,"Switch back to original tab");
        //click on login
        ReusableMethods.clickMethodByIndex(driver,"//*[@class='tool dropdown login']",0,"Click on login");
        //Need to wait for drop down
        Thread.sleep(2000);
        //click on Member Online Portal
        ReusableMethods.clickMethodByIndex(driver,"//*[@class='link-external']",0,"Member Online Portal");
        //switch to new tab
        ReusableMethods.switchToTabByIndex(driver,1,"Switch to new tab");
        //Capture and print out Helpful Hints
        String hints = ReusableMethods.captureTextMethod(driver,"//*[@class='card']","Helpful hints");
        System.out.println(hints);
        //close tab
        driver.close();

    }//end of test 3

}//end of class
