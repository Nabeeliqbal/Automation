package example.utils.login;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

public class LoginRoutines {


    public static Boolean Doctor_Login(WebDriver driver, String phoneNumber) throws InterruptedException {
        try {
            Thread.sleep(3000);
            driver.get("https://mareez-care.com/doctor/login");
            driver.manage().window().maximize();
            driver.navigate().refresh();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"))
                    .sendKeys(phoneNumber);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);
            // OTP
            driver.findElement(By.xpath("//button[@type='submit']")).submit();
            Thread.sleep(6000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean Doctor_Signup_Details(WebDriver driver, String pmdc, String phoneNumber) throws InterruptedException {
        try {
            Thread.sleep(3000);
            driver.get("https://mareez-care.com/doctor/login");
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[normalize-space()='Sign Up'][1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='bordered-radio-2']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);

            //--------------------------------PMDC No--------------------------------------------//
            driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("pmdc");
            Thread.sleep(3000);

            //--------------------------------Mobile No--------------------------------------------//
            driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys(" 3045071854");

            //--------------------------------Continue Button--------------------------------------------//
            driver.findElement(By.xpath("//button[@type='submit']")).submit();
            Thread.sleep(3000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean Doctor_Signup_Clinic_Details(WebDriver driver, String pmdc, String phoneNumber) throws InterruptedException {
        try {
            Thread.sleep(3000);
            driver.get("https://mareez-care.com/doctor/login");
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[normalize-space()='Sign Up'][1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//button[contains(@class,'border border-[#FF8109] text-[#FF8109] hover:bg-[#FF8109] hover:text-white font-medium rounded-full w-[122px] h-[41px] text-[16px]')])[1]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@id='bordered-radio-2']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);

            //--------------------------------PMDC No--------------------------------------------//
            driver.findElement(By.xpath("//input[@placeholder='PMDC#/Medical Registration Number']")).sendKeys("pmdc");
            Thread.sleep(3000);

            //--------------------------------Mobile No--------------------------------------------//
            driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys(" 3045071854");

            //--------------------------------Continue Button--------------------------------------------//
            driver.findElement(By.xpath("//button[@type='submit']")).submit();
            Thread.sleep(3000);
            //--------------------------------First Name-------------------------------------------//
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Iqra");
            Thread.sleep(3000);

            //--------------------------------Last Name-------------------------------------------//
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Qayoom");
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


            //--------------------------------Continue Button--------------------------------------------//
            WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
            button.submit();
            Thread.sleep(3000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean PatientLogin(WebDriver driver, String phoneNumber) throws InterruptedException {
        try {
            Thread.sleep(3000);
            driver.get("https://mareez-care.com/patient/login");
            driver.manage().window().maximize();
            driver.navigate().refresh();
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/div/div/main/div/div/div/div[2]/div/div/form/div/div[2]/div[1]/div[1]/input")).sendKeys("abc");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"))
                    .sendKeys(phoneNumber);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@type='submit']")).submit();
            Thread.sleep(3000);
            // OTP
            driver.findElement(By.xpath("//button[@type='submit']")).submit();
            Thread.sleep(6000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
