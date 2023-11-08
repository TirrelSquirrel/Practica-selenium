import Amazon.AmazonGeneral;
import Amazon.AmazonLoginPage;
import Amazon.AmazonRegisterPage;
import Project.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestRegistro {

    String name = "Antonio Bautista";
    String email = "lixelik936@eazenity.com";
    String password = "kijureta48";

    Base base;
    AmazonGeneral amazonGeneral;
    AmazonLoginPage amazonLoginPage;
    AmazonRegisterPage amazonRegisterPage;
    WebDriver driver;
    @BeforeClass
    public void setup() {
        base = new Base(driver);
        driver = base.chromeDriverConnection();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        base.visit("https://www.amazon.es");
    }
    @AfterClass
    public void teardown() {
        System.out.println("Test finalizado, cerrando navegador");
        base.tearDown();
    }

    @Test
    public void testRegistro() {
        amazonGeneral = new AmazonGeneral(driver);
        amazonGeneral.clickAccount();
        amazonLoginPage = new AmazonLoginPage(driver);
        amazonLoginPage.clickOnCreateAccount();
        amazonRegisterPage = new AmazonRegisterPage(driver);
        amazonRegisterPage.fillOutForm(name, email, password);
        amazonRegisterPage.confirmEmailButton();
        //No encuentra el boton
        amazonRegisterPage.startCaptcha();
    }
}
