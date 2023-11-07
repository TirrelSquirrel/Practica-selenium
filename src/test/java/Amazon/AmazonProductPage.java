package Amazon;

import Project.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonProductPage extends AmazonGeneral {
    By priceWhole = By.className("a-price-whole");
    By priceFraction = By.className("a-price-fraction");
    By spans = By.tagName("span");
    public AmazonProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        return (super.getText(priceWhole) + "," + super.getText(priceFraction) + "€");
    }

    public String getDeliveryDate() {
        List<WebElement> links = super.findElements(spans);
        for (int i = 0; i < links.size(); i++) {
            String text = super.getText(links.get(i));
            if (text.contains("Entrega GRATIS")) {
                String[] parts = text.split(",");
                text = parts[1];
                String[] date = text.split("\\.");
                return date[0];
            }
        }
        return null;
    }
}
