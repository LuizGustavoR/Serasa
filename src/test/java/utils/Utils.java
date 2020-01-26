package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.ChromeDriverManager;

public class Utils {

    public static WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ChromeDriverManager.createDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
