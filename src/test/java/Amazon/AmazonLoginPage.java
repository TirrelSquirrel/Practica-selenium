package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonLoginPage extends AmazonGeneral{
    By userEmail = By.id("ap_email");
    By userPass = By.id("ap_password");

    By continueButton = By.id("continue");
    By createAccountButton = By.id("createAccountSubmit");
    public AmazonLoginPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnContinue() {
        super.click(continueButton);
    }
    public void clickOnCreateAccount() {
        super.click(createAccountButton);
    }

    public void typeEmail(String email) {
        super.type(email, userEmail);
    }
    public void typePassword(String password) {
        super.type(password, userPass);
    }
}
