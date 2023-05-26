package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import example.utils.ChromeUtils;
import example.utils.login.LoginRoutines;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class Patient_Account_dadfa {
    WebDriver driver;
    @BeforeMethod
    public  void Header() throws InterruptedException {
        driver = ChromeUtils.getChromeDriverDev();
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
        Boolean isSuccess = LoginRoutines.PatientLogin(driver, "302-8787871");
        if (!isSuccess) {
            driver.quit();
        }
    }

    @DisplayName("A--Patient Add Account Family Member")
    @Test
    public void Add_Family_Member_TS_01() throws InterruptedException {
        this.Header();
        Thread.sleep(3000);
        WebElement edit_button = driver.findElement(By.xpath("(//button[normalize-space()='+ Add Account'])[1]"));
        edit_button.click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div[class='rounded-full bg-[#E4F4FF] text-[#0055A8] md:h-[130px] h-[120px] cursor-pointer md:w-[130px] w-[120px] text-[50px] font-normal flex flex-col items-center justify-center']"))
                .click();
        Thread.sleep(3000);


        //-----------------------------------Name------------------------------------------------
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Hassan");
        Thread.sleep(3000);
        //-----------------------------------Gender------------------------------------------------
        driver.findElement(By.xpath("//input[@id='male']")).click();
        Thread.sleep(3000);

        //-----------------------------------D0B------------------------------------------------
        WebElement DOB = driver.findElement(By.xpath("/html/body/div/main/div[2]/div/div/div[2]/form/div[4]/div/div/input"));
        DOB.sendKeys("28/07/1995");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }
}
