package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://e-mareez.com/doctor/login");

        driver.manage().window().maximize();

        //-----------------------Mobile No--------------------//
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//input[@placeholder='03XXXXXXXXX']")).sendKeys("03469600178");
        driver.findElement(By.xpath("//div[@class='flex flex-col m-auto']//button[@type='submit'][normalize-space()='Submit']")).click();
        //-----------------------OTP--------------------//
        Thread.sleep(15000);
        driver.findElement(By.xpath("//button[normalize-space()='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@aria-label='show more']//*[name()='svg']")).click();
        Thread.sleep(3000);

        //-----------------------Profile--------------------//
        driver.findElement(By.xpath("//li[normalize-space()='Profile']")).click();
        Thread.sleep(3000);

        //-----------------------Edit Profile--------------------//
        driver.findElement(By.xpath("//div[@class='MuiGrid-root MuiGrid-item css-1wxaqej']//img[@aria-label='Edit']")).click();
        Thread.sleep(3000);

        //-----------------------City--------------------//
        WebElement d1 = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        d1.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE );
        Thread.sleep(3000);
        d1.sendKeys("Islamabad");
        Thread.sleep(3000);

        //-----------------------Email--------------------//
        WebElement d2 = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        d2.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,
                Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE );
        Thread.sleep(3000);
        d2.sendKeys("kaleem123@gmail.com");
        Thread.sleep(3000);

        //-----------------------Profile Pic--------------------//
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='contained-button-file']"));
        chooseFile.sendKeys("/Users/nabeeliqbal/Downloads/tags.png");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();





        //------------------------------------------------TC_E-Mareez_002-------------------------------------------------//
        //-----------------------Select Clinic--------------------//
        driver.findElement(By.xpath("//div[normalize-space()='Neuro']")).click();
        Thread.sleep(2000);
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        //-----------------------Edit Fees(Online Consultation))--------------------//
        driver.findElement(By.xpath("//div[@id='Fee']//img[@aria-label='Edit']")).click();
        Thread.sleep(2000);
        WebElement fees = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        fees.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        fees.sendKeys("1800");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);

        //-----------------------Edit Fees(Clinic))--------------------//
        WebElement dropdown = driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.MuiInputBase-inputSizeSmall.css-18fhp38"));
        dropdown.click();
        Thread.sleep(2000);
        Actions keyDown2 = new Actions(driver);
        keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='Fee']//img[@aria-label='Edit']")).click();
        Thread.sleep(2000);
        WebElement fees2 = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        fees2.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        fees2.sendKeys("2800");
        Thread.sleep(3000);

        //-----------------------Add Button--------------------//
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);


        //------------------------------------------------TC_E-Mareez_003---------------------------------------------//

        //-----------------------Scroll Down--------------------//
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)", "");
        Thread.sleep(3000);

        //-----------------------Edit Education--------------------//
        driver.findElement(By.xpath("//div[@id='Education']//img[@aria-label='Edit']")).click();
        Thread.sleep(3000);
        WebElement univeristy_dropdown = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        univeristy_dropdown.click();
        Thread.sleep(3000);
        Actions select_univeristy = new Actions(driver);
        select_univeristy.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        WebElement qualification = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(2) > input:nth-child(1)"));
        qualification.sendKeys("Med");
        Thread.sleep(3000);
        driver.findElement(By.xpath
                ("//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-gi940b']")).click();
        Actions passing_year = new Actions(driver);
        passing_year.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        driver.findElement(By.xpath
                ("//tbody/tr[2]/td[3]/img[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath
                ("//*[name()='path' and contains(@d,'M19 6.41 1')]")).click();


//------------------------------------------------TC_E-Mareez_005-----------------------------------------------------//

        //-----------------------Scroll Down--------------------//
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,800)", "");
        Thread.sleep(3000);

        //-----------------------Edit About--------------------//
        driver.findElement(By.xpath("//div[@id='About']//img[@aria-label='Edit']")).click();
        Thread.sleep(3000);
        WebElement about = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > textarea:nth-child(1)"));
        about.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        about.sendKeys("MBBS");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

//------------------------------------------------TC_E-Mareez_006-----------------------------------------------------//

        //-----------------------Scroll Down--------------------//
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,1400)", "");
        Thread.sleep(3000);

        //-----------------------Bank Details--------------------//
        driver.findElement(By.xpath("//div[@id='Bank Details']//img[@aria-label='Edit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='mui-component-select-bank_name']")).click();
        Actions bank_name = new Actions(driver);
        bank_name.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        WebElement account_title = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        account_title.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE);
        account_title.sendKeys("Kaleem");
        Thread.sleep(3000);
        WebElement account_no = driver.findElement(By.cssSelector
                ("body > div:nth-child(4) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        account_no.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        account_no.sendKeys("545444554685812");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

//------------------------------------------------TC_E-Mareez_007-----------------------------------------------------//


        //-----------------------Availability--------------------//
        WebElement dropdown3 = driver.findElement(By.cssSelector(".MuiSelect-select.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input.MuiInputBase-inputSizeSmall.css-18fhp38"));
        dropdown3.click();
        Actions keyDown4 = new Actions(driver);
        keyDown4.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='MuiBox-root css-us80gu']//img[@aria-label='Edit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[normalize-space()='Sunday']")).click();
        Thread.sleep(3000);
        Actions set_day = new Actions(driver);
        set_day.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER),Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='menu-']//div[@class='MuiBackdrop-root MuiBackdrop-invisible css-esi9ax']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(3000);
        Actions set_strat_time = new Actions(driver);
        set_strat_time.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]")).click();
        Actions set_time_type = new Actions(driver);
        set_time_type.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]")).click();
        Actions set_end_time = new Actions(driver);
        set_end_time.sendKeys(Keys.chord(Keys.DOWN,  Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[2]/div[1]/div[1]")).click();
        Actions set_endtime_type = new Actions(driver);
        set_endtime_type.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//tbody/tr[13]/td[2]/img[1]")).click();
//
//        Thread.sleep(3000);


        //-----------------------Unavailability--------------------//
        driver.findElement(By.xpath("//h6[normalize-space()='Set unavailability']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='MuiBox-root css-1krhn11']//div[1]//div[1]//div[1]//button[1]//*[name()='svg']")).click();
        Thread.sleep(3000);
        Actions select_date = new Actions(driver);
        select_date.sendKeys(Keys.chord(Keys.RIGHT, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='MuiBox-root css-1svof0w']//div[2]//div[1]//div[1]//button[1]//*[name()='svg']")).click();
        Thread.sleep(3000);
        Actions select_end_date = new Actions(driver);
        select_end_date.sendKeys(Keys.chord(Keys.RIGHT, Keys.RIGHT, Keys.ENTER)).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/img[1]")).click();
    }
}