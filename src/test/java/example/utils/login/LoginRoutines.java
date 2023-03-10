package example.utils.login;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class LoginRoutines {


    public static Boolean Login(WebDriver driver, String phoneNumber) throws InterruptedException {
        try {
            Thread.sleep(3000);
            driver.get("https://mareez-care.com/doctor/login");
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@placeholder='Enter phone number']"))
                    .sendKeys(phoneNumber);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@type='submitTT']")).click();
            Thread.sleep(3000);
            // OTP
            driver.findElement(By.xpath("//button[@type='submittttt']")).submit();
            Thread.sleep(6000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
