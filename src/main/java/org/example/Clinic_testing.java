package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.Request;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.Optional;

public class Clinic_testing {

    static int tryNumberOfDates = 2;

    private static boolean isAttributePresent(WebElement element, String attribute) {
        boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {

        }

        return result;
    }

    static boolean createSingleAppointment(WebDriver driver, int doctorElementIndex)  throws InterruptedException {
        // Set Name and number
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("Nabeel");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"))
                .sendKeys("03095558054");
        Thread.sleep(3000);

        WebElement d2 = driver.findElement(By.xpath("//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-gi940b']"));
        d2.click();
        Thread.sleep(3000);
        List<WebElement> doctorList2 = driver.findElements(By.cssSelector("li[role='option']"));
        doctorList2.get(doctorElementIndex).click();
        Thread.sleep(3000);

        for (int j = 0; j<tryNumberOfDates; j++) {
            WebElement e1 = driver.findElement(By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[4]"));
            e1.click();

            Thread.sleep(3000);
            Actions click3 = new Actions(driver);

            WebElement datesGrid = driver.findElement(By.cssSelector("div[role='grid']"));

            List<WebElement> calendarRows = datesGrid.findElements(By.cssSelector("div[role='row']"));

            boolean  foundDate = false;
            for (WebElement calendarRow: calendarRows) {
                if (foundDate) {
                    break;
                }
                List<WebElement> dateButtons = calendarRow.findElements(By.cssSelector("button[tabIndex='-1']"));
                System.out.println(dateButtons.size());


                for (WebElement button: dateButtons) {
                    System.out.println(button.getAttribute("disabled"));
                    if (!isAttributePresent(button, "disabled")) {
                        foundDate = true;
                        button.click();
                        Thread.sleep(3000);
                        break;
                    }
                }

            }


            Thread.sleep(3000);

            // Click on time slot
            driver.findElement(By.xpath("//body[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]")).click();
            List<WebElement> timeSlots = driver.findElements(By.cssSelector("li[role='option']"));
            for (int k = 0; k< timeSlots.size(); k++) {

                List<WebElement> timeSlots2 = driver.findElements(By.cssSelector("li[role='option']"));
                timeSlots2.get(k).click();

                Thread.sleep(3000);
                // Submit appointment form
                driver.findElement(By.xpath("//button[@type='submit']")).submit();
                Thread.sleep(3000);

                boolean success = driver.findElements(By.xpath("(//h2[normalize-space()='Create Appoinment'])[1]")).isEmpty();
                // If Appointment booking Failed check for Error message
                if (success) {
                    return true;
                }
                if (k + 1 != timeSlots.size() ) {
                    driver.findElement(By.xpath("//body[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/div[1]")).click();
                }
                Thread.sleep(3000);
            }


            Thread.sleep(6000);

        }
        return false;
    }

    static void CreateAppointments(WebDriver driver, int numberOfAppointments) throws InterruptedException
    {
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.xpath("//span[normalize-space()='Appointments']"));
        a.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Create Appointment']")).click();
        Thread.sleep(3000);



        // Select Doctor
        driver.findElement(By.xpath("//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-gi940b']")).click();
        Thread.sleep(2000);
        List<WebElement> doctorList = driver.findElements(By.cssSelector("li[role='option']"));
        Thread.sleep(2000);
        doctorList.get(0).click();
        Thread.sleep(2000);

        // Iterate over Available doctors
        for (int k = 5; k< doctorList.size(); k++) {

            for (int i = 0; i< 2; i++) {
                boolean isAppointmentCreated = createSingleAppointment(driver, k);
                if (isAppointmentCreated && i + 1 != 2 ) {
                    driver.findElement(By.xpath("//button[normalize-space()='Create Appointment']")).click();
                    Thread.sleep(3000);
                }
                Thread.sleep(3000);
            }
            if (k + 1 != doctorList.size()) {
                driver.findElement(By.xpath("//button[normalize-space()='Create Appointment']")).click();
                Thread.sleep(3000);
            }

        }
        Thread.sleep(3000);

    }


    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver();

        // Set up Network to access api response
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        // Add Listener to receive API call response
        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            RequestId req = response.getRequestId();
            if (res.getStatus() == 200 && res.getUrl().equals("https://www.e-mareez.com/api/auth/send-verification-code")) {
                System.out.println(res.getUrl());
                String  responseBody = devTools.send(Network.getResponseBody(req)).getBody();

                JsonObject jsonObject1 = (JsonObject) JsonParser.parseString(responseBody);
                String accessToken = jsonObject1.get("data").getAsJsonObject().get("temp_token").getAsString();
                driver.findElement(By.cssSelector("input[class='w-[265px] px-2 py-2 bg-white border border-slate-300 rounded-md text-sm shadow-sm placeholder-slate-400 focus:outline-none focus:border-gray-300 focus:ring-1 focus:ring-gray-300']")).sendKeys(accessToken);
            }
            ;
        });


        driver.get("https://e-mareez.com/clinic-management-system/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@placeholder='03XXXXXXXXX']"))
                .sendKeys("03045071855");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Submit']")).submit();
        // OTP
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).submit();
        Thread.sleep(9000);

        CreateAppointments(driver, 5);

    }
}




