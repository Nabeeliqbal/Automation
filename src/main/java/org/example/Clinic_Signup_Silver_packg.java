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
import org.openqa.selenium.interactions.Actions;

import java.util.Optional;

public class Clinic_Signup_Silver_packg {

    static void Silver_Package(WebDriver driver) throws InterruptedException {
       Thread.sleep(3000);
       driver.findElement(By.xpath("(//button[@class=' border border-[#3B7BC9] text-[#3B7BC9] hover:bg-[#3B7BC9] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px] '])[1]"))
               .click();
        Thread.sleep(3000);

        //---------------------------------Owner Name---------------------------------------------------------
        driver.findElement(By.xpath("(//input[@class='text-sm mt-2 w-full h-[40px] md:w-[342px] px-2 rounded border border-[#cccccc]'])[1]"))
                .sendKeys("Nabeel");
        Thread.sleep(3000);
        //---------------------------------Mobile No---------------------------------------------------------
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@placeholder='1 (702) 123-4567']"))
                .sendKeys("309-5558044");
        Thread.sleep(3000);
        //---------------------------------Next Button---------------------------------------------------------
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Next']")).submit();
        Thread.sleep(3000);

        //---------------------------------Clinic Details---------------------------------------------------------
            //------------------------------Clinic name----------------------------
        driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")).sendKeys("Animatory Clinic");
        Thread.sleep(3000);
            //------------------------------City----------------------------
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//div[contains(@class,'css-19bb58m')]")).click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.ENTER)).perform();
        Thread.sleep(3000);
            //------------------------------Phone No----------------------------
        driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[4]/input[1]")).sendKeys("03095558044");
        Thread.sleep(3000);
            //------------------------------Address----------------------------
        driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[6]/input[1]")).sendKeys("Bahria Phase 2 Dha");
        Thread.sleep(3000);
            //------------------------------register Button----------------------------
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Register']")).submit();
        Thread.sleep(3000);
            //--------------------------------I agree Button--------------------------------------------//
        WebElement button2 = driver.findElement(By.xpath("//button[normalize-space()='I Agree']"));
        button2.click();
        Thread.sleep(3000);

            //---------------------------------------OTP-----------------------------------------------//
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).submit();
        Thread.sleep(3000);
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
        driver.get("https://mareez-care.com/clinic-management-system/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//span[contains(@class,'text-primary-red font-semibold cursor-pointer hover:border-b-2 hover:border-primary-red')][normalize-space()='Register']"))
                .click();
        Silver_Package(driver);
    }

}
