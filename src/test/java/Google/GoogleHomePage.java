package Google;

import Project.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GoogleHomePage extends GoogleGeneral {
    By searchBar = By.tagName("textarea");

    public GoogleHomePage(WebDriver driver){
        super(driver);
    }

    public void inputSearch(String inputText) {
        super.type(inputText, searchBar);
        super.submit(searchBar);
    }

}
