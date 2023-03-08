package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import java.util.Optional;

public class patient_book_appoint {


    static void Book_Appointment(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);

            driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > main:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > button:nth-child(1)")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[normalize-space()='4:45 PM - 5:00 PM']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);

            try {
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                    driver.findElement(By.xpath("//span[normalize-space()='4:15 PM - 4:30 PM']")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//button[@type='submit']")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
                    Thread.sleep(3000);
                    driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)")).click();

            }
                catch(Exception e){
                    return;
                }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)")).click();
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
            if (res.getStatus() == 200 && res.getUrl().equals("https://mareez-care.com/api/auth/send-verification-code")) {
                System.out.println(res.getUrl());
                String  responseBody = devTools.send(Network.getResponseBody(req)).getBody();

                JsonObject jsonObject1 = (JsonObject) JsonParser.parseString(responseBody);
                String accessToken = jsonObject1.get("data").getAsJsonObject().get("temp_token").getAsString();
                driver.findElement(By.cssSelector("input[class='w-[265px] px-2 py-2 bg-white border border-slate-300 rounded-md text-sm shadow-sm placeholder-slate-400 focus:outline-none focus:border-gray-300 focus:ring-1 focus:ring-gray-300']")).sendKeys(accessToken);
            }
        });

        driver.get("https://mareez-care.com/patient/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Patient Name']")).sendKeys("Rehan Atif");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(" 582-2352353");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        // OTP
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        //----------------------------Select In-Clinic Appoint
        driver.findElement(By.cssSelector("body > div:nth-child(1) > header:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(1) > button:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='In-Clinic Appointment']")).click();
        Thread.sleep(3000);
        Book_Appointment(driver);
    }
}
