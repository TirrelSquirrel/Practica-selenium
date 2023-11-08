package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonRegisterPage extends AmazonGeneral{
    By userName = By.id("ap_customer_name");
    By userEmail = By.id("ap_email");
    By userPass = By.id("ap_password");
    By userPassCheck = By.id("ap_password_check");
    By confirmEmail = By.id("auth-continue");
    By iframe = By.id("game-core-frame");
    String frameID = "game-core-frame";
    By button = By.tagName("button");
    String startCaptchaText = "Comenzar rompecabezas";
    //By startCaptchaButton = By.xpath(".//span[@class='sc-nkuzb1-0 sc-d5trka-0 eZxMRy button']");
    By startCaptchaButton = By.xpath("/html/body/div[1]/div/div[1]/button");

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
        super.switchToIFrame(0);
        //Aqui no encuentra el boton
        System.out.println(super.isDisplayed(button));
        super.click(button);
    }
}
