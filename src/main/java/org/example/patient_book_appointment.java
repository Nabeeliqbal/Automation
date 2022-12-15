package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;



public class patient_book_appointment {

    static void BookAppointment(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(6000);
        WebElement d1 = driver.findElement(By.xpath("//a[normalize-space()='Find Doctor']"));
        Thread.sleep(6000);
        d1.click();
        Thread.sleep(6000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement d2 = driver.findElement(By.xpath("(//button[contains(text(),'Book Appointment')])[21]"));
        Thread.sleep(3000);
//        js.executeScript("arguments[0].scrollIntoView(true);", d2);
        d2.click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//button[@aria-label='Choose date, selected date is Dec 16, 2022']//*[name()='svg']")).click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.RIGHT, Keys.ENTER)).perform();
        Thread.sleep(3000);
        WebElement time = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[@class=' css-tlfecz-indicatorContainer']//*[name()='svg']"));
        time.click();
        Actions keyDown1 = new Actions(driver);
       keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

            try {
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
                System.out.println("alert was present and accepted");
                time.click();
                Actions keyDown2 = new Actions(driver);
                keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
                driver.findElement(By.xpath("//button[@type='submit']")).click();
                driver.findElement(By.xpath("//button[@type='button']")).click();
            }
        catch(Exception e) {
                    System.out.println("alert was not present");
                    System.out.print(e);
            driver.findElement(By.xpath("//button[@type='button']")).click();
            Thread.sleep(3000);
                }



//        System.out.println(timeSlots.size());
//        for (int k = 0; k < timeSlots.size(); k++) {
//            timeSlots.get(k).click();
//
//            Thread.sleep(3000);
//            // Submit appointment form
//            WebElement f = driver.findElement(By.xpath("//button[@type='submit']"));
//                    f.submit();
//
//            Thread.sleep(3000);
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            try {
//                wait.until(ExpectedConditions.alertIsPresent());
//                Alert alert = driver.switchTo().alert();
//                alert.accept();
//                System.out.println("alert was present and accepted");
//            }
//        catch(Exception e) {
//                    System.out.println("alert was not present");
//                    System.out.print(e);
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            Thread.sleep(3000);
//                }
//
//
//        }
    }




    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver();

        // Setup Network to access api response
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        // Add listener to receive API cal response
        devTools.addListener(Network.responseReceived(), response ->
        {
            Response res = response.getResponse();
            RequestId req = response.getRequestId();
            if (res.getStatus() == 200 && res.getUrl().equals("https://www.e-mareez.com/api/auth/send-verification-code")) {
                System.out.println(res.getUrl());
                String  responseBody = devTools.send(Network.getResponseBody(req)).getBody();

                JsonObject jsonObject1 = (JsonObject) JsonParser.parseString(responseBody);
                String accessToken = jsonObject1.get("data").getAsJsonObject().get("temp_token").getAsString();
                driver.findElement(By.cssSelector("input[class='w-[265px] px-2 py-2 bg-white border border-slate-300 rounded-md text-sm shadow-sm placeholder-slate-400 focus:outline-none focus:border-gray-300 focus:ring-1 focus:ring-gray-300']")).sendKeys(accessToken);
            }
        });

        driver.get("https://e-mareez.com/patient/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[1]//input[1]")).sendKeys("Rehan Atif");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@placeholder='03XXXXXXXXX']")).sendKeys("03095558058");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Submit']")).click();
        Thread.sleep(3000);

        // OTP
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).submit();
        Thread.sleep(3000);
        BookAppointment(driver);

    }
}
