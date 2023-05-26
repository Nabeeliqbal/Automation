package example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import example.utils.ChromeUtils;
import org.checkerframework.checker.units.qual.K;
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
import org.testng.annotations.Test;

import java.util.Optional;

public class Doctor_Account_Signup_Overseas {
    WebDriver driver;

    @org.junit.Test
    @DisplayName("A---Doctor SignUp without add optional details")
    @Test
    public void Dr_Signup_Overseas_TS_01() throws InterruptedException {
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
        driver.get("https://mareez-care.com/doctor/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Sign Up'][1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Overseas']")).click();
        Thread.sleep(3000);
        //--------------------------------PMDC No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("eeedfd");
        Thread.sleep(3000);

        //--------------------------------Mobile No--------------------------------------------//
        WebElement no = driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']"));
        no.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        no.sendKeys("13454654564");

        //--------------------------------Continue Button--------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);


        //--------------------------------First Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Online");
        Thread.sleep(3000);

        //--------------------------------Last Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Account");
        Thread.sleep(3000);

        //--------------------------------Speciality--------------------------------------------//
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(3000);
        Actions keyDown1 = new Actions(driver);
        keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------Gender--------------------------------------------//
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(3000);
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------Years of Experience--------------------------------------------//
        WebElement experience = driver.findElement(By.xpath("//input[@placeholder='Years of Experience']"));
        experience.sendKeys("17");
        Thread.sleep(3000);

        //--------------------------------Email--------------------------------------------//
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.sendKeys("onlineaccount55@gmail.com");
        Thread.sleep(3000);


        //--------------------------------Continue Button--------------------------------------------//
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        button.submit();
        Thread.sleep(3000);


        //---------------------------------------I Agree-----------------------------------------------//
        driver.findElement(By.xpath("//button[normalize-space()='I Agree']")).click();
        Thread.sleep(3000);

