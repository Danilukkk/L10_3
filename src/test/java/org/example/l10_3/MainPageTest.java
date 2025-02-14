package org.example.l10_3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    private AndroidDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        var options = new UiAutomator2Options()
                .amend("appium:app", "C:\\Users\\Fedya\\Downloads\\Outline_1.15.0_APKPure.apk")
                .amend("platformName", "Android")
                .amend("appium:deviceName", "test")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600) // Тут можно оставить число, Appium поймёт
                .amend("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(getUrl(), options);
        mainPage = new MainPage(driver);
    }

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void sampleTest() {
    assertTrue(mainPage.contentCheck());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
