package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        try {
           
            String hubURL = "http://172.21.0.244:4444";

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            System.out.println("Connecting to Grid at: " + hubURL);

            driver.set(new RemoteWebDriver(new URL(hubURL), options));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not create WebDriver session. Check Grid URL.");
        }
        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
