package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.interactions.Actions;

import java.util.Optional;

public class Dr_Complete_appnt {


    static  void Invoice(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@aria-label='Invoice']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Expense']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)"))
                .sendKeys("Lab Test");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"))
                .sendKeys("500");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

        //---------------------------Discount---------------
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Discount']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"))
                .sendKeys("400");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

    }

    static  void Complete_Appnt(WebDriver driver) throws InterruptedException{
        Thread.sleep(6000);
        WebElement d1= driver.findElement(By.xpath("//span[normalize-space()='Appointments']"));
        d1.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@aria-label='Prescription']")).click();
        Thread.sleep(3000);

        //-----------------Vitals-------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("25");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("58");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("120/80");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("75");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("25");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("21.5");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("6.5");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(3000);

        //-----------------Medicines-------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Medicine']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"))
                .sendKeys("a");
        Thread.sleep(3000);
        Actions KeyDown = new Actions(driver);
        KeyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"))
                .sendKeys("5");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Day(s)']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='Once a day']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > label:nth-child(2) > span:nth-child(1) > input:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > label:nth-child(8) > span:nth-child(1) > input:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(3000);

        //-----------------Test-------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(4)")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add Test']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).click();
        Thread.sleep(3000);
        Actions KeyDown1 = new Actions(driver);
        KeyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).click();
        Thread.sleep(3000);
        Actions KeyDown2 = new Actions(driver);
        KeyDown2.sendKeys(Keys.chord(Keys.DOWN,  Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(3000);

        //-----------------Note-------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(6)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(7) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > textarea:nth-child(1)"))
                .sendKeys("Take Rest...........!");
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Exit')]")).click();
        Invoice(driver);

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

        driver.get("https://mareez-care.com/doctor/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(" 304-5071888");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        // OTP
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        Complete_Appnt(driver);
    }
}
