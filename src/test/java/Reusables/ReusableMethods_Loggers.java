package Reusables;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableMethods_Loggers {

    //create a return method to return the webdriver you going to use on your test classes
    //static command allows your method to be global
    public static WebDriver defineChromeDriver() {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();
        //add incognito mode to option
        options.addArguments("incognito");
        //add options to run your driver on the background(headless)
        //options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside chromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //set maximize for windows
        driver.manage().window().maximize();

        return driver;

    }//end of webdriver method

    //return method will execute your statements along with returning some conditions/value
    //example of return methods are only WebDriver method and getText actiion


    //void method will only perform the action but won't return anything
    //void actions are click, sendKeys, scrolling, submit, select, mouse hover, clear

    //click action is one of the type of void method
    public static void clickMethod(WebDriver driver,String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on element" + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element" + elementName);
        }catch (Exception e){
            System.out.println("Unable to click on element" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method

    //click action is one of the type of void method by index
    public static void clickMethodByIndex(WebDriver driver,String xpath,int index,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element" + elementName);
            logger.log(LogStatus.PASS,"Successfully clicked on element" + elementName);
        }catch (Exception e){
            System.out.println("Unable to click on element" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method by index

    //clear and sendkeys method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on element" + elementName);
            logger.log(LogStatus.PASS,"Successfully entered a value on element" + elementName);
        }catch (Exception e){
            System.out.println("Unable to enter a value on element" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to enter a value on element" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of sendkeys method

    //clear and sendkeys method by index
    public static void sendKeysMethodByIndex(WebDriver driver,String xpath, String userValue,int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully enter a value on element" + elementName);
            logger.log(LogStatus.PASS,"Successfully enter a value on element" + elementName);
        }catch (Exception e){
            System.out.println("Unable to enter a value on element" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to enter a value on element" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of sendkeys method by index

    //capture a text and return it using return method
    public static String captureTextMethod(WebDriver driver,String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from element" + elementName);
            logger.log(LogStatus.PASS,"Successfully captured a text from element" + elementName);
        }catch (Exception e){
            System.out.println("Unable to capture text from element" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text from element" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
        return result;
    }//end of get text method

    //select by dropdown text method
    public static String dropDownByText(WebDriver driver, String xpath, String captureText, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(captureText);
            System.out.println("Successfully select text from dropdown" + elementName);
            logger.log(LogStatus.PASS,"Successfully select text from dropdown" + elementName);
        }catch (Exception e){
            System.out.println("Unable to select text from dropdown" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to select text from dropdown" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
        return result;
    }//end of get dropdown

    //scroll into view by element
    public static void scrollByElement(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement scroll = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)", scroll);
            System.out.println("Successfully scrolled into view" + elementName);
            logger.log(LogStatus.PASS,"Successfully scrolled into view" + elementName);
        }catch (Exception e){
            System.out.println("Unable to scroll" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to scroll" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of scroll into view

    //mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions mouseAction = new Actions(driver);
        try {
            WebElement hover = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(hover).perform();
            System.out.println("Successfully mouse hover " + elementName);
            logger.log(LogStatus.PASS,"Successfully mouse hover " + elementName);
        }catch (Exception e){
            System.out.println("Unable to hover mouse " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to hover mouse " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of mouse hover method

    //submit action is one of the type of void method
    public static void submitMethod(WebDriver driver,String xpath,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully submit on element" + elementName);
            logger.log(LogStatus.PASS,"Successfully submit on element" + elementName);
        }catch (Exception e){
            System.out.println("Unable to submit on element" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit method

    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, ExtentTest logger, String elementName){
        //Store xpath in boolean statement
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == expectedValue) {
                System.out.println("Passed: Checkbox is " + expectedValue);
                logger.log(LogStatus.PASS,"Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
                logger.log(LogStatus.PASS,"Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element  " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to verify element  " + elementName + " " + e);
            getScreenShot(driver,elementName,logger);
        }//end of exception
    }//end of verifyBooleanStatement

    //Switch to tab by index
    public static void switchToTabByIndex(WebDriver driver,int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            //call the window handles in array list and switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to the new tab by index
            driver.switchTo().window(tabs.get(index));
            System.out.println("Successfully switch tab " + elementName);
            logger.log(LogStatus.PASS,"Successfully switch tab " + elementName);
        }catch (Exception e){
            System.out.println("Unable to switch tab " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to switch tab " + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of switch tab by index

    //scroll by pixel
    public static void scrollByPixel(WebDriver driver, String pixel, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //scroll using pixels
            jse.executeScript(pixel);
            System.out.println("Successfully scrolled by pixel " + elementName);
            logger.log(LogStatus.PASS, "Successfully scrolled by pixel " + elementName);
        }catch (Exception e){
            System.out.println("Unable to scroll by pixel" + elementName + ": " + e);
            logger.log(LogStatus.FAIL,"Unable to scroll by pixel" + elementName + ": " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of scroll by pixel

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!! " + e);
        }
    }//end of getScreenshot method

    //method to capture screenshot when logger fails
    public static void captureScreen(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.PASS, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!! " + e);
        }
    }//end of getScreenshot method


}//end of class
