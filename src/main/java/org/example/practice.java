package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class practice {

    static boolean isAlertPresent(WebDriver driver) throws InterruptedException {

        try {

            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]")).click();
            Thread.sleep(3000);
            Actions click3 = new Actions(driver);
            List<WebElement> options1 = driver.findElements(By.id("react-select-5-listbox"));
            System.out.println(options1);
            WebElement q = null;
            for (int i=0; i< options1.size(); i++){
                q = options1.get(i);
                System.out.println(q.getText());


                click3.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform(); //simulate visual movement
                Thread.sleep(200);

                driver.findElement(By.xpath("//button[@type='submit']")).submit();
                Thread.sleep(3000);

                if (q.getText() == "9:00 PM - 10:00 PM") {

                   driver.close();
                } else {
                    isAlertPresent(driver);
                }
            }

        } catch (Exception e) {

throw e;
        }

        return false;
    }


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://e-mareez.com/");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']")).click();
//        Thread.sleep(3000);
        WebElement d1 = driver.findElement(By.xpath("//a[normalize-space()='Find Doctor']"));
        d1.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div[1]//div[1]//div[4]//div[1]//div[3]//div[2]//button[1]")).click();

        Thread.sleep(8000);
        driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]")).click();
        Actions click2 = new Actions(driver);
        Thread.sleep(3000);

        List<WebElement> allValues = driver.findElements(By.id("react-select-5-listbox"));
        System.out.println(allValues.size());
        allValues.get(0).click();



//        List<WebElement> options = driver.findElements(By.id("react-select-5-listbox"));
//        System.out.println(options);
//        WebElement q;
//        for (int i=0; i< options.size(); i++){
//            q = options.get(i);
//            System.out.println(q.getText());
//        }
            click2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

            Thread.sleep(200);



                driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("Rehan Atif");
                Thread.sleep(3000);
                driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("03095558054");
                Thread.sleep(3000);
                driver.findElement(By.xpath("//button[@type='submit']")).submit();
                Thread.sleep(15000);
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).submit();
        Thread.sleep(3000);
                try {

                    isAlertPresent(driver);
                } catch (Exception e) {


                }
            }


//        WebElement q;
//        for (int i=0; i< options.size(); i++){
//            q = options.get(i);
//            System.out.println(q.getText());
//        }
//
        }


