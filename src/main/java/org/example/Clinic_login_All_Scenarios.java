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
import java.util.Optional;



public class Clinic_login_All_Scenarios {


    static  void Appointments(WebDriver driver) throws InterruptedException {

        //-------------------Create Appointment----------------------
//    driver.findElement(By.xpath("//span[normalize-space()='Appointments']")).click();
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//button[normalize-space()='Create Appointment']")).click();
//    Thread.sleep(3000);
//
//            //-----------------------------Ph No----------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("03095558049");
//        Thread.sleep(3000);
//
//            //-----------------------------Patient Name----------------------------------
//         driver.findElement(By.xpath("//input[@id='combo-box-demo']")).sendKeys("Aslam");
//         Thread.sleep(3000);
////         Actions keyDown4 = new Actions(driver);
////         keyDown4.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
////        Thread.sleep(3000);
//
//            //-----------------------------Date of Birth----------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("1996-05-25");
//        Thread.sleep(3000);
//
//            //-----------------------------Gender----------------------------------
//        driver.findElement(By.xpath("//div[@id='demo-simple-select']")).click();
//        Thread.sleep(3000);
//        Actions keyDown1 = new Actions(driver);
//        keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
//        Thread.sleep(3000);
//
//            //-----------------------------Select Doctor----------------------------------
//        driver.findElement(By.xpath("(//div[@role='button'])[15]")).click();
//        Thread.sleep(3000);
//        Actions keyDown3 = new Actions(driver);
//        keyDown3.sendKeys(Keys.chord(Keys.ENTER)).perform();
//        Thread.sleep(3000);
//
//            //-----------------------------Date of Appointment----------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"))
//                .sendKeys("2023-01-25");
//        Thread.sleep(3000);
//
//            //-----------------------------Appointment slots----------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)"))
//                .click();
//        Thread.sleep(3000);
//        Actions keyDown2 = new Actions(driver);
//        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//        Thread.sleep(3000);
//
//            //-----------------------------Appointment Duration----------------------------------
//        driver.findElement(By.xpath("//div[@class='MuiFormControl-root css-15e6hlw']//div[@role='button']")).click();
//        Thread.sleep(3000);
//        Actions keyDown5 = new Actions(driver);
//        keyDown5.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
//        Thread.sleep(3000);
//
//            //-----------------------------Add Button----------------------------------
//        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
       Thread.sleep(3000);

    }



    static  void Patient(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Patients']")).click();
        Thread.sleep(3000);

        //--------------------Add New patient--------------------------
//        driver.findElement(By.xpath("//button[normalize-space()='Add New Patients']")).click();
//        Thread.sleep(3000);

            //-----------------------------Ph No----------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("03095558049");
//        Thread.sleep(3000);
//
//          //-----------------------------Patient Name----------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("Rehan");
//        Thread.sleep(3000);

            //-----------------------------Date of Birth----------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)"))
//                .sendKeys("1996-05-25");
//        Thread.sleep(3000);

            //-----------------------------Gender----------------------------------
//        driver.findElement(By.xpath("//div[@id='demo-simple-select']")).click();
//        Thread.sleep(3000);
//        Actions keyDown1 = new Actions(driver);
//        keyDown1.sendKeys(Keys.chord(Keys.ENTER)).perform();
//        Thread.sleep(3000);

            //-----------------------------Add----------------------------------
//        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
//        Thread.sleep(3000);
          Appointments(driver);
    }



    static  void Add_Staff(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//span[normalize-space()='Staff']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[normalize-space()='Add Staff Member']")).click();
//
//        //-----------------------Modal Open---------------------------------------
//            //--------------------Designation----------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("Receptionist");
//            //--------------------Full Name----------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("Haider");
//            //--------------------Ph No----------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("03095558048");
//            //--------------------Add Btn----------------------------
//        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Patient(driver);
    }



    static  void Add_Doctor(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//span[normalize-space()='Doctors']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[normalize-space()='Add Doctor']")).click();
//        Thread.sleep(3000);
//        //------------------------------------PMDC-------------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("32320-I");
//        Thread.sleep(3000);
//        //------------------------------------Ph No-------------------------------------
//        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
//                .sendKeys("03095558055");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        Add_Staff(driver);
    }





    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
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
                String responseBody = devTools.send(Network.getResponseBody(req)).getBody();

                JsonObject jsonObject1 = (JsonObject) JsonParser.parseString(responseBody);
                String accessToken = jsonObject1.get("data").getAsJsonObject().get("temp_token").getAsString();
                driver.findElement(By.cssSelector("input[class='w-[265px] px-2 py-2 bg-white border border-slate-300 rounded-md text-sm shadow-sm placeholder-slate-400 focus:outline-none focus:border-gray-300 focus:ring-1 focus:ring-gray-300']")).sendKeys(accessToken);
            } else if (res.getStatus() == 200 && res.getUrl().equals("https://mareez-care.com/api/doctor/validate")) {
                System.out.println(res.getUrl());
                String responseBody = devTools.send(Network.getResponseBody(req)).getBody();

                JsonObject jsonObject1 = (JsonObject) JsonParser.parseString(responseBody);
                String accessToken = jsonObject1.get("data").getAsJsonObject().get("temp_token").getAsString();
                driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")).sendKeys(accessToken);
            }
        });
        driver.get("https://mareez-care.com/clinic-management-system/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@placeholder='03XXXXXXXXX']")).sendKeys("03128938695");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Submit']")).submit();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).submit();
        Thread.sleep(3000);
        Add_Doctor(driver);
    }
}
