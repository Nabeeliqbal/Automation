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
import org.testng.annotations.Test;

import java.util.Optional;



public class patient_signup {
//
//    static void BookAppointment(WebDriver driver) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Thread.sleep(6000);
//        WebElement d1 = driver.findElement(By.xpath("//a[normalize-space()='Find Doctor']"));
//        Thread.sleep(6000);
//        d1.click();
//        Thread.sleep(6000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement d2 = driver.findElement(By.xpath("(//button[contains(text(),'Book Appointment')])[21]"));
//        Thread.sleep(3000);
////        js.executeScript("arguments[0].scrollIntoView(true);", d2);
//        d2.click();
//        Thread.sleep(6000);
//        driver.findElement(By.xpath("//button[@aria-label='Choose date, selected date is Dec 16, 2022']//*[name()='svg']")).click();
//        Actions keyDown = new Actions(driver);
//        keyDown.sendKeys(Keys.chord(Keys.RIGHT, Keys.ENTER)).perform();
//        Thread.sleep(3000);
//        WebElement time = driver.findElement(By.xpath("//div[@class='flex flex-col w-full gap-2']//div[@class=' css-tlfecz-indicatorContainer']//*[name()='svg']"));
//        time.click();
//        Actions keyDown1 = new Actions(driver);
//       keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//
//            try {
//                wait.until(ExpectedConditions.alertIsPresent());
//                Alert alert = driver.switchTo().alert();
//                alert.accept();
//                System.out.println("alert was present and accepted");
//                time.click();
//                Actions keyDown2 = new Actions(driver);
//                keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//                driver.findElement(By.xpath("//button[@type='submit']")).click();
//                driver.findElement(By.xpath("//button[@type='button']")).click();
//            }
//        catch(Exception e) {
//                    System.out.println("alert was not present");
//                    System.out.print(e);
//            driver.findElement(By.xpath("//button[@type='button']")).click();
//            Thread.sleep(3000);
//                }
//
//
//
////        System.out.println(timeSlots.size());
////        for (int k = 0; k < timeSlots.size(); k++) {
////            timeSlots.get(k).click();
////
////            Thread.sleep(3000);
////            // Submit appointment form
////            WebElement f = driver.findElement(By.xpath("//button[@type='submit']"));
////                    f.submit();
////
////            Thread.sleep(3000);
////
////            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////            try {
////                wait.until(ExpectedConditions.alertIsPresent());
////                Alert alert = driver.switchTo().alert();
////                alert.accept();
////                System.out.println("alert was present and accepted");
////            }
////        catch(Exception e) {
////                    System.out.println("alert was not present");
////                    System.out.print(e);
////            driver.findElement(By.xpath("//button[@type='button']")).click();
////            Thread.sleep(3000);
////                }
////
////
////        }
//    }
    static void Medical_Background(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)"))
                        .click();
        Thread.sleep(3000);

        //-------------------------------Medical Documents--------------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)"))
                .click();
        Thread.sleep(3000);
        String filepath= "/Users/nabeeliqbal/IdeaProjects/Automation/src/main/resources/images/Screenshot (4).png";
        driver.findElement(By.xpath("(//div[@class='MuiBox-root css-lhrw7z'])[1]")).sendKeys(filepath);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();


//        BookAppointment(driver);
    }

    static void Add_Family_Member(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Add Account']")).click();
        Thread.sleep(3000);

       //-----------------------------------Name------------------------------------------------
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Husnain");
        Thread.sleep(3000);

        //-----------------------------------Gender------------------------------------------------
        driver.findElement(By.xpath("//input[@id='male']")).click();
        Thread.sleep(3000);

        //-----------------------------------DOB------------------------------------------------
        driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)"))
                .sendKeys("29/03/1987");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        Medical_Background(driver);
    }

    static void Edit_Profile(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@class,'md:pr-5')]//button[contains(@class,'')]")).click();
        Thread.sleep(3000);

       //-----------------------------------Name------------------------------------------------
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        name.sendKeys("Awaj");
        Thread.sleep(3000);

       //-----------------------------------Gender------------------------------------------------
        driver.findElement(By.xpath("//input[@id='female']")).click();
        Thread.sleep(3000);

        //-----------------------------------D0B------------------------------------------------
        WebElement DOB =driver.findElement(By.cssSelector("body > div:nth-child(1) > main:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)"));
        DOB.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        DOB.sendKeys("28/07/1995");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        Add_Family_Member(driver);
    }

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver();

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

        driver.get("https://mareez-care.com/patient/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Patient Name']")).sendKeys("Rehan Atif");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys("5822352353");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        // OTP
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        Edit_Profile(driver);
    }
}
