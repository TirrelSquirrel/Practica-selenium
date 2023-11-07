package Amazon;

import Project.Base;
import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AmazonSearchResultsPage extends AmazonGeneral {

    By dropdownSelect = By.name("s");
    By primeFilter = By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div/div/div/div[1]/ul/span/li/span/a/span\n");

    By xpathNameProducts =By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']");
    By xpathPriceProducts = By.xpath(".//span[@class='a-price']");

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
    public List<String> getProductsAndPrices() {
        List<String> names = super.getElementsText(super.findElements(xpathNameProducts));
        List<String> prices = super.getElementsText(super.findElements(xpathPriceProducts));
        List<String> productList = new ArrayList<String>();
        for (int i = 0; i < names.size(); i++) {
            productList.add((names.get(i) + " " + prices.get(i)));
        }
        return productList;
    }

/*
    public List<String> getAllProductsNames() {
        List<WebElement> elementList = super.findElements(xpathNameProducts);
        List<String> nameList = super.getElementsText(elementList);
        return nameList;
    }
    public List<String> getAllProductsPrices() {
        List<WebElement> elementList = super.findElements(xpathPriceProducts);
        List<String> priceList = super.getElementsText(elementList);
        return priceList;
    }
*/

    public void filterByPrime() {
        super.click(primeFilter);
        /*List<WebElement> links = super.findElements(spans);
        super.click(Utils.findInList("Envío gratis por Amazon", links));*/
    }
}
