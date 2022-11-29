package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Find_Clinics {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://e-mareez.com/");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href='/clinics/search/all']")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h1[normalize-space()='Open Door Clinic']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(@class,'flex flex-col')]//button[contains(@class,'rounded hover:bg-skin-button-primary-hover')][normalize-space()='View Profile']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[4]//div[1]//div[3]//div[3]//button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[@class=' css-tlfecz-indicatorContainer']//*[name()='svg']")).click();
        Thread.sleep(3000);
        Actions dropDown2 = new Actions(driver);
        dropDown2.sendKeys(Keys.chord(Keys.DOWN,  Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("Rehan Atif");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("03315947601");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message

        System.out.println(alertMessage);


        Thread.sleep(3000);
        alert.accept();
        driver.close();




    }
}
