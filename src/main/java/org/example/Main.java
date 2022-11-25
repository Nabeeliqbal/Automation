package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
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
        js.executeScript("window.scrollBy(0,3000)", "");
        Thread.sleep(3000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,-3000)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='lg:p-4 text-sm py-3 px-0 block border-b-4 border-transparent hover:cursor-pointer hover:border-[#C22249] false'][normalize-space()='Find Specialist']")).click();
        Thread.sleep(3000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,3000)", "");
        Thread.sleep(3000);
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,-3000)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='lg:p-4 text-sm py-3 px-0 block border-b-4 border-transparent hover:cursor-pointer hover:border-[#C22249] false'][normalize-space()='Find Clinic']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Find Hospital']")).click();
        Thread.sleep(3000);
        driver.close();

    }
}
