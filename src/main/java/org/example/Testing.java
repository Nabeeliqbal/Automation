package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Testing {
    static  boolean isAlertPresent(WebDriver driver, int i) throws InterruptedException{
        boolean success = true;
        System.out.println(i);
        System.out.println("Iterating...");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100) /*timeout in seconds*/);
        try {

//                wait.until(ExpectedConditions.alertIsPresent());

                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(3000);
                success = false;

                WebElement d3 = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]"));
                d3.click();
                Thread.sleep(3000);

                Actions click2 = new Actions(driver);
                click2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//button[@type='submit']")).submit();
                Thread.sleep(3000);

                if (i < 0) {
                    return false;
                }

                isAlertPresent(driver, i - 1);
        }
            catch (Exception e) {
            success = true;
        }
        return success;
    }
    static Boolean createAppointmentSequence(WebDriver driver) throws InterruptedException  {
        driver.get("https://e-mareez.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']")).click();
        Thread.sleep(3000);
        WebElement d1 = driver.findElement(By.xpath("//a[normalize-space()='Find Doctor']"));
        d1.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div[1]//div[1]//div[4]//div[1]//div[3]//div[2]//button[1]")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[@aria-label='Choose date, selected date is Dec 7, 2022']//*[name()='svg']")).click();
//        Actions dropdown = new Actions(driver);
//        dropdown.sendKeys(Keys.chord(Keys.RIGHT, Keys.ENTER)).perform();
//        Thread.sleep(3000);
        WebElement d2 = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]"));
        d2.click();
        List<WebElement> timings = driver.findElements(By.id("react-select-5-listbox"));
        System.out.println(timings.size());
        WebElement q;
        for (int i=0; i< 12; i++){
            q = timings.get(i);
            System.out.println(q.getText());
        }


        Thread.sleep(3000);
        Actions keyDown1 = new Actions(driver);
        keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("Rehan Atif");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("03095558054");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        if ( isAlertPresent(driver, 12)) {
            driver.findElement(By.xpath("//button[@type='button']")).click();
            Thread.sleep(3000);
//            driver.close();
            return true;
        }
        return false;

    }
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        for (int i=0; i<6; i++) {
            System.out.println("Booking Appointment");
            Boolean booked = createAppointmentSequence(driver);
            System.out.println(booked);
        }



//        Actions keyDown1 = new Actions(driver);
//        keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("Rehan Atif");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("03095558054");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[@type='submit']")).submit();
//        Thread.sleep(3000);
//
//           try {
//               Alert alert1 = driver.switchTo().alert();
//               alert1.accept();// this would be executed only if above element is found
//
//               Thread.sleep(3000);
//               WebElement d3 = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]"));
//               d3.click();
//               Thread.sleep(3000);
//               Actions click2 = new Actions(driver);
//               click2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//               Thread.sleep(3000);
//               driver.findElement(By.xpath("//button[@type='submit']")).submit();
//               Thread.sleep(3000);
//
//
//               Alert alert2 = driver.switchTo().alert();
//               alert2.accept();// this would be executed only if above element is found
//
//               Thread.sleep(3000);
//               WebElement d4 = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]"));
//               d4.click();
//               Thread.sleep(3000);
//               Actions click3 = new Actions(driver);
//               click3.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//               Thread.sleep(3000);
//               driver.findElement(By.xpath("//button[@type='submit']")).submit();
//               Thread.sleep(3000);
//
//
//               Alert alert3 = driver.switchTo().alert();
//               alert3.accept();// this would be executed only if above element is found
//
//               Thread.sleep(3000);
//               WebElement d5 = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]"));
//               d5.click();
//               Thread.sleep(3000);
//               Actions click4 = new Actions(driver);
//               click4.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//               Thread.sleep(3000);
//               driver.findElement(By.xpath("//button[@type='submit']")).submit();
//               Thread.sleep(3000);
//
//               Alert alert4 = driver.switchTo().alert();
//               alert4.accept();
//
//               driver.findElement(By.xpath("//button[@aria-label='Choose date, selected date is Dec 5, 2022']//*[name()='svg']")).click();
//               Thread.sleep(3000);
//               Actions dropDown2 = new Actions(driver);
//               dropDown2.sendKeys(Keys.chord(Keys.RIGHT,  Keys.ENTER)).perform();
//               Thread.sleep(3000);
//               WebElement d6 = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]"));
//               d6.click();
//               Thread.sleep(3000);
//               Actions click6 = new Actions(driver);
//               click6.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//               Thread.sleep(3000);
//               driver.findElement(By.xpath("//button[@type='submit']")).submit();
//               Thread.sleep(3000);
//
//
//           }
//           catch (Exception e) {
//               driver.findElement(By.xpath("//button[@type='button']")).click();
//               Thread.sleep(3000);
//               driver.close();
//           }



    }
}
