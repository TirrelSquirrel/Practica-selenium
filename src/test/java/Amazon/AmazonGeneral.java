package Amazon;

import Project.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonGeneral extends Base {

    By searchBar = By.id("twotabsearchtextbox");
    By cookies1 = By.id("a-autoid-0");
    By cookies2 = By.id("sp-cc-accept");
    By signinCard = By.id("rhf-container");
    By navAccount = By.id("nav-link-accountList");
    By myAccount = By.xpath("//a[@href='/gp/css/homepage.html/ref=nav_bb_ya']");


    String miCuenta = "Mi cuenta";
    By spans = By.tagName("span");
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
            return;
        } catch (Exception e) {
            System.out.println("Localizador de cookies no encontrado");
        }
        try{
            System.out.println("Buscando cookies Amazon " + cookies2);
            super.click(super.findElement(cookies2));
            return;
        } catch (Exception e) {
            System.out.println("Localizador de cookies no encontrado");
        }
    }

    public void inputSearch(String inputText) {
        super.type(inputText, searchBar);
        super.submit(searchBar);
    }

    public Boolean identifyScreen() {
        try{
            System.out.println("Comprobando si aparece panel de identificacion");
            return super.isDisplayed(signinCard);
        } catch (Exception e) {
            System.out.println("No he encontrado el elemento " + signinCard);
            return false;
        }
    }

    public void clickAccount() {
        if(super.isDisplayed(navAccount)) {
            super.click(navAccount);
        } else {
            //No logro que lo encuentre
            /*super.click(myAccount);*/
            super.click(super.findElement(miCuenta, super.findElements(spans)));

        }
    }
}
