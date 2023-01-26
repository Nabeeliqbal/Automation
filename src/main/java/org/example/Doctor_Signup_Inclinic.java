package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

import java.util.Optional;



public class Doctor_Signup_Inclinic {

    static  void Online_InclinicConsultation(WebDriver driver) throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@id='bordered-radio-2']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@class='bg-skin-button-primary text-skin-primary-white rounded p-2 h-search-bar hover:bg-skin-button-primary-hover text-sm w-full'][normalize-space()='Next']")).click();
        //--------------------------------PMDC No--------------------------------------------//
        driver.findElement(By.xpath("(//input[@class='text-sm mt-2 w-full h-[40px] md:w-[342px] px-2 rounded border border-[#cccccc]'])[1]")).sendKeys("00009-A");
        Thread.sleep(3000);

        //--------------------------------Mobile No--------------------------------------------//
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@placeholder='1 (702) 123-4567']")).sendKeys("309-5558042");

        //--------------------------------Next Button--------------------------------------------//
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Next']")).click();
        Thread.sleep(3000);
        //-------------------------------- Enter Your Details--------------------------------------------//
        //--------------------------------First Name-------------------------------------------//
        driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[3]//input[1]")).sendKeys("Arslan");
        Thread.sleep(3000);

        //--------------------------------Last Name-------------------------------------------//
        driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[4]//input[1]")).sendKeys("Ahmed");
        Thread.sleep(3000);

        //--------------------------------Speciality--------------------------------------------//
        driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[5]//div[1]//div[1]//div[1]//div[2]")).click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------Gender--------------------------------------------//
        driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[6]//div[1]//div[1]//div[1]//div[2]")).click();
        Thread.sleep(3000);
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.ENTER)).perform();



        //--------------------------------Years of Experience--------------------------------------------//
        WebElement experience = driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[7]/input[1]"));
        experience.sendKeys("17");
        Thread.sleep(3000);

        //--------------------------------Email Optional--------------------------------------------//
//        WebElement email = driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[6]//input[1]"));
//        email.sendKeys("nabeel123@gmail.com");
//        Thread.sleep(3000);


        //--------------------------------Button Register--------------------------------------------//
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        System.out.println("The value of button is" + button);
        button.click();
        Thread.sleep(3000);


        //--------------------------------Enter Clinic Details--------------------------------------------//
        WebElement clinic_name = driver.findElement(By.xpath("//body/div/main/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]"));
        System.out.println("The value of button is" + button);
        clinic_name.sendKeys("Hamza Clinic");
        Thread.sleep(3000);

        //--------------------------------City--------------------------------------------//
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//div[contains(@class,'css-19bb58m')]")).click();
        Actions keyDown1 = new Actions(driver);
        keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();

        //--------------------------------Phone No--------------------------------------------//
        WebElement ph_no = driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[4]//input[1]"));
        System.out.println("The value of button is" + button);
        ph_no.sendKeys("03095558042");
        Thread.sleep(3000);

        //--------------------------------Address--------------------------------------------//
        WebElement address = driver.findElement(By.xpath("//body//div//div[1]//div[1]//div[2]//div[1]//div[1]//form[1]//div[1]//div[6]//input[1]"));
        System.out.println("The value of button is" + button);
        address.sendKeys("DHAAAAAAAAAAAAA");
        Thread.sleep(3000);

        //--------------------------------Address--------------------------------------------//
        WebElement register_button = driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Register']"));
        System.out.println("The value of button is" + button);
        register_button.click();
        Thread.sleep(3000);

        //--------------------------------I agree Button--------------------------------------------//
        WebElement button2 = driver.findElement(By.xpath("//button[normalize-space()='I Agree']"));
        System.out.println("The value of button is" + button);
        button2.click();
        Thread.sleep(3000);

        //---------------------------------------OTP-----------------------------------------------//
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).submit();
        Thread.sleep(3000);









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
        driver.get("https://mareez-care.com/doctor/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//span[contains(@class,'text-primary-red font-semibold cursor-pointer hover:border-b-2 hover:border-primary-red')][normalize-space()='Register']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
        Online_InclinicConsultation(driver);
    }
}
