package Action_Items;

import Reusables.ReusableAnnotations;
import Reusables.ReusableMethods_Loggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Ai7_6_to_8_TestCases extends ReusableAnnotations {

    @Test(priority = 1)
    public void AboutUsSummaryOfOperations() throws InterruptedException {
        //navigate to NorthWestern Mutual
        logger.log(LogStatus.INFO,"Navigate to NorthWestern Mutual");
        driver.navigate().to("https://www.northwesternmutual.com/");
        //hover over About us
        ReusableMethods_Loggers.mouseHover(driver,"(//*[@class='nmx-nav-link nmx-nav-link-primary'])[1]",logger,"About us");
        Thread.sleep(2000);
        //click on Our Financial Strength
        ReusableMethods_Loggers.clickMethod(driver,"(//*[@class='nmx-nav-link nmx-nav-link-primary-sub nmx-subnav-item-who-we-are'])[2]",logger,"Our Financial Strength");
        //scroll to Trusts starts with financial strength
        ReusableMethods_Loggers.scrollByElement(driver,"//*[@id='financial-information-financial-planning-1-section-container']",logger,"Financial Strength");
        //click on See our 2022 financial results
        ReusableMethods_Loggers.clickMethod(driver,"//*[@id='financial-information-financial-planning-section-annual-report-cta']",logger,"2022 financial results");
        //scroll to summary of Operations and capture texts/graph
        ReusableMethods_Loggers.scrollByElement(driver,"(//*[@class='sc-gKseQn kkOpWw nmx-h4'])[1]",logger,"Summary of Operations");
        ReusableMethods_Loggers.captureScreen(driver,"Summary", logger);

    }//end of test 1

    @Test(priority = 2)
    public void printOutSearchNumber() {
        //click on NorthWestern Mutual
        ReusableMethods_Loggers.clickMethod(driver,"//*[@class='nmx-header-logo']",logger,"Home page");
        //click on Insurance
        ReusableMethods_Loggers.clickMethod(driver,"//*[@id='react-tabs-2']",logger,"Insurance Tab");
        //capture text
        ReusableMethods_Loggers.captureTextMethod(driver,"//*[@itemprop='description']",logger,"Insurance list");
        //click on Get insurance
        ReusableMethods_Loggers.clickMethod(driver, "//*[@id='home-products-insurance-cta']",logger,"Get Insurance button");
        //scroll down to good match
        ReusableMethods_Loggers.scrollByElement(driver,"//*[@class='sc-jSgvzq fBJyHH nmx-col']", logger, "How to make sure your advisor is a good match");

    }//end of test 2

    @Test(priority = 3)
    public void fillInInfoForHouse() throws InterruptedException {
        //scroll up to what's your biggest financial goal?
        ReusableMethods_Loggers.scrollByElement(driver,"//*[@class='sc-fubCzh gJNMOj nmx-h3 sc-khAkCZ gFqnUE sc-khAkCZ gFqnUE']",logger,"Whats your biggest financial goal?");
        //click on Buy a home
        ReusableMethods_Loggers.clickMethod(driver,"(//*[@class='sc-bYEvvW fZASGy fafa-hero-goal-card-radio-input'])[1]",logger,"Buy a home");
        Thread.sleep(2000);
        //click on Next
        ReusableMethods_Loggers.clickMethod(driver,"//*[@id='in-page-lead-step-1-next-button']",logger,"Next");
        //fill out age,zipcode and annual household income
        ReusableMethods_Loggers.sendKeysMethod(driver,"//*[@name='age']","27",logger,"Age");
        ReusableMethods_Loggers.sendKeysMethod(driver,"//*[@name='zip']","11219",logger,"Zipcode");
        ReusableMethods_Loggers.dropDownByText(driver,"//*[@name='incomeRange']","$100,001 - $150,000",logger,"HouseHold income");
        Thread.sleep(2000);
        //click on next
        ReusableMethods_Loggers.clickMethod(driver,"//*[@id='in-page-lead-step-2-next-button']",logger,"Next2");

    }//end of test 3
    @Test(priority = 4)
    public void submitInfo() throws InterruptedException {
        //enter name and pronoun
        ReusableMethods_Loggers.sendKeysMethod(driver,"//*[@name='firstName']","John",logger,"First name");
        ReusableMethods_Loggers.sendKeysMethod(driver,"//*[@name='lastName']","Smith",logger,"Last Name");
        ReusableMethods_Loggers.dropDownByText(driver,"//*[@name='genderPronoun']","He/Him/His",logger,"Pronoun");
        Thread.sleep(2000);
        //select next
        ReusableMethods_Loggers.clickMethod(driver,"//*[@id='in-page-lead-step-3-next-button']",logger,"Next3");
        //enter email and phone number and select submit
        ReusableMethods_Loggers.sendKeysMethod(driver,"//*[@name='email']","bumblejuice@gmail.com",logger,"Email");
        ReusableMethods_Loggers.sendKeysMethod(driver,"//*[@name='phone']","6468654256",logger,"Phone Number");
        Thread.sleep(2000);
        ReusableMethods_Loggers.clickMethod(driver,"//*[@id='in-page-lead-step-submit-button']",logger,"Submit");
        //screenshot thanks message
        ReusableMethods_Loggers.captureScreen(driver,"Thanks John",logger);

    }//end of test 4

    @Test(priority = 5)
    public void investments() throws InterruptedException {
        //click on investments
        ReusableMethods_Loggers.clickMethod(driver,"(//*[@class='nmx-nav-link-container nmx-nav-link-primary-container'])[4]",logger,"Investments");
        //scroll to 4 types of investments
        ReusableMethods_Loggers.scrollByElement(driver,"(//*[@class='sc-hKgJUU kNblTx'])[1]",logger,"4 types of investments");
        //capture text of investments
        ReusableMethods_Loggers.captureTextMethod(driver,"//*[@class='sc-jSgvzq biMLWF nmx-row sc-eZuRTN MSYwx']",logger,"list of investments");
        //find out more about private wealth management
        ReusableMethods_Loggers.clickMethod(driver,"//*[@aria-label='Find out more about private wealth management.']",logger,"Private Wealth Management");
        Thread.sleep(2000);
        //click on video
        ReusableMethods_Loggers.clickMethod(driver,"//*[@aria-label='Play']",logger,"Video");
        //wait 5 secs for video to play for a bit
        Thread.sleep(5000);

    }//end of test 5

    @Test(priority = 6)
    public void findAprivateClientGroupAdvisor() throws InterruptedException {
        //click on Find a private client
        ReusableMethods_Loggers.clickMethod(driver,"//*[@class='sc-iBPTik iaXxST']",logger,"Private Group Advisor");
        //wait for page to scroll
        Thread.sleep(2000);
        //select State from drop down
        ReusableMethods_Loggers.dropDownByText(driver,"//*[@id='private-wealth-management-pcg-directory-select']","New York",logger,"Select State");
        //click Small World Wealth Management
        ReusableMethods_Loggers.clickMethod(driver,"(//*[@class='sc-iBPTik kDGJti sc-jcRCNh lbAPxi'])[8]",logger,"Small World Wealth Management");
        //switch tab
        ReusableMethods_Loggers.switchToTabByIndex(driver,1,logger,"New Tab");
        Thread.sleep(2000);
        //screen shot and capture text
        ReusableMethods_Loggers.captureScreen(driver,"Protecting",logger);
        ReusableMethods_Loggers.captureTextMethod(driver,"//*[@class='col-md-10 col-md-offset-1 col-xs-12']",logger,"Financial Success");

    }//end of test 6

}//end of class
