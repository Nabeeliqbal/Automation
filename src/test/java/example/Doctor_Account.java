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

public class Doctor_Account {
    @org.junit.Test
    @Test

    public  void testcase2() throws InterruptedException {
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
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

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
        driver.findElement(By.cssSelector("a[class='text-[20px] font-normal text-[#0066CC]']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='bordered-radio-2']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        //--------------------------------PMDC No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("1990-OIU");
        Thread.sleep(3000);

        //--------------------------------Mobile No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys("344-9600178");

        //--------------------------------Continue Button--------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        //-------------------------------- Enter Your Details--------------------------------------------//
        //--------------------------------Designation-------------------------------------------//
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(3000);
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------First Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Iqra");
        Thread.sleep(3000);

        //--------------------------------Last Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Qayoom");
        Thread.sleep(3000);

        //--------------------------------Speciality--------------------------------------------//
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(3000);
        Actions keyDown1 = new Actions(driver);
        keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------Gender--------------------------------------------//
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(3000);
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------Years of Experience--------------------------------------------//
        WebElement experience = driver.findElement(By.xpath("//input[@placeholder='Years of Experience']"));
        experience.sendKeys("17");
        Thread.sleep(3000);

        //--------------------------------Email Optional--------------------------------------------//
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.sendKeys("iqraqayoom321@gmail.com");
        Thread.sleep(3000);


        //--------------------------------Continue Button--------------------------------------------//
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        button.submit();
        Thread.sleep(3000);

        //-------------------------------- Enter Clinic Details--------------------------------------------//
        //--------------------------------Clinic Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='Clinic Name']")).sendKeys("Zohair Clinic");
        Thread.sleep(3000);

        //--------------------------------City-------------------------------------------//
        driver.findElement(By.xpath("//input[@name='city']")).click();
        Thread.sleep(3000);
        Actions keyDown3= new Actions(driver);
        keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(3000);

        //--------------------------------Clinic Phone #-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("03449600178");
        Thread.sleep(3000);

        //--------------------------------Email (Optional)-------------------------------------------//
//        driver.findElement(By.xpath("//input[@placeholder='email']")).sendKeys("123@gmail.com");
//        Thread.sleep(3000);

        //--------------------------------Address-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Bahria Town, Bilal Arcade Clinic");
        Thread.sleep(3000);


        //--------------------------------SignUp--------------------------------------------//
        driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();
        Thread.sleep(3000);

        //---------------------------------------I Agree-----------------------------------------------//
        driver.findElement(By.xpath("//button[normalize-space()='I Agree']")).click();
        Thread.sleep(3000);

        //---------------------------------------OTP-----------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);


    }

}

