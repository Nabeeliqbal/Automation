package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import example.utils.ChromeUtils;
import example.utils.login.LoginRoutines;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class Doctor_Account_Setup_Inclinic_2 {
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
    }

    @org.junit.Test
    @DisplayName("A---Set Availability")
    @Test
    public void Availability_TS_01()  throws InterruptedException {

        this.Header();
        Thread.sleep(3000);
        //-------------Dr Profile

        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-1bvc4cc']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //------------------Select Days
        driver.findElement(By.xpath("//div[normalize-space()='Sunday']")).click();
        Thread.sleep(3000);
        Actions set_day = new Actions(driver);
        set_day.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER}), Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]")).click();


        //------------------Select Start Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        Actions set_strat_time = new Actions(driver);
        set_strat_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]")).click();
        Actions set_time_type = new Actions(driver);
        set_time_type.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);


        //------------------Select End Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[1]/div[1]/div[1]")).click();
        Actions set_end_time = new Actions(driver);
        set_end_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[2]/div[1]/div[1]")).click();
        Actions set_endtime_type = new Actions(driver);
        set_endtime_type.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        //------------------Default Slot min
        driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b")).click();
        Actions slot_min = new Actions(driver);
        slot_min.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Add']")).click();
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Set Availability")
    @Test
    public void Availability_TS_02()  throws InterruptedException {

        this.Header();
        Thread.sleep(3000);
        //-------------Dr Profile

        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-1bvc4cc']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //------------------Select Days
        driver.findElement(By.xpath("//div[normalize-space()='Sunday']")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]")).click();


        //------------------Select Start Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        Actions set_strat_time = new Actions(driver);
        set_strat_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{ Keys.ENTER})}).perform();
        Thread.sleep(3000);

        Thread.sleep(3000);


        //------------------Select End Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[1]/div[1]/div[1]")).click();
        Actions set_end_time = new Actions(driver);
        set_end_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.ENTER})}).perform();
        Thread.sleep(3000);

        Thread.sleep(3000);


        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Set Availability")
    @Test
    public void Availability_TS_03()  throws InterruptedException {

        this.Header();
        Thread.sleep(3000);
        //-------------Dr Profile

        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-1bvc4cc']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //------------------Select Days
        driver.findElement(By.xpath("//div[normalize-space()='Sunday']")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]")).click();


        //------------------Select Start Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        Actions set_strat_time = new Actions(driver);
        set_strat_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{ Keys.DOWN, Keys.DOWN,Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]")).click();
        Actions set_time_type = new Actions(driver);
        set_time_type.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        //------------------Select End Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[1]/div[1]/div[1]")).click();
        Actions set_end_time = new Actions(driver);
        set_end_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN,Keys.DOWN, Keys.DOWN,
                Keys.DOWN, Keys.DOWN,Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[2]/div[1]/div[1]")).click();
        Actions set_endtime_type = new Actions(driver);
        set_endtime_type.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);



        //-----------------------------------------------------------------------------------------------------------//

        //------------------Select Start Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        Actions set_strat_time1 = new Actions(driver);
        set_strat_time1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{ Keys.DOWN, Keys.DOWN,Keys.DOWN,
                Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]")).click();
        Actions set_time_type1 = new Actions(driver);
        set_time_type1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);


        //------------------Select End Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[1]/div[1]/div[1]")).click();
        Actions set_end_time1 = new Actions(driver);
        set_end_time1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN,Keys.DOWN, Keys.DOWN,
                Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN,Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[2]/div[1]/div[1]")).click();
        Actions set_endtime_type1 = new Actions(driver);
        set_endtime_type1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Set Availability")
    @Test
    public void Availability_TS_04()  throws InterruptedException {

        this.Header();
        Thread.sleep(3000);
        //-------------Dr Profile

        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-1bvc4cc']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //------------------Select Days
        driver.findElement(By.xpath("//div[normalize-space()='Sunday']")).click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]")).click();


        //------------------Select Start Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        Actions set_strat_time = new Actions(driver);
        set_strat_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]")).click();
        Actions set_time_type = new Actions(driver);
        set_time_type.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        //------------------Select End Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[1]/div[1]/div[1]")).click();
        Actions set_end_time = new Actions(driver);
        set_end_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.DOWN,
                Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[2]/div[1]/div[1]")).click();
        Actions set_endtime_type = new Actions(driver);
        set_endtime_type.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        //------------------Default Slot min
        driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b")).click();
        Actions slot_min = new Actions(driver);
        slot_min.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Add']")).click();


        //-----------------------------------------------------------------------------------------------------------//

        //------------------Select Start Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        Actions set_strat_time1 = new Actions(driver);
        set_strat_time1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.DOWN,
                Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[2]/div[2]/div[1]/div[1]")).click();
        Actions set_time_type1 = new Actions(driver);
        set_time_type1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);


        //------------------Select End Time
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[1]/div[1]/div[1]")).click();
        Actions set_end_time1 = new Actions(driver);
        set_end_time1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.DOWN,
                Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[2]/div[1]/div[1]")).click();
        Actions set_endtime_type1 = new Actions(driver);
        set_endtime_type1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        //------------------Default Slot min
        driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b")).click();
        Actions slot_min1 = new Actions(driver);
        slot_min1.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Add']")).click();
        Thread.sleep(3000);
        driver.get("https://www.mareez-care.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]"))
                        .click();
        Thread.sleep(3000);

        //--------------------Find In-clinic Doctor
        driver.findElement(By.xpath("//a[contains(@class,'$')][normalize-space()='Find Clinic']"))
                .click();
        Thread.sleep(3000);

        WebElement cli = driver.findElement(By.xpath("//input[@placeholder='Find Clinics by Name']"));
        Thread.sleep(3000);
        cli.click();
        Thread.sleep(3000);
        cli.sendKeys("Testing Clinic 1133");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/h1[1]"))
                        .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/button[1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]/*[name()='svg'][1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/button[1]"))
                .click();
        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Delete Availability")
    @Test
    public void Availability_TS_05()  throws InterruptedException {

        this.Header();
        Thread.sleep(3000);
        //-------------Dr Profile

        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-1bvc4cc']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //------------------Delete
        driver.findElement(By.xpath("(//img[@aria-label='Delete'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@aria-label='Delete'])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@aria-label='Delete'])[3]")).click();
        Thread.sleep(3000);


        driver.get("https://www.mareez-care.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]"))
                .click();
        Thread.sleep(3000);

        //--------------------Find In-clinic Doctor
        driver.findElement(By.xpath("//a[contains(@class,'$')][normalize-space()='Find Clinic']"))
                .click();
        Thread.sleep(3000);

        WebElement cli = driver.findElement(By.xpath("//input[@placeholder='Find Clinics by Name']"));
        Thread.sleep(3000);
        cli.click();
        Thread.sleep(3000);
        cli.sendKeys("Testing Clinic 1133");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/h1[1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/button[1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]/*[name()='svg'][1]"))
                .click();
        Thread.sleep(3000);

        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Set Unavailability")
    @Test
    public void Unavailability_TS_01()  throws InterruptedException {

        this.Header();
        Thread.sleep(3000);
        //-------------Dr Profile

        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-1bvc4cc']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //------------------Unavailability
        driver.findElement(By.xpath("//h6[normalize-space()='Unavailability']")).click();
        Thread.sleep(3000);

        //------------------Select Start Time
        driver.findElement(By.xpath("(//div[@role='button'])[12]")).click();
        Thread.sleep(3000);
        Actions set_strat_time = new Actions(driver);
        set_strat_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);
        //------------------Select AM/ PM
        driver.findElement(By.xpath("(//div[@role='button'][normalize-space()='AM'])[1]")).click();
        Actions set_time_type = new Actions(driver);
        set_time_type.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        //------------------Select End Time
        driver.findElement(By.xpath("(//div[@role='button'])[14]")).click();
        Actions set_end_time = new Actions(driver);
        set_end_time.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.DOWN,
                Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Add'])[1]")).click();
        Thread.sleep(3000);

        //-----------------------Unavailability Day
        WebElement a = driver.findElement(By.xpath("//input[@id=':r2b:']"));
        Thread.sleep(3000);
        a.click();
        Thread.sleep(3000);
        a.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        a.sendKeys("08/06/2023");
        Thread.sleep(3000);
        WebElement b = driver.findElement(By.xpath("//input[@id=':r2c:']"));
        Thread.sleep(3000);
        b.click();
        Thread.sleep(3000);
        b.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        b.sendKeys("08/06/2023");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Add'])[2]")).click();
        Thread.sleep(3000);

        driver.get("https://www.mareez-care.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white']//*[name()='svg']"))
                .click();
        Thread.sleep(3000);

        //--------------------Find In-clinic Doctor
        driver.findElement(By.xpath("//a[contains(@class,'$')][normalize-space()='Find Clinic']"))
                .click();
        Thread.sleep(3000);

        WebElement cli = driver.findElement(By.xpath("//input[@placeholder='Find Clinics by Name']"));
        Thread.sleep(3000);
        cli.click();
        Thread.sleep(3000);
        cli.sendKeys("Testing Clinic 1133");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/h1[1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[3]/button[1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]/*[name()='svg'][1]"))
                .click();
        Thread.sleep(3000);

        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Set Unavailability")
    @Test
    public void Unavailability_TS_02()  throws InterruptedException {

        this.Header();
        Thread.sleep(3000);
        //-------------Dr Profile

        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-1bvc4cc']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //------------------Unavailability
        driver.findElement(By.xpath("//h6[normalize-space()='Unavailability']")).click();
        Thread.sleep(3000);


        //-----------------------Unavailability Day
        WebElement a = driver.findElement(By.xpath("//input[@id=':r2b:']"));
        Thread.sleep(3000);
        a.click();
        Thread.sleep(3000);
        a.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        a.sendKeys("08/06/2023");
        Thread.sleep(3000);
        WebElement b = driver.findElement(By.xpath("//input[@id=':r2c:']"));
        Thread.sleep(3000);
        b.click();
        Thread.sleep(3000);
        b.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        b.sendKeys("10/06/2023");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='submit'][normalize-space()='Add'])[2]")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Set Unavailability")
    @Test
    public void Delete_Unavailability_TS_03()  throws InterruptedException {

        this.Header();
        Thread.sleep(3000);
        //-------------Dr Profile

        By locator = By.xpath("//button[@aria-label='show more']//*[name()='svg']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement fooButton = driver.findElement(locator);
        fooButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        By locator1 = By.xpath("//div[@class='MuiBox-root css-1bvc4cc']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //------------------Unavailability
        driver.findElement(By.xpath("//h6[normalize-space()='Unavailability']")).click();
        Thread.sleep(3000);


        //-----------------------Delete Unavailability
        WebElement a = driver.findElement(By.xpath("(//img[@aria-label='Delete'])[1]"));
        Thread.sleep(3000);
        a.click();
        Thread.sleep(3000);

        //-----------------------Delete Unavailability
        WebElement b = driver.findElement(By.xpath("(//img[@aria-label='Delete'])[2]"));
        Thread.sleep(3000);
        b.click();
        Thread.sleep(3000);

        driver.quit();
    }
}
