package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div/header/div/div[3]/button")
    private WebElement btnLogin;

    @FindBy(id = "cpf")
    private WebElement txtCpfField;

    @FindBy(xpath = "//*[@id=\"valgrind\"]/div/div[2]/div/div/form/button")
    private WebElement btnConfirm;

    @FindBy(xpath = "//*[@id=\"valgrind\"]/div/div[2]/div/div/form/div/small")
    private WebElement lblMessage;

    @FindBy(xpath = "//*[@id=\"valgrind\"]/div/div[2]/div/div/h4")
    private WebElement lblFillPassword;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void clickBtnLogin(){
        Utils.waitForElement(btnLogin);
        btnLogin.click();
    }

    public void setCPF(String cpf){
        Utils.waitForElement(txtCpfField);
        txtCpfField.sendKeys(cpf);
    }

    public void clickBtnConfirm(){
        Utils.waitForElement(btnConfirm);
        btnConfirm.click();
    }

    public String getLblText(){
        Utils.waitForElement(lblMessage);
        return lblMessage.getText();
    }

    public boolean isLblFillPasswordDisplayed(){
        Utils.waitForElement(lblFillPassword);
        return lblFillPassword.isDisplayed();
    }

}
