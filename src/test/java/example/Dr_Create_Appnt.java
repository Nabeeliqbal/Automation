package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import org.testng.annotations.Test;

import java.util.Optional;

public class Dr_Create_Appnt {
    @org.junit.Test
    @Test

    public void testcase3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions opt = new ChromeOptions();

        opt.addArguments("--no-sandbox");
        opt.addArguments("--remote-allow-origins=*");
        opt.addArguments("--start-maximized");
        opt.addArguments("--window-size=1920,1080");
        opt.addArguments("--disable-dev-shm-usage");

        opt.addArguments("--headless");
        WebDriver driver;
        driver = new ChromeDriver(opt);
        // Setup Network to access api response
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Add listener to receive API cal response
        devTools.addListener(Network.responseReceived(), response ->
        {
            Response res = response.getResponse();
            RequestId req = response.getRequestId();
            if (res.getStatus() == 200 && res.getUrl().equals("https://mareez-care.com/api/auth/send-verification-code")) {
                System.out.println(res.getUrl());
                String responseBody = devTools.send(Network.getResponseBody(req)).getBody();

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
        Thread.sleep(3000);
        WebElement d1= driver.findElement(By.xpath("//span[normalize-space()='Appointments']"));
        d1.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Create Appointment']")).click();
        Thread.sleep(3000);

        //-----------------Patient Phone # -----------------------
        driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys(" 314-3441012");
        Thread.sleep(3000);

        //-----------------Patient Name -----------------------
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).sendKeys("Nabeel");
        Thread.sleep(6000);

        //-----------------Patient Date of Birth-----------------------
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("2018-02-10");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"))
                .sendKeys("2023-03-10");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"))
                .click();
        Thread.sleep(3000);
        Actions KeyDown1 = new Actions(driver);
        KeyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[class='MuiFormControl-root css-15e6hlw'] div[role='button']"))
                .click();
        Thread.sleep(3000);
        Actions KeyDown2 = new Actions(driver);
        KeyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
    }
}