        //---------------------------------------OTP-----------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
    }

    @org.junit.Test
    @DisplayName("A---Doctor SignUp with add optional details")
    @Test
    public void Dr_Signup_Overseas_TS_02() throws InterruptedException {
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
        driver.get("https://mareez-care.com/doctor/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Sign Up'][1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Overseas']")).click();
        Thread.sleep(3000);
        //--------------------------------PMDC No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("eeedfd");
        Thread.sleep(3000);

        //--------------------------------Mobile No--------------------------------------------//
        WebElement no = driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']"));
        no.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        Thread.sleep(3000);
        no.sendKeys("13454654564");

        //--------------------------------Continue Button--------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);


        //--------------------------------First Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Online");
        Thread.sleep(3000);

        //--------------------------------Last Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Account");
        Thread.sleep(3000);

        //--------------------------------Speciality--------------------------------------------//
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(3000);
        Actions keyDown1 = new Actions(driver);
        keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------Gender--------------------------------------------//
        driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(3000);
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------Years of Experience--------------------------------------------//
        WebElement experience = driver.findElement(By.xpath("//input[@placeholder='Years of Experience']"));
        experience.sendKeys("17");
        Thread.sleep(3000);

        //--------------------------------Email--------------------------------------------//
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.sendKeys("onlineaccount55@gmail.com");
        Thread.sleep(3000);

        //--------------------------------Upload Profile Image (Optional)--------------------------------------------//
        WebElement image = driver.findElement(By.xpath("//input[@name='file']"));
        image.sendKeys("/Users/nabeeliqbal/Downloads/2.png");
        Thread.sleep(3000);


        //--------------------------------Continue Button--------------------------------------------//
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        button.submit();
        Thread.sleep(3000);


        //---------------------------------------I Agree-----------------------------------------------//
        driver.findElement(By.xpath("//button[normalize-space()='I Agree']")).click();
        Thread.sleep(3000);

        //---------------------------------------OTP-----------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
    }

    @org.junit.Test
    @DisplayName("A---Validations")
    @Test
    public void Dr_Signup_Overseas_TS_03() throws InterruptedException {
        driver = ChromeUtils.getChromeDriverDev();

        driver.get("https://mareez-care.com/doctor/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Sign Up'][1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Overseas']")).click();
        Thread.sleep(3000);
        //--------------------------------PMDC No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("");
        Thread.sleep(3000);

        //--------------------------------Mobile No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys("");

        //--------------------------------Continue Button--------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        WebElement errorMessageElement = driver.findElement(By.cssSelector(".text-rose-500.text-sm.mt-1"));
        Thread.sleep(3000);
        String actual_error = errorMessageElement.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error = "PMDC Number is required";
        Thread.sleep(3000);
        if (actual_error.contains(expected_error)) {
            System.out.println(actual_error);
        } else {
            System.out.println("Test Case Failed");
        }
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//p[@class='text-red-500']"));
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
        Thread.sleep(3000);
        driver.quit();
    }


    @org.junit.Test
    @DisplayName("A---Validations on Overseas Dr Details")
    @Test
    public void Dr_Signup_Overseas_TS_03_1() throws InterruptedException {
        driver = ChromeUtils.getChromeDriverDev();

        driver.get("https://mareez-care.com/doctor/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Sign Up'][1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Overseas']")).click();
        Thread.sleep(3000);
        //--------------------------------PMDC No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("rgtrgfd");
        Thread.sleep(3000);

        //--------------------------------Mobile No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys("13458454541");

        //--------------------------------Continue Button--------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        //-------------------------------- Enter Your Details--------------------------------------------//
        //--------------------------------First Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("");
        Thread.sleep(3000);

        //--------------------------------Last Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("");
        Thread.sleep(3000);

        //--------------------------------Years of Experience--------------------------------------------//
        WebElement experience = driver.findElement(By.xpath("//input[@placeholder='Years of Experience']"));
        experience.sendKeys("");
        Thread.sleep(3000);

        //--------------------------------Email Optional--------------------------------------------//
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.sendKeys("");
        Thread.sleep(3000);


        //--------------------------------Continue Button--------------------------------------------//
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        button.submit();
        Thread.sleep(3000);

        //---------------------Error message (First Name)---------
        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='First Name is required']"));
        Thread.sleep(3000);
        String actual_error = errorMessageElement.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error = "First Name is required";
        Thread.sleep(3000);
        if (actual_error.contains(expected_error)) {
            System.out.println(actual_error);
        } else {
            System.out.println("Test Case Failed");
        }

        //---------------------Error message (Last Name)---------
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='Last Name is required']"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error2 = "Last Name is required";
        Thread.sleep(3000);
        if (actual_error2.contains(expected_error2)) {
            System.out.println(actual_error2);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);

        //---------------------Error message (Speciality)---------
        WebElement errorMessageElement3 = driver.findElement(By.xpath("//div[normalize-space()='Speciality is required']"));
        Thread.sleep(3000);
        String actual_error3 = errorMessageElement3.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error3 = "Speciality is required";
        Thread.sleep(3000);
        if (actual_error3.contains(expected_error3)) {
            System.out.println(actual_error3);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);

        //---------------------Error message (Gender)---------
        WebElement errorMessageElement4 = driver.findElement(By.xpath("//div[normalize-space()='Gender is required']"));
        Thread.sleep(3000);
        String actual_error4 = errorMessageElement4.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error4 = "Gender is required";
        Thread.sleep(3000);
        if (actual_error4.contains(expected_error4)) {
            System.out.println(actual_error4);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);

        //---------------------Error message (Experience)---------
        WebElement errorMessageElement5 = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='Experience is required']"));
        Thread.sleep(3000);
        String actual_error5 = errorMessageElement5.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error5 = "Experience is required";
        Thread.sleep(3000);
        if (actual_error5.contains(expected_error5)) {
            System.out.println(actual_error5);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);

        //---------------------Error message (Email)---------
        WebElement errorMessageElement6 = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='Email is required']"));
        Thread.sleep(3000);
        String actual_error6 = errorMessageElement6.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error6 = "Email is required";
        Thread.sleep(3000);
        if (actual_error6.contains(expected_error6)) {
            System.out.println(actual_error6);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);
        driver.quit();
    }


    @org.junit.Test
    @DisplayName("A---Enter Alphabets in Mobile #")
    @Test
    public void Dr_Signup_Overseas_TS_04() throws InterruptedException {
        driver = ChromeUtils.getChromeDriverDev();

        driver.get("https://mareez-care.com/doctor/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Sign Up'][1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Overseas']")).click();
        Thread.sleep(3000);
        //--------------------------------PMDC No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("rgtrgfd");
        Thread.sleep(3000);

        //--------------------------------Mobile No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys("xfdfd");

        //--------------------------------Continue Button--------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        //-----------Error Message (Phone #)
        WebElement errorMessageElement2 = driver.findElement(By.xpath("//p[@class='text-red-500']"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error2 = "Phone number is not valid";
        Thread.sleep(3000);
        if (actual_error2.contains(expected_error2)) {
            System.out.println(actual_error2);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);
        driver.quit();
    }


    @org.junit.Test
    @DisplayName("A---Enter Alphabets/ Numeric Digits in Doctor Details")
    @Test
    public void Dr_Signup_Overseas_TS_04_1() throws InterruptedException {
        driver = ChromeUtils.getChromeDriverDev();

        driver.get("https://mareez-care.com/doctor/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Sign Up'][1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Overseas']")).click();
        Thread.sleep(3000);
        //--------------------------------PMDC No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("rgtrgfd");
        Thread.sleep(3000);

        //--------------------------------Mobile No--------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys("13458454541");

        //--------------------------------Continue Button--------------------------------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        //-------------------------------- Enter Your Details--------------------------------------------//
        //--------------------------------First Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("7567");
        Thread.sleep(3000);

        //--------------------------------Last Name-------------------------------------------//
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("453453");
        Thread.sleep(3000);


        //--------------------------------Years of Experience--------------------------------------------//
        WebElement experience = driver.findElement(By.xpath("//input[@placeholder='Years of Experience']"));
        experience.sendKeys("fsgfd");
        Thread.sleep(3000);

        //--------------------------------Email Optional--------------------------------------------//
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='email']"));
        email.sendKeys("dfgfd");
        Thread.sleep(3000);


        //--------------------------------Continue Button--------------------------------------------//
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        button.submit();
        Thread.sleep(3000);

        //---------------------Error message (First Name)---------
        WebElement errorMessageElement = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
        Thread.sleep(3000);
        String actual_error = errorMessageElement.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error = "Name cannot have special characters";
        Thread.sleep(3000);
        if (actual_error.contains(expected_error)) {
            System.out.println(actual_error);
        } else {
            System.out.println("Test Case Failed");
        }

        //---------------------Error message (Last Name)---------
        WebElement errorMessageElement2 = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2)"));
        Thread.sleep(3000);
        String actual_error2 = errorMessageElement2.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error2 = "Name cannot have special characters";
        Thread.sleep(3000);
        if (actual_error2.contains(expected_error2)) {
            System.out.println(actual_error2);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);

        //---------------------Error message (Speciality)---------
        WebElement errorMessageElement3 = driver.findElement(By.xpath("//div[normalize-space()='Speciality is required']"));
        Thread.sleep(3000);
        String actual_error3 = errorMessageElement3.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error3 = "Speciality is required";
        Thread.sleep(3000);
        if (actual_error3.contains(expected_error3)) {
            System.out.println(actual_error3);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);

        //---------------------Error message (Gender)---------
        WebElement errorMessageElement4 = driver.findElement(By.xpath("//div[normalize-space()='Gender is required']"));
        Thread.sleep(3000);
        String actual_error4 = errorMessageElement4.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error4 = "Gender is required";
        Thread.sleep(3000);
        if (actual_error4.contains(expected_error4)) {
            System.out.println(actual_error4);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);

        //---------------------Error message (Experience)---------
        WebElement errorMessageElement5 = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='Invalid Input: numbers please']"));
        Thread.sleep(3000);
        String actual_error5 = errorMessageElement5.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error5 = "Invalid Input: numbers please";
        Thread.sleep(3000);
        if (actual_error5.contains(expected_error5)) {
            System.out.println(actual_error5);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);

        //---------------------Error message (Email)---------
        WebElement errorMessageElement6 = driver.findElement(By.xpath("//div[@class='text-rose-500 text-sm mt-1'][normalize-space()='Email is required']"));
        Thread.sleep(3000);
        String actual_error6 = errorMessageElement6.getAttribute("innerHTML");
        Thread.sleep(3000);
        String expected_error6 = "Email is required";
        Thread.sleep(3000);
        if (actual_error6.contains(expected_error6)) {
            System.out.println(actual_error6);
        } else {
            System.out.println("Test Case Failed");
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
