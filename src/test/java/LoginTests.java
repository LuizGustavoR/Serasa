import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.ChromeDriverManager;

public class LoginTests {

    private static WebDriver driver;
    private static final String BASE_URL = "https://www.serasaconsumidor.com.br";

    private static LoginPage loginPage;

    @BeforeClass
    public static void setUpTest() {
        driver = ChromeDriverManager.createDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public static void tearDownTest() {
        driver.quit();
    }

    @Test(priority = 1)
    public void confirm_without_cpf() {

        driver.get(BASE_URL);

        loginPage.clickBtnLogin();
        loginPage.clickBtnConfirm();
        Assert.assertEquals(loginPage.getLblText(), "Por favor preencha seu CPF.");

    }

    @Test(priority = 2)
    public void confirm_invalid_cpf() {

        driver.get(BASE_URL);

        loginPage.clickBtnLogin();
        loginPage.setCPF("41390278869");
        loginPage.clickBtnConfirm();
        Assert.assertEquals(loginPage.getLblText(), "Você precisa informar um CPF válido.");

    }

    @Test(priority = 3)
    public void confirm_valid_cpf() {

        driver.get(BASE_URL);

        loginPage.clickBtnLogin();
        loginPage.setCPF("41390278867");
        loginPage.clickBtnConfirm();
        Assert.assertTrue(loginPage.isLblFillPasswordDisplayed());

    }

}
