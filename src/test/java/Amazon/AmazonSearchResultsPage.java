package Amazon;

import Project.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonSearchResultsPage extends AmazonGeneral {

    By dropdownSelect = By.name("s");

    public AmazonSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void getFirstResult(String text) {
        super.searchLinkAndClickOne(text);
    }

    public void filterDropdownSelect(String optionText, By locator) {
        super.getDropdown(dropdownSelect).selectByVisibleText(optionText);
        //super.click(locator);
    }
}
