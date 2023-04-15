package Day10_032623;

import Reusables.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class T1_Staples_ResuableMethods {

    public static void main(String[] args) throws InterruptedException {

        //Use reusable method for chrome options
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to staples home page
        driver.navigate().to("https://www.staples.com/");

        //type on search field using sendkeys method
        ReusableMethods.sendKeysMethod(driver,"//*[@id='searchInput']","iphone", " Search Field");

        //click on search
        ReusableMethods.clickMethod(driver,"//*[@class='search-bar-input__searchIcon']"," Search Button");

        //click Index for item 1
        ReusableMethods.clickMethodByIndex(driver,"//*[@class='standard-tile__image standard-tile__image_hover']",0," Image 1");

        //click on add to cart
        ReusableMethods.clickMethod(driver,"//*[@id='cta_button']"," Add to Cart");

        Thread.sleep(2000);

        //get Text of price
        String result = ReusableMethods.captureTextMethod(driver,"//*[@class='atcDrawer__warranty_sub_title']","Starting Price");
        System.out.println("My result is " + result);

        driver.quit();

    }//end of main

}//end of class
