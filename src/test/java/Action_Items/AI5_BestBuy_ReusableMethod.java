package Action_Items;

import Reusables.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class AI5_BestBuy_ReusableMethod {

    public static void main(String[] args) throws InterruptedException {

        //Use reusable method for chrome options
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigate to bestbuy home page
        driver.navigate().to("https://www.bestbuy.com/");

        //enter iphone into search field
        ReusableMethods.sendKeysMethod(driver,"//*[@id='gh-search-input']","iphone","Search Field");

        //click on search
        ReusableMethods.clickMethod(driver,"//*[@class='header-search-icon']","Click on Search");

        //select dropdown sort by best selling
        ReusableMethods.dropDownByText(driver,"//*[@class='tb-select']","Best Selling","Select Best Selling");

        //wait 2 seconds for results to load when switching to best selling
        Thread.sleep(2000);

        //select first iphone with clickByIndex
        ReusableMethods.clickMethodByIndex(driver,"//*[@class='sku-title']",0,"First Iphone");

        //scroll to Learn About TotalTech
        ReusableMethods.scrollByElement(driver,"//*[@data-qa='learn-more-button']","Learn About TotalTech");

        //wait 2 seconds for the add to cart button to load, because if its too fast, its actually a show more info button
        Thread.sleep(2000);

        //click on Add to cart
        ReusableMethods.clickMethodByIndex(driver,"//*[@class='fulfillment-add-to-cart-button']",0,"Add to cart");

        //wait 6 seconds for popup to finishing loading
        Thread.sleep(6000);

        //get text of Cart Subtotal
        String result = ReusableMethods.captureTextMethod(driver,"//*[@class='sub-total v-fw-medium']","Cart Sub Total");
        System.out.println("Cart SubTotal is " + result);

        //hover over continue shopping
        ReusableMethods.mouseHover(driver,"//*[@data-track='Attach Modal: Continue shopping']","Continue Shopping");

        //click on continue shopping
        ReusableMethods.clickMethod(driver,"//*[@data-track='Attach Modal: Continue shopping']","Click on continue shopping");

        driver.quit();

    }//end of main
}//end of class
