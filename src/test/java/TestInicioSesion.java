import Amazon.AmazonGeneral;
import Amazon.AmazonLoginPage;
import Amazon.AmazonRegisterPage;
import Project.Base;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestInicioSesion {
    Dotenv dotenv = Dotenv.load();
    String email = dotenv.get("USEREMAIL");
    String password = dotenv.get("USERPASS");

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
    public void testInicioSesion() {
        amazonGeneral = new AmazonGeneral(driver);
        amazonGeneral.clickAccount();
        amazonLoginPage = new AmazonLoginPage(driver);
        amazonLoginPage.typeEmail(email);
        amazonLoginPage.clickOnContinue();
        amazonLoginPage.typePassword(password);
        //Aqui con mi cuenta me manda un código al movil por la autentificación en dos pasos
        //Una vez introducido el código termina de acceder
    }
}
