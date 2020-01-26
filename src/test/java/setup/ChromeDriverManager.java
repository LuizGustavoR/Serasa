package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager {

    private static WebDriver webDriver;

    public static WebDriver createDriver() {

        if(webDriver == null) {

            // ChromeDriver used for chrome version 79
            System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");

            Map<String, Object> prefs = new HashMap<>();
            //Pass the argument 1 to allow and 2 to block
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();

        }

        return webDriver;

    }
}
