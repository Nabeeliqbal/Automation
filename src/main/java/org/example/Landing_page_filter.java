package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Landing_page_filter {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mareez-care.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']"))
                .click();
        Thread.sleep(3000);
         WebElement d1 = driver.findElement(By.xpath("//input[@placeholder='Select your location']"));
        Thread.sleep(3000);
        d1.click();
        Thread.sleep(3000);
        d1.clear();
        d1.sendKeys("Rawalpindi");
        WebElement d2 = driver.findElement(By.xpath("//input[@placeholder='Search for doctors, clinics, hospitals, etc.']"));
        Thread.sleep(3000);
        d2.click();
        Thread.sleep(3000);
        d2.sendKeys("Shehwal");
        driver.findElement(By.xpath("(//button[normalize-space()='Find'])[1]")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']"))
                .click();



            }
        }




