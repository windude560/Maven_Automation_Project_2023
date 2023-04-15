package Day8_031923;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T2_InClassActionItem {

    public static void main(String[] args) throws InterruptedException {

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

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Las Vegas");
        cities.add("Miami");
        cities.add("Houston");

        ArrayList<Integer> adult = new ArrayList<>();
        adult.add(2);
        adult.add(3);
        adult.add(4);

        ArrayList<String> child = new ArrayList<>();
        child.add("Under 1");
        child.add("1");
        child.add("2");

        for (int i = 0; i < cities.size(); i++) {


            driver.navigate().to("https://www.hotels.com/");

            //wait 2 seconds
            Thread.sleep(2000);

            //test click on destination textbox
            try {
                driver.findElement(By.xpath("//*[@aria-label='Going to']")).click();
                System.out.println("successfully clicked on destination textbox");
            } catch (Exception e) {
                System.out.println("did not click on destination textbox");
            }//end of exception for destination textbox

            Thread.sleep(2000);

            try {
                WebElement locationBox = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
                locationBox.sendKeys(cities.get(i));
                System.out.println("Successfully typed destination in textbox");
            } catch (Exception e) {
                System.out.println("typing destination in textbox was unsucessful");
            }//end of exception for typing in city

            Thread.sleep(2000);

            //select destination box
            try {
                driver.findElement(By.xpath("//*[@data-stid='destination_form_field-result-item-button']")).click();
                System.out.println("Successfully clicked on destination box");
            } catch (Exception e) {
                System.out.println("clicking on destination was unsucessful");
            }//end of click on destination on dropdown exception

            Thread.sleep(2000);

            //select guest box
            try {
                driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
                System.out.println("Successfully clicked guest box");
            } catch (Exception e) {
                System.out.println("clicking on guest box was unsucessful");
            }//end of click on guest box exception

            Thread.sleep(2000);

            //set default adult to 1
            try {
                driver.findElement(By.xpath("//*[@class='uitk-step-input-button']")).click();
                System.out.println("Successfully clicked on minus 1 adult");
            } catch (Exception e) {
                System.out.println("unable to click on minus adult");
            }//end of minus adult exception

            Thread.sleep(2000);

            //increase child to 1
            try {
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
                System.out.println("Successfully click on + child");
            } catch (Exception e) {
                System.out.println("Unable to click on + child");
            }

            Thread.sleep(2000);

            for (int j = 0; j < adult.get(i); j++) {

                //add adults within loop
                try {
                    driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']")).click();
                    System.out.println("Successfully clicked on + adults");
                } catch (Exception e) {
                    System.out.println("Unable to click on + adults");
                }//end of click on adult
            }//end of adult loop
            Thread.sleep(2000);

                //Select childs age within loop
                try {
                    WebElement childsAge = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
                    Select age = new Select(childsAge);
                    age.selectByVisibleText(child.get(i));
                    System.out.println("Successfully select childs age");
                } catch (Exception e) {
                    System.out.println("Did not select childs age");
                }

                Thread.sleep(4000);

                //click on done
                try {
                    driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
                    System.out.println("Successfully click on  done");
                } catch (Exception e) {
                    System.out.println("Unable to select done");
                }

                Thread.sleep(2000);

                //click on the select button
                try {
                    driver.findElement(By.xpath("//*[@id='search_button']")).click();
                    System.out.println("Successfully clicked on select");
                } catch (Exception e) {
                    System.out.println("unable to click on select");
                }

                Thread.sleep(3000);

                //select hotel link
                try {
                    ArrayList<WebElement> hotelLink = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));

                    if (i == 0) {
                        hotelLink.get(1).click();
                    } else if (i == 1) {
                        hotelLink.get(3).click();
                    } else if (i == 2) {
                        hotelLink.get(2).click();
                    }// end of conditional

                    System.out.println("Successfully click on link");
                } catch (Exception e) {
                    System.out.println("unable to click on link");
                }

                Thread.sleep(2000);

                //switch tabs

            try {
                //call the window handles in array list and switch to the new tab
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                //switch to the new tab by index of 1
                driver.switchTo().window(tabs.get(1));
                System.out.println("Successfully switch tabs");
            } catch (Exception e){
                System.out.println("unable to switch tabs");
            }

            Thread.sleep(1500);

            //print hotel name
            try {
                String hotelName = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).getText();
                System.out.println("Hotel name is " + hotelName);
                System.out.println("Successfully print hotel name");
            }catch (Exception e){
                System.out.println("unable to print hotel name");
            }

            Thread.sleep(2000);

            //click on Reserve a room and capture per night price
            try {
                driver.findElement(By.xpath("//*[@data-stid='sticky-button']")).click();
                String perNight = driver.findElement(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).getText();
                System.out.println("Per night: " + perNight);
                System.out.println("Successfully click on reserve and print per night ");
            }catch (Exception e){
                System.out.println("Unable to print per night");
            }

            Thread.sleep(2000);

            //click on reserve and pay now
            //Pop up for pay now does not always show, can ignore the pay now as page will load to after page for check in and out
            try {
                driver.findElement(By.xpath("//*[@data-stid='submit-hotel-reserve']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[contains(text(),'Pay now')]")).click();
                System.out.println("Successfully click on reserve and select pay now");
            }catch (Exception e) {
                System.out.println("unable to click on reserve and select pay now");
            }

            Thread.sleep(2000);

            //capture check in and out
            try {
                String checkInOut = driver.findElement(By.xpath("//*[@class='travel-details w-full table-bc-s ph-base mt-mouse mb-tiny']")).getText();
                System.out.println(checkInOut);
                System.out.println("Successfully capture check in and out");
            }catch (Exception e){
                System.out.println("unable to print check in and out");
            }

            Thread.sleep(2000);

            driver.close();

            try {
                //call the window handles in array list and switch to the old tab
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                //switch to the old tab by index of 0
                driver.switchTo().window(tabs.get(0));
                System.out.println("Successfully switch tabs");
            } catch (Exception e){
                System.out.println("unable to switch tabs");
            }

            Thread.sleep(1500);

        }//end of for loop

        driver.quit();
    }//end of main
}// end of class
