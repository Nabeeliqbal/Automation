package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import java.util.Optional;

public class Doctor_Profile_Editable {

    static void EditBankDetails(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        //----------------------------Scroll down & Click on Edit Button----------------------------------
        WebElement Element = driver.findElement(By.xpath("//div[@id='Bank Details']//img[@aria-label='Edit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Element);
        actions.perform();
        Element.click();
        Thread.sleep(3000);

        //----------------------------Selected Bank----------------------------------
        driver.findElement(By.xpath("//div[@id='mui-component-select-bank_name']")).click();
        Thread.sleep(3000);
        Actions selected_bank = new Actions(driver);
        selected_bank.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        //----------------------------Account Title----------------------------------
        WebElement account_title =driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        account_title.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        account_title.sendKeys("Nabeel");
        Thread.sleep(3000);

        //----------------------------Account Title----------------------------------
        WebElement account_no =driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        account_no.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        account_no.sendKeys("65464454544645");
        Thread.sleep(3000);
        //----------------------------Submit---------------------------------------
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

    }
    static void EditAbout(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        //----------------------------Scroll down & Click on Edit Button----------------------------------
        WebElement Element = driver.findElement(By.xpath("//div[@id='About']//img[@aria-label='Edit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Element);
        actions.perform();
        Element.click();
        Thread.sleep(3000);

        //----------------------------Edit (About) Text Area----------------------------------
        WebElement about = driver.findElement(By.xpath("//div[@role='textbox']"));
        about.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        about.sendKeys("Nothing");
        Thread.sleep(3000);

        //----------------------------Submit---------------------------------------
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        EditBankDetails(driver);
    }



    static void EditServices(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        //----------------------------Scroll down & Click on Edit Button----------------------------------
        WebElement Element = driver.findElement(By.xpath("//div[@id='Services']//img[@aria-label='Edit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Element);
        actions.perform();
        Element.click();
        Thread.sleep(3000);

//        //----------------------------Delete Service----------------------------------
//        driver.findElement(By.xpath("//div[@class='MuiBox-root css-13migaq']//div[1]//*[name()='svg']")).click();
//        Thread.sleep(3000);

        //----------------------------Add Service----------------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("MBBS");
        Thread.sleep(3000);

        //----------------------------Submit---------------------------------------
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//div[@role='alert']"));
            Thread.sleep(3000);

            driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                    .sendKeys("AECOM");
            Thread.sleep(3000);
            //----------------------------Submit---------------------------------------
            driver.findElement(By.xpath("//button[@type='submit']")).submit();
            Thread.sleep(3000);
            //----------------------------Close Pop-Up------------------------------------
            driver.findElement(By.xpath("//button[@aria-label='close']//*[name()='svg']")).click();

        } catch (Exception e) {
            //----------------------------Close Pop-Up------------------------------------
            driver.findElement(By.xpath("//button[@aria-label='close']//*[name()='svg']")).click();
            Thread.sleep(3000);

        }
        EditAbout(driver);
    }

    static void EditEducation(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        //----------------------------Click on Edit Button----------------------------------
        driver.findElement(By.xpath("//div[@id='Education']//img[@aria-label='Edit']")).click();
        Thread.sleep(3000);

        //----------------------------Univeristy----------------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).click();
        Actions univeristy = new Actions(driver);
        univeristy.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        //----------------------------Qualification----------------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("AECM");
        Thread.sleep(3000);

        //----------------------------Passing Year----------------------------------
        driver.findElement(By.xpath("//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-gi940b']")).click();
        Actions passing_year = new Actions(driver);
        passing_year.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN,  Keys.ENTER)).perform();
        Thread.sleep(3000);

        //----------------------------Submit---------------------------------------
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        //----------------------------Close Pop-Up---------------------------------------
        driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M19 6.41 1')]")).click();
        EditServices(driver);
    }




    static void EditFee(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='Fee']//img[@aria-label='Edit']")).click();
        Thread.sleep(3000);
        WebElement fee = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        fee.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        fee.sendKeys("100");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        EditEducation(driver);
    }

    static void EditProfile(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//img[@aria-label='Edit']")).click();
        Thread.sleep(3000);

        //--------------------------Designation-----------------------------------------------------------
        driver.findElement(By.xpath("//div[@id='designation']")).click();
        Thread.sleep(3000);
        Actions keydown = new Actions(driver);
        keydown.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        //-------------------------First Name-----------------------------------------------------------
        WebElement First_Name = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        First_Name.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        First_Name.sendKeys("Sufyan");
        Thread.sleep(3000);

        //---------------------------Last Name--------------------------------------------------------------
        WebElement Last_Name = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        Last_Name.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        Last_Name.sendKeys("Akhtar");

        //---------------------------City--------------------------------------------------------------
        driver.findElement(By.xpath("//input[@id='combo-box-demo']")).click();
        Thread.sleep(3000);
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN,Keys.DOWN,Keys.ENTER)).perform();
        Thread.sleep(3000);

        //---------------------------Email--------------------------------------------------------------
        WebElement email = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        email.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        email.sendKeys("sufyan123@gmail.com");
        Thread.sleep(3000);

        //---------------------------Experience--------------------------------------------------------------
        WebElement experience = driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        experience.sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        Thread.sleep(3000);
        experience.sendKeys("10");
        Thread.sleep(3000);

        //---------------------------Add Button--------------------------------------------------------------
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        EditFee(driver);
    }


    static void DoctorProfile(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//button[@aria-label='show more']//*[name()='svg']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);
        EditProfile(driver);
    }


    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        ChromeDriver driver = new ChromeDriver();
        // Set up Network to access api response
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        // Add Listener to receive API call response
        devTools.addListener(Network.responseReceived(), response -> {
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
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@placeholder='Enter phone number']"))
                .sendKeys("3067777777");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Submit']")).submit();
        // OTP
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).submit();
        Thread.sleep(19000);
        DoctorProfile(driver);

    }
}
