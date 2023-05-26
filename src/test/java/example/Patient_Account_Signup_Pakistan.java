package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import example.utils.ChromeUtils;
import example.utils.login.LoginRoutines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class Patient_Account_Signup_Pakistan {

    WebDriver driver;

    @org.junit.Test
    @Test
    @BeforeMethod
    public void Header() throws InterruptedException {
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


    @DisplayName("A--Patient Account Sign-Up")
    @Test
    public void Patient_Signup_TS_01() throws InterruptedException {
        this.Header();
        Thread.sleep(3000);
        WebElement edit_button = driver.findElement(By.xpath("//div[contains(@class,'w-full flex gap-1 items-center')]//div//button[contains(@class,'')]"));
        edit_button.click();
        Thread.sleep(3000);

        //-----------------------------------Name------------------------------------------------
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        Thread.sleep(3000);
        name.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        name.sendKeys("Awaj");
        Thread.sleep(3000);

        //-----------------------------------Gender------------------------------------------------
        driver.findElement(By.xpath("//input[@id='female']")).click();
        Thread.sleep(3000);

        //-----------------------------------D0B------------------------------------------------
        WebElement DOB = driver.findElement(By.xpath("/html/body/div/main/div[2]/div/div/div[2]/form/div[4]/div/div/input"));
        DOB.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        DOB.sendKeys("28/07/1995");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }


    @DisplayName("A--Check Validation on each field, when we enter no data")
    @Test
    public void Validations_TS_02() throws InterruptedException {
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
        driver.get("https://www.mareez-care.com/patient/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Patient Name']")).sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"))
                .sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        WebElement errorMessageElement = driver.findElement(By.cssSelector(".text-rose-500.text-sm.mt-1"));
        Thread.sleep(3000);
        String actual_error = errorMessageElement.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error = "Name is required";
        Thread.sleep(3000);
        if (actual_error.contains(expected_error)) {
            System.out.println(actual_error);
        } else {
            System.out.println("Test Case Failed");
        }
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//p[@class='text-rose-500 ']"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error2 = "Phone Number is required";
        Thread.sleep(3000);
        if (actual_error2.contains(expected_error2)) {
            System.out.println(actual_error2);
        } else {
            System.out.println("Test Case Failed");
        }
        driver.quit();
    }


    @DisplayName("A--Numeric Digits in Pat Field, Alphabets in Ph #")
    @Test
    public void Numeric_Alphabets_TS_03() throws InterruptedException {
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
            driver.get("https://www.mareez-care.com/patient/login");
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Patient Name']")).sendKeys("45353");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"))
                    .sendKeys("dfgtfdgfd");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);
            WebElement errorMessageElement = driver.findElement(By.cssSelector(".text-rose-500.text-sm.mt-1"));
            Thread.sleep(3000);
            String actual_error = errorMessageElement.getAttribute("innerHTML");
            Thread.sleep(3000);
            String expected_error = "Name cannot have special characters";
            Thread.sleep(3000);
            if(actual_error.contains(expected_error))
            {
                System.out.println(actual_error);
            }else
            {
                System.out.println("Test Case Failed");
            }
            WebElement errorMessageElement2 = driver.findElement(By.xpath("//p[@class='text-rose-500 ']"));
            Thread.sleep(3000);
            String actual_error2 = errorMessageElement2.getAttribute("innerHTML");
            Thread.sleep(3000);
            String expected_error2 = "Phone number is not valid";
            Thread.sleep(3000);
            if(actual_error2.contains(expected_error2))
            {
                System.out.println(actual_error2);
            }else
            {
                System.out.println("Test Case Failed");
            }
            driver.quit();
        }


    @DisplayName("A--OVERSEAS PATIENT ACCOUNT SIGNUP")
    @Test
    public void Overseas_Patient_TS_01() throws InterruptedException {
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
        driver.get("https://www.mareez-care.com/patient/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(@class,'text-[14px] text-[#0066CC] w-[70px] md:text-[23px] lg:text-[19px] sm:w-[90px] xl:text-[1.1rem] flex flex-col underline text-center lg:text-left font-normal cursor-pointer')][1]")).click();
        Thread.sleep(3000);

        //-----------------------------------Name------------------------------------------------
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        Thread.sleep(3000);
        name.sendKeys("Zohair");
        Thread.sleep(3000);

        //-----------------------------------Ph #------------------------------------------------
        WebElement ph_no = driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"));
                ph_no.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
                ph_no.sendKeys("14234242342");
        Thread.sleep(3000);

        //-----------------------------------Email------------------------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Zohairahmed345@gmail.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        // OTP
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }


    @DisplayName("A--Skip Email")
    @Test
    public void Overseas_Skip_Email_TS_02() throws InterruptedException {
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
        driver.get("https://www.mareez-care.com/patient/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(@class,'text-[14px] text-[#0066CC] w-[70px] md:text-[23px] lg:text-[19px] sm:w-[90px] xl:text-[1.1rem] flex flex-col underline text-center lg:text-left font-normal cursor-pointer')][1]")).click();
        Thread.sleep(3000);

        //-----------------------------------Name------------------------------------------------
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        Thread.sleep(3000);
        name.sendKeys("Zohair");
        Thread.sleep(3000);

        //-----------------------------------Ph #------------------------------------------------
        WebElement ph_no = driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"));
        ph_no.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        ph_no.sendKeys("14234242343");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='Email is required']"));
        Thread.sleep(3000);
        String actual_error = errorMessageElement.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error = "Email is required";
        Thread.sleep(3000);
        if(actual_error.contains(expected_error))
        {
            System.out.println(actual_error);
        }else
        {
            System.out.println("Test Case Failed");
        }



    }


    @DisplayName("A--Overseas (Numeric Digits in Pat Field, Alphabets in Ph #)")
    @Test
    public void Numeric_Alphabets_Email_TS_03() throws InterruptedException {
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
        driver.get("https://www.mareez-care.com/patient/signup");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //-----------------------Name---------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("45353");
        Thread.sleep(3000);

        //-----------------------Ph #---------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"))
                .sendKeys("dfgtfdgfd");
        Thread.sleep(3000);

        //-----------------------Email---------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Email']"))
                .sendKeys("fdgdfg");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);


        //-----------------------Name cannot have special characters---------------------------------
        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1']"));
        Thread.sleep(3000);
        String actual_error = errorMessageElement.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error = "Name cannot have special characters";
        Thread.sleep(3000);
        if(actual_error.contains(expected_error))
        {
            System.out.println(actual_error);
        }else
        {
            System.out.println("Test Case Failed");
        }

        //-----------------------Ph # is not valid---------------------------------
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//p[@class='text-rose-500 ']"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error2 = "Phone number is not valid";
        Thread.sleep(3000);
        if(actual_error2.contains(expected_error2))
        {
            System.out.println(actual_error2);
        }else
        {
            System.out.println("Test Case Failed");
        }

        //-----------------------Email must be a valid email---------------------------------
        WebElement errorMessageElement3 = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='email must be a valid email']"));
        Thread.sleep(3000);
        String actual_error3 = errorMessageElement3.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error3 = "email must be a valid email";
        Thread.sleep(3000);
        if(actual_error3.contains(expected_error3))
        {
            System.out.println(actual_error3);
        }else
        {
            System.out.println("Test Case Failed");
        }
        driver.quit();
    }


    @DisplayName("A--Overseas Validation (When we enter no data in the fields)")
    @Test
    public void Overseas_Validation_TS_04() throws InterruptedException {
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
        driver.get("https://www.mareez-care.com/patient/signup");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //-----------------------Name---------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("");
        Thread.sleep(3000);

        //-----------------------Ph #---------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"))
                .sendKeys("");
        Thread.sleep(3000);

        //-----------------------Email---------------------------------
        driver.findElement(By.xpath("//input[@placeholder='Email']"))
                .sendKeys("");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);


        //-----------------------Name is required---------------------------------
        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='Name is required']"));
        Thread.sleep(3000);
        String actual_error = errorMessageElement.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error = "Name cannot have special characters";
        Thread.sleep(3000);
        if(actual_error.contains(expected_error))
        {
            System.out.println(actual_error);
        }else
        {
            System.out.println("Test Case Failed");
        }

        //-----------------------Ph # is not valid---------------------------------
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//p[@class='text-rose-500 ']"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error2 = "Phone number is not valid";
        Thread.sleep(3000);
        if(actual_error2.contains(expected_error2))
        {
            System.out.println(actual_error2);
        }else
        {
            System.out.println("Test Case Failed");
        }

        //-----------------------Email is required---------------------------------
        WebElement errorMessageElement3 = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='Email is required']"));
        Thread.sleep(3000);
        String actual_error3 = errorMessageElement3.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error3 = "Email is required";
        Thread.sleep(3000);
        if(actual_error3.contains(expected_error3))
        {
            System.out.println(actual_error3);
        }else
        {
            System.out.println("Test Case Failed");
        }
        driver.quit();
    }


    }








