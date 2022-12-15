package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class create_appointments {
    public static void main(String[] args) throws InterruptedException {


    WebDriver driver = new ChromeDriver();
        driver.get("https://e-mareez.com/patient/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[1]//input[1]")).sendKeys("Rehan Atif");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@placeholder='03XXXXXXXXX']")).sendKeys("03095558058");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Submit']")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).submit();
        Thread.sleep(3000);
        WebElement d1 = driver.findElement(By.xpath("//a[normalize-space()='Find Doctor']"));
        d1.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body//div//div//div//div//div//div[1]//div[1]//div[4]//div[1]//div[3]//div[2]//button[1]")).click();
        Thread.sleep(8000);
        WebElement d2 = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]"));
        d2.click();
        Thread.sleep(3000);
        Actions keyDown1 = new Actions(driver);
        keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage);
        alert.accept();
        Thread.sleep(8000);



        WebElement d3 = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[contains(@class,'css-ackcql')]"));
        d3.click();
        Thread.sleep(3000);
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(3000);




}
}
