package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonRegisterPage extends AmazonGeneral{
    By userName = By.id("ap_customer_name");
    By userEmail = By.id("ap_email");
    By userPass = By.id("ap_password");
    By userPassCheck = By.id("ap_password_check");
    By buttons = By.tagName("button");
    By confirmEmail = By.id("auth-continue");
    String startCaptchaText = "Comenzar rompecabezas";
    By startCaptchaButton = By.xpath(".//span[@class='sc-nkuzb1-0 sc-d5trka-0 eZxMRy button']");

    public AmazonRegisterPage(WebDriver driver) {
        super(driver);
    }

    public void fillOutForm(String name, String email, String password) {
        super.type(name, userName);
        super.type(email, userEmail);
        super.type(password, userPass);
        super.type(password, userPassCheck);
    }

    public void confirmEmailButton() {
        super.click(confirmEmail);
    }

    public void startCaptcha() {
        /*super.click(startCaptchaButton);*/
        super.click(super.findElement(startCaptchaText, super.findElements(buttons)));
    }
}