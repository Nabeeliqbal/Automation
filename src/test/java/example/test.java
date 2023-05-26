package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import example.utils.ChromeUtils;
import example.utils.login.LoginRoutines;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v107.network.Network;

import org.openqa.selenium.devtools.v107.network.model.Headers;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.rmi.Remote;
import java.time.Duration;
import java.util.Optional;
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class test {
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
        Boolean isSuccess = LoginRoutines.Doctor_Login(driver, "3028787871");
        if (!isSuccess) {
            driver.quit();
        }

//        driver.get("https://mareez-care.com/doctor/login");
//        driver.manage().window().maximize();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"))
//                .sendKeys(" 302-8787871");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        Thread.sleep(3000);
//        // OTP
//        driver.findElement(By.xpath("//button[@type='submit']")).submit();
//        Thread.sleep(6000);
    }
        @DisplayName("A--Edit Online Dr Profile & Skip Optional Details")
    @Test
    public void Skip_Optional_Details_Edit_Profile()  throws InterruptedException {

        this.Header();
        //-------------Dr Profile
        System.out.println("Here...");
        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");
        System.out.println("Here...2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
        System.out.println("Here...3");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
//        By locator1 = By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//img[@aria-label='Edit']");
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
//        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
//        WebElement fooButton1 = driver.findElement(locator1);
//        fooButton1.click();
//        Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//img[@aria-label='Edit']")).click();

//        //-----------------------------Designation
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='designation']")).click();
        Thread.sleep(3000);
        Actions designation = new Actions(driver);
        designation.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

//        //-----------------------------First & Last Name
        WebElement first_name = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        first_name.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        first_name.sendKeys("Aroush");
        Thread.sleep(3000);
        WebElement last_name = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        last_name.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        last_name.sendKeys("ahmed");
        Thread.sleep(3000);

//        //-----------------------------Experience
        WebElement experience = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        experience.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        experience.sendKeys("15");
        Thread.sleep(3000);

//        //-----------------------------Submit
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
    }
//
    @DisplayName("B--Edit Online Dr Profile & Add Optional Details")
    @Test
    public void Add_Optional_Details_Edit_Profile( ) throws InterruptedException {
        this.Header();
//        //-------------Dr Profile
        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(6000);
        By locator1 = By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);
//
//        //-----------------------------Designation
        driver.findElement(By.xpath("//div[@id='designation']")).click();
        Thread.sleep(3000);
        Actions designation = new Actions(driver);
        designation.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
//
//        //-----------------------------First & Last Name
        WebElement first_name = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        first_name.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        first_name.sendKeys("Aroush");
        Thread.sleep(3000);
        WebElement last_name = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        last_name.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        last_name.sendKeys("ahmed");
        Thread.sleep(3000);
//
//        //-----------------------------City
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).click();
        Thread.sleep(3000);
        Actions city = new Actions(driver);
        city.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
//
//        //-----------------------------Email
        WebElement email = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        email.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        email.sendKeys("aroushahmed555@gmail.com");
        Thread.sleep(3000);
//
//
//        //-----------------------------Experience
        WebElement experience = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        experience.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        experience.sendKeys("15");
        Thread.sleep(3000);
//
//        //-----------------------------Upload Picture
//        WebElement picture = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[1]/div[7]/div/div/div/label/input"));
//        Thread.sleep(3000);
//        picture.sendKeys("/Users/nabeeliqbal/Downloads/13.png");
//        Thread.sleep(3000);
//
//        //-----------------------------Submit
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

    }

    @DisplayName("C--Edit In-Clinic Dr Profile & Skip Optional Details")
    @Test
    public void Skip_Optional_Details_Edit_Profile_Inclinic() throws InterruptedException {
//
//        //-------------Dr Profile
        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(6000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-a39m6n']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);
//
//        //-----------------------------Clinic Name
        WebElement clinic_name = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        clinic_name.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        clinic_name.sendKeys("Automation Clinic");
        Thread.sleep(3000);
//
//        //-----------------------------City
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).click();
        Thread.sleep(3000);
        Actions city = new Actions(driver);
        city.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
//
//        //-----------------------------Phone #
        WebElement email = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        email.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        email.sendKeys("03214521012");
        Thread.sleep(3000);
//
//        //-----------------------------Address
        WebElement address = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Thread.sleep(3000);
        address.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        address.sendKeys("DHa Phase 1, Sector F");
        Thread.sleep(3000);
//
//        //-----------------------------Submit
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
    }
}
