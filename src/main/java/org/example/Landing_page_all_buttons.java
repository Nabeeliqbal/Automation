package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Landing_page_all_buttons {

    static  void InClinic_Appnt_Button(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[@class='pt-0']")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']"))
                .click();
        Thread.sleep(3000);
    }

    static  void Online_Consult_Button(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[@class='pt-0']")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']"))
                .click();
        Thread.sleep(3000);
        InClinic_Appnt_Button(driver);
    }

    static  void Call_Us(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Call_us']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter Your Mobile Number']"))
                .sendKeys("03128938695");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='bg-skin-button-primary text-skin-primary-white rounded p-2 h-search-bar w-32 hover:bg-skin-button-primary-hover text-sm']"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button']//*[name()='svg']")).click();
        Thread.sleep(3000);
        Online_Consult_Button(driver);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mareez-care.com/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']"))
                .click();
        Call_Us(driver);
    }
}
