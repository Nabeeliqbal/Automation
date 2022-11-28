package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testing {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://e-mareez.com/");

        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']")).click();
        Thread.sleep(3000);
        WebElement d1 = driver.findElement(By.xpath("//a[normalize-space()='Find Doctor']"));
        d1.click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,'flex flex-col gap-1')]//h1[contains(@class,'font-semibold text-skin-button-primary undefined')][normalize-space()='Dr. Abdul Kareem']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div//div//div//div//div[2]//div[1]//div[3]//div[3]//button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[@class=' css-tlfecz-indicatorContainer']//*[name()='svg']")).click();
        Thread.sleep(3000);
        Actions dropDown2 = new Actions(driver);
        dropDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
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
