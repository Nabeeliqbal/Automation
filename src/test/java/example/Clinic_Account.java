package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Optional;

public class Clinic_Account {
    @org.junit.Test
    @Test

    public  void testcase4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions opt = new ChromeOptions();

        opt.addArguments("--no-sandbox");
        opt.addArguments("--start-maximized");
        opt.addArguments("--window-size=1920,1080");
        opt.addArguments("--disable-dev-shm-usage");

        opt.addArguments("--headless");
        WebDriver driver;
        driver = new ChromeDriver(opt);
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
                driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")).sendKeys(accessToken);
            }
        });

        driver.get("https://mareez-care.com/clinic-management-system/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[class='text-[20px] font-normal text-[#0066CC]']")).click();
        Thread.sleep(3000);

        //--------------------------------Basic Package---------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(9) > td:nth-child(3) > div:nth-child(1) > a:nth-child(1) > button:nth-child(1)")).click();
        Thread.sleep(3000);

        //-------------------------------Sign Up as Clinic Admin-----------------------
        driver.findElement(By.xpath("//input[@placeholder='Owner Name']")).sendKeys("Automation Testing");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys(" 346-6600688");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        //----------------------------Clinic Name------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Clinic Name']")).sendKeys("Automation");
        Thread.sleep(3000);

        //----------------------------City------------------------------
        driver.findElement(By.xpath("//input[@name='city']")).click();
        Thread.sleep(3000);
        Actions KeyDown = new Actions(driver);
        KeyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")).click();

        //----------------------------Clinic Phone #------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("03466600688");
        Thread.sleep(3000);

        //----------------------------Email------------------------------------
        driver.findElement(By.xpath("//input[@placeholder='email']")).sendKeys("automaton123@gmail.com");
        Thread.sleep(3000);

        //----------------------------Address------------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("tfasgmailcom");
        Thread.sleep(3000);

        //----------------------------Register Button------------------------------------
        driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
        Thread.sleep(3000);

        //----------------------------I Agree Button------------------------------------
        driver.findElement(By.xpath("//button[normalize-space()='I Agree']")).click();
        Thread.sleep(3000);

        //----------------------------OTP------------------------------------
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);


    }
}

