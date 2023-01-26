package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Five_Star_Rating {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://e-mareez.com/doctor/feedback/77");
        driver.manage().window().maximize();
        Thread.sleep(3000);


        for (int i=0; i<50; i++) {
            driver.findElement(By.cssSelector("label[for=':r8:']")).click();
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("textarea[class='resize-y border rounded-md w-full h-[80px] p-2']")).
                    sendKeys("Satisfied");
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//button[normalize-space()='Send'])[1]")).click();
            Thread.sleep(3000);
            driver.navigate().refresh();
            Thread.sleep(3000);
        }
        Thread.sleep(3000);
        for (int j=0; j<50; j++) {
            driver.findElement(By.cssSelector("label[for=':r6:']")).click();
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("textarea[class='resize-y border rounded-md w-full h-[80px] p-2']")).
                    sendKeys("Satisfied");
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//button[normalize-space()='Send'])[1]")).click();
            Thread.sleep(3000);
            driver.navigate().refresh();
            Thread.sleep(3000);
        }

    }
}
