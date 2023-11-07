package Google;

import Project.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleGeneral extends Base {
    By googleModal = By.id("L2AGLb");

    public GoogleGeneral(WebDriver driver) {
        super(driver);
    }

    public void googleModalAccept() {
        try {
            System.out.println("Buscando modal Google");
            super.click(super.findElement(googleModal));
        } catch (Exception e) {
            System.out.println("Modal no encontrado");
        }
    }
}
