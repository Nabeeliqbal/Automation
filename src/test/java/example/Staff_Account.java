package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.testng.annotations.Test;

import java.util.Optional;

public class Staff_Account {
    @org.junit.Test
    @Test

    public  void testcase5() throws InterruptedException {
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
                driver.findElement(By.cssSelector("input[class='w-[265px] px-2 py-2 bg-white border border-slate-300 rounded-md text-sm shadow-sm placeholder-slate-400 focus:outline-none focus:border-gray-300 focus:ring-1 focus:ring-gray-300']")).sendKeys(accessToken);
            }
        });

        driver.get("https://mareez-care.com/staff/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys(" 346-5655021");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}

