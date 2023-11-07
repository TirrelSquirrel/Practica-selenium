package Amazon;

import Project.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonGeneral extends Base {

    By searchBar = By.id("twotabsearchtextbox");
    By cookies1 = By.id("a-autoid-0");
    By cookies2 = By.id("sp-cc-accept");
    public AmazonGeneral(WebDriver driver) {
        super(driver);
    }

    public Boolean isOnMain(String title) {
        if(super.getTitle() == title) {
            return true;
        } else {
            return false;
        }
    }

    public void acceptCookies() {
        try{
            System.out.println("Buscando cookies Amazon " + cookies1);
            super.click(super.findElement(cookies1));
        } catch (Exception e) {
            System.out.println("Localizador de cookies no encontrado");
        }
        try{
            System.out.println("Buscando cookies Amazon " + cookies2);
            super.click(super.findElement(cookies2));
        } catch (Exception e) {
            System.out.println("Localizador de cookies no encontrado");
        }
    }

    public void inputSearch(String inputText) {
        super.type(inputText, searchBar);
        super.submit(searchBar);
    }
}
