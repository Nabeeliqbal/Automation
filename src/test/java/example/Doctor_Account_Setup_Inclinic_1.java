package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import example.utils.ChromeUtils;
import example.utils.login.LoginRoutines;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
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

public class Doctor_Account_Setup_Inclinic_1 {

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
    @DisplayName("A---Doctor Setup Profile")
    @Test
    public void Dr_Setup_Profile_Inclinic_TS_01()  throws InterruptedException {

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
        By locator1 = By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);


        //-----------------------------Designation
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='designation']")).click();
        Thread.sleep(3000);
        Actions designation = new Actions(driver);
        designation.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        //-----------------------------First & Last Name
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

        //-----------------------------City
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).click();
        Thread.sleep(3000);
        Actions city = new Actions(driver);
        city.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        //-----------------------------Email
        WebElement email = driver.findElement(By.xpath("(//input[@id=':r2c:'])[1]"));
        Thread.sleep(3000);
        email.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        email.sendKeys("demoaccount123@gmail.com");
        Thread.sleep(3000);


        //-----------------------------Experience
        WebElement experience = driver.findElement(By.xpath("(//input[@id=':r2d:'])[1]"));
        Thread.sleep(3000);
        experience.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        experience.sendKeys("15");
        Thread.sleep(3000);

        //-----------------------------Upload Image
        WebElement image = driver.findElement(By.xpath("//input[@id='contained-button-file']"));
        image.sendKeys("/Users/nabeeliqbal/Downloads/2.png");
        Thread.sleep(3000);

        //-----------------------------Add Button
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
    }

    @org.junit.Test
    @DisplayName("A---Clinic Details")
    @Test
    public void Dr_Setup_Profile_Inclhhinic_TS_02()  throws InterruptedException {

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

        By locator1 = By.xpath("//div[@class='MuiBox-root css-a39m6n']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //-----------------------------Clinic Name
        WebElement Clinic_name = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]"));
        Thread.sleep(2000);
        Clinic_name.click();
        Thread.sleep(2000);
        Clinic_name.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        Clinic_name.sendKeys("Clinic");
        Thread.sleep(3000);

        //-----------------------------City
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).click();
        Thread.sleep(3000);
        Actions city = new Actions(driver);
        city.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        //-----------------------------Phone #
        WebElement phone = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        phone.click();
        Thread.sleep(3000);
        phone.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        phone.sendKeys("03214565210");
        Thread.sleep(3000);

        //-----------------------------Email
        WebElement email = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        email.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        email.sendKeys("demoaccount123@gmail.com");
        Thread.sleep(3000);

        //-----------------------------Address
        WebElement address = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        address.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE));
        Thread.sleep(3000);
        address.sendKeys("fgtrgfrgdfgfdgfgdfgfd");
        Thread.sleep(3000);

        //-----------------------------Add Button
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
    }

    @org.junit.Test
    @DisplayName("A---Fee")
    @Test
    public void Dr_Setup_Fee_Inclinic_TS_01()  throws InterruptedException {

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

        //---------------------Fee------------
        By locator1 = By.xpath("//div[@id='Fee']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        WebElement fee = driver.findElement(By.xpath("(//input[@id=':r3d:'])[1]"));
        fee.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                                    Keys.BACK_SPACE);
        Thread.sleep(3000);
        fee.sendKeys("500");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.get("");
    }

    @org.junit.Test
    @DisplayName("A---Fee Validation (Min Fee)")
    @Test
    public void Min_Fee_Inclinic_TS_02()  throws InterruptedException {

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

        //---------------------Fee------------
        By locator1 = By.xpath("//div[@id='Fee']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);


        WebElement fee = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[1]/div/div/input"));
        Thread.sleep(3000);
        fee.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE);
        Thread.sleep(3000);
        fee.sendKeys("90");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);


        WebElement toolTip = driver.findElement(By.cssSelector(".MuiInputBase-root.MuiOutlinedInput-root.MuiInputBase-colorPrimary.MuiInputBase-fullWidth.MuiInputBase-formControl.css-1bdb0ix"));

        // To get the tool tip text and assert
        String toolTipText = toolTip.getText();
        System.out.println("toolTipText-->" + toolTipText);

        //Verification if tooltip text is matching expected value
        if (toolTipText.equalsIgnoreCase("Value must be greater than or equal to 100.")) {
            System.out.println("Pass* : Tooltip matching expected value");
        } else {
            System.out.println("Fail : Tooltip NOT matching expected value");
        }
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//legend[@class='css-14lo706']"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("title");
        Thread.sleep(3000);
        String expected_error2 = "Value must be greater than or equal to 100.";
        Thread.sleep(3000);
        if (actual_error2.contains(expected_error2)) {
            System.out.println(actual_error2);
        } else {
            System.out.println("Test Case Failed");
        }
        driver.quit();

    }
    @org.junit.Test
    @DisplayName("A---Fee Validation (Max Fee)")
    @Test
    public void Max_Fee_Inclinic_TS_03()  throws InterruptedException {

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

        //---------------------Fee------------
        By locator1 = By.xpath("//div[@id='Fee']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);


        WebElement fee = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[1]/div/div/input"));
        Thread.sleep(3000);
        fee.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE);
        Thread.sleep(3000);
        fee.sendKeys("1000000");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);


        WebElement toolTip = driver.findElement(By.cssSelector(".MuiInputBase-root.MuiOutlinedInput-root.MuiInputBase-colorPrimary.MuiInputBase-fullWidth.MuiInputBase-formControl.css-1bdb0ix"));

        // To get the tool tip text and assert
        String toolTipText = toolTip.getText();
        System.out.println("toolTipText-->" + toolTipText);

        //Verification if tooltip text is matching expected value
        if (toolTipText.equalsIgnoreCase("Value must be greater than or equal to 100.")) {
            System.out.println("Pass* : Tooltip matching expected value");
        } else {
            System.out.println("Fail : Tooltip NOT matching expected value");
        }
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//legend[@class='css-14lo706']"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("title");
        Thread.sleep(3000);
        String expected_error2 = "Value must be greater than or equal to 100.";
        Thread.sleep(3000);
        if (actual_error2.contains(expected_error2)) {
            System.out.println(actual_error2);
        } else {
            System.out.println("Test Case Failed");
        }
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Fee Validation (Enter Alphabets)")
    @Test
    public void Enter_Alphabets_in_Fee_Inclinic_TS_04()  throws InterruptedException {

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

        //---------------------Fee------------
        By locator1 = By.xpath("//div[@id='Fee']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);


        WebElement fee = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[1]/div/div/input"));
        Thread.sleep(3000);
        fee.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE);
        Thread.sleep(3000);
        fee.sendKeys("fsgtdfgfdgdf");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);


        WebElement toolTip = driver.findElement(By.cssSelector(".MuiInputBase-root.MuiOutlinedInput-root.MuiInputBase-colorPrimary.MuiInputBase-fullWidth.MuiInputBase-formControl.css-1bdb0ix"));

        // To get the tool tip text and assert
        String toolTipText = toolTip.getText();
        System.out.println("toolTipText-->"+toolTipText);

        //Verification if tooltip text is matching expected value
        if(toolTipText.equalsIgnoreCase("Please fill in this field.")){
            System.out.println("Pass* : Tooltip matching expected value");
        }else{
            System.out.println("Fail : Tooltip NOT matching expected value");
        }
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//legend[@class='css-14lo706']"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("title");
        Thread.sleep(3000);
        String expected_error2 = "Please fill in this field.";
        Thread.sleep(3000);
        if (actual_error2.contains(expected_error2)) {
            System.out.println(actual_error2);
        } else {
            System.out.println("Test Case Failed");
        }
        driver.quit();

    }

    @org.junit.Test
    @DisplayName("A---Add Multi-Education (get From Data)")
    @Test
    public void Add_MultiEducation_Inclinic_TS_01()  throws InterruptedException {

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

        //---------------------Education------------
        By locator1 = By.xpath("//div[@id='Education']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //---------------------University------------
        WebElement uni = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        uni.click();
        Thread.sleep(3000);
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/h2[1]")).click();

        //---------------------Qualification------------
        WebElement qual = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        qual.click();
        Thread.sleep(3000);
        qual.sendKeys("MBBS");
        Thread.sleep(3000);

        //---------------------Passing Year------------
        driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b")).click();
        Thread.sleep(3000);
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);


        //------------------------------------------------------------------------------------------------------------//

        //---------------------Education------------
        By locator2 = By.xpath("//div[@id='Education']//img[@aria-label='Edit']");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(locator2));
        WebElement fooButton2 = driver.findElement(locator2);
        fooButton2.click();
        Thread.sleep(3000);

        //---------------------University------------
        WebElement uni2 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        uni2.click();
        Thread.sleep(3000);
        Actions keyDown3 = new Actions(driver);
        keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/h2[1]")).click();

        //---------------------Qualification------------
        WebElement qual2 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        qual2.click();
        Thread.sleep(3000);
        qual2.sendKeys("MBBS");
        Thread.sleep(3000);

        //---------------------Passing Year------------
        driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b")).click();
        Thread.sleep(3000);
        Actions keyDown4 = new Actions(driver);
        keyDown4.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@aria-label='Delete'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@aria-label='Delete'])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@aria-label='close']//*[name()='svg']")).click();
    }

    @org.junit.Test
    @DisplayName("A---Add Multi-Education (Manually)")
    @Test
    public void Add_MultiEducation_Inclinic_TS_02()  throws InterruptedException {

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

        //---------------------Education------------
        By locator1 = By.xpath("//div[@id='Education']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //---------------------University------------
        WebElement uni = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        uni.click();
        Thread.sleep(3000);
        uni.sendKeys("International");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/h2[1]")).click();


        //---------------------Qualification------------
        WebElement qual = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        qual.click();
        Thread.sleep(3000);
        qual.sendKeys("International");
        Thread.sleep(3000);


        //---------------------Passing Year------------
        WebElement passing_year = driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b"));
        Thread.sleep(3000);
        passing_year.click();
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);


        //------------------------------------------------------------------------------------------------------------//

        //---------------------University------------
        WebElement uni1 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        uni1.click();
        Thread.sleep(3000);
        uni1.sendKeys("gfgfg");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/h2[1]")).click();


        //---------------------Qualification------------
        WebElement qual2 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        qual2.click();
        Thread.sleep(3000);
        qual2.sendKeys("fgdsg");
        Thread.sleep(3000);


        //---------------------Passing Year------------
        WebElement passing_year3 = driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b"));
        Thread.sleep(3000);
        passing_year3.click();
        Actions keyDown3 = new Actions(driver);
        keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@aria-label='Delete'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//img[@aria-label='Delete'])[2]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@aria-label='close']//*[name()='svg']")).click();
    }

    @org.junit.Test
    @DisplayName("A---Duplicate Education (Get Data)")
    @Test
    public void Add_MultiEducation_Inclinic_TS_03()  throws InterruptedException {

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

        //---------------------Education------------
        By locator1 = By.xpath("//div[@id='Education']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //---------------------University------------
        WebElement uni = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        uni.click();
        Thread.sleep(3000);
        uni.sendKeys("International");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/h2[1]")).click();


        //---------------------Qualification------------
        WebElement qual = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        qual.click();
        Thread.sleep(3000);
        qual.sendKeys("International");
        Thread.sleep(3000);


        //---------------------Passing Year------------
        WebElement passing_year = driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b"));
        Thread.sleep(3000);
        passing_year.click();
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.navigate().refresh();


        //------------------------------------------------------------------------------------------------------------//

        //---------------------Education------------
        By locator2 = By.xpath("//div[@id='Education']//img[@aria-label='Edit']");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(locator2));
        WebElement fooButton2 = driver.findElement(locator2);
        fooButton2.click();
        Thread.sleep(3000);
        //---------------------University------------
        WebElement uni2 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        uni2.click();
        Thread.sleep(3000);
        uni2.sendKeys("International");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/h2[1]")).click();


        //---------------------Qualification------------
        WebElement qual2 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        qual2.click();
        Thread.sleep(3000);
        qual2.sendKeys("International");
        Thread.sleep(3000);


        //---------------------Passing Year------------
        WebElement passing_year2 = driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b"));
        Thread.sleep(3000);
        passing_year2.click();
        Actions keyDown3 = new Actions(driver);
        keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        //---------------------Error message---------
        WebElement errorMessageElement3 = driver.findElement(By.xpath("//div[contains(text(),'Specified qualification already added')]"));
        Thread.sleep(3000);
        String actual_error3 = errorMessageElement3.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error3 = "Specified qualification already added ";
        Thread.sleep(3000);
        if (actual_error3.contains(expected_error3)) {
            System.out.println(actual_error3);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Duplicate Education (Manually)")
    @Test
    public void Add_MultiEducation_Inclinic_TS_04()  throws InterruptedException {

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

        //---------------------Education------------
        By locator1 = By.xpath("//div[@id='Education']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //---------------------University------------
        WebElement uni = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        uni.click();
        Thread.sleep(3000);
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/h2[1]")).click();

        //---------------------Qualification------------
        WebElement qual = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        qual.click();
        Thread.sleep(3000);
        qual.sendKeys("MBBS");
        Thread.sleep(3000);

        //---------------------Passing Year------------
        driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b")).click();
        Thread.sleep(3000);
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.navigate().refresh();


        //------------------------------------------------------------------------------------------------------------//

        //---------------------Education------------
        By locator2 = By.xpath("//div[@id='Education']//img[@aria-label='Edit']");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(locator2));
        WebElement fooButton2 = driver.findElement(locator1);
        fooButton2.click();
        Thread.sleep(3000);

        //---------------------University------------
        WebElement uni2 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));
        Thread.sleep(3000);
        uni2.click();
        Thread.sleep(3000);
        Actions keyDown3 = new Actions(driver);
        keyDown3.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/h2[1]")).click();

        //---------------------Qualification------------
        WebElement qual2 = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        Thread.sleep(3000);
        qual2.click();
        Thread.sleep(3000);
        qual2.sendKeys("MBBS");
        Thread.sleep(3000);

        //---------------------Passing Year------------
        driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.css-gi940b")).click();
        Thread.sleep(3000);
        Actions keyDown4 = new Actions(driver);
        keyDown4.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        //---------------------Error message---------
        WebElement errorMessageElement3 = driver.findElement(By.xpath("//div[contains(text(),'Specified qualification already added')]"));
        Thread.sleep(3000);
        String actual_error3 = errorMessageElement3.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error3 = "Specified qualification already added ";
        Thread.sleep(3000);
        if (actual_error3.contains(expected_error3)) {
            System.out.println(actual_error3);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Add Services / Add Multi-Services")
    @Test
    public void Add_Services_Inclinic_TS_01()  throws InterruptedException {

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

        //---------------------Services------------
        By locator1 = By.xpath("//div[@id='Services']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //---------------------Add Services------------
        WebElement ser = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[1]/div/div/input"));
        Thread.sleep(3000);
        ser.click();
        Thread.sleep(3000);
        ser.sendKeys("MED");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        //---------------------MultiServices------------
        WebElement ser2 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[1]/div/div/input"));
        Thread.sleep(3000);
        ser2.click();
        Thread.sleep(3000);
        ser2.sendKeys("MES");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Duplicate Data")
    @Test
    public void Add_Services_Inclinic_TS_02()  throws InterruptedException {

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

        //---------------------Services------------
        By locator1 = By.xpath("//div[@id='Services']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //---------------------Add Services------------
        WebElement ser = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[1]/div/div/input"));
        Thread.sleep(3000);
        ser.click();
        Thread.sleep(3000);
        ser.sendKeys("MED");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        //---------------------Duplicate------------
        WebElement ser2 = driver.findElement(By.cssSelector("/html/body/div[3]/div[3]/div/div/form/div/div[1]/div/div/input"));
        Thread.sleep(3000);
        ser2.click();
        Thread.sleep(3000);
        ser2.sendKeys("MED");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        //---------------------Error message---------
        WebElement errorMessageElement3 = driver.findElement(By.xpath("//div[contains(text(),'Specific Service is already added')]"));
        Thread.sleep(3000);
        String actual_error3 = errorMessageElement3.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error3 = "Specific Service is already added ";
        Thread.sleep(3000);
        if (actual_error3.contains(expected_error3)) {
        System.out.println(actual_error3);
        } else {
        System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);
        driver.quit();
    }
    @org.junit.Test
    @DisplayName("A---Delete Services")
    @Test
    public void Delete_Services_Inclinic_TS_03()  throws InterruptedException {

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

        //---------------------Services------------
        By locator1 = By.xpath("//div[@id='Services']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        //---------------------Delete Services------------
        driver.findElement(By.xpath("//div[@class='MuiBox-root css-13migaq']//div[1]//*[name()='svg']")).click();
        Thread.sleep(3000);

        //---------------------Delete Services------------
        driver.findElement(By.xpath("//div[@class='MuiBox-root css-13migaq']//div[2]//*[name()='svg']")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Add Paragrpah in About field")
    @Test
    public void About_Inclinic_TS_01()  throws InterruptedException {

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

        //---------------------About------------
        By locator1 = By.xpath("//div[@id='About']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        WebElement about = driver.findElement(By.xpath("/html[1]"));
        Thread.sleep(3000);
        about.click();
        Thread.sleep(3000);
        about.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(30000);
        about.sendKeys("efrefewfewdfwewefws");
        Thread.sleep(3000);
        driver.quit();
    }

    @org.junit.Test
    @DisplayName("A---Bank Details")
    @Test
    public void Bank_Details_Inclinic_TS_01()  throws InterruptedException {

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

        //---------------------Bank------------
        By locator1 = By.xpath("//div[@id='Bank Details']//img[@aria-label='Edit']");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
        WebElement fooButton1 = driver.findElement(locator1);
        fooButton1.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@id='mui-component-select-bank_name']")).click();
        Actions bank_name = new Actions(driver);
        bank_name.sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER})}).perform();
        Thread.sleep(3000L);
        WebElement account_title = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        account_title.sendKeys(new CharSequence[]{Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE});
        account_title.sendKeys(new CharSequence[]{"Kaleem"});
        Thread.sleep(3000L);
        WebElement account_no = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        account_no.sendKeys(new CharSequence[]{Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE});
        account_no.sendKeys(new CharSequence[]{"545444554685812"});
        Thread.sleep(3000L);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        driver.quit();
    }
}
