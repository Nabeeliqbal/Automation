package example.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;

import java.util.Optional;

public class ChromeUtils {


    public static WebDriver getChromeDriverDev(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--remote-allow-origins=*");
        opt.addArguments("--window-size=1920,1080");
        opt.addArguments("--disable-dev-shm-usage");
//        opt.addArguments("--headless");
        return new ChromeDriver(opt);
    }

    public static WebDriver getChromeDriverProd(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--remote-allow-origins=*");
        opt.addArguments("--window-size=1920,1080");
        opt.addArguments("--disable-dev-shm-usage");
        opt.addArguments("--headless");

        return new ChromeDriver(opt);
    }
//
//    public static JsonObject getNetworkCallResponse(WebDriver driver, int status, String url) {
//        DevTools devTools = ((ChromeDriver) driver).getDevTools();
//        devTools.createSession();
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//        // Add listener to receive API cal response
//        devTools.addListener(Network.responseReceived(), response ->
//        {
//            Response res = response.getResponse();
//            RequestId req = response.getRequestId();
//            if (res.getStatus() == status && res.getUrl().equals(url)) {
//                System.out.println(res.getUrl());
//                String responseBody = devTools.send(Network.getResponseBody(req)).getBody();
//
//                JsonObject jsonObject1 = (JsonObject) JsonParser.parseString(responseBody);
//            }
//        });
//        return null;
//    }

}
