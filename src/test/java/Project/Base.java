package Project;

import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Base {
    By links = By.tagName("a");


    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection() {
        driver = new ChromeDriver();
        return  driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    public WebElement findElement(String text, List<WebElement> elementList) {
        return Utils.findInList(text, elementList);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public List<String> getElementsText(List<WebElement> elementList) {
        List<String> textList = new ArrayList<String>();
        for (int i = 0; i < elementList.size(); i++){
            textList.add(elementList.get(i).getText());
        }
        return textList;
    }

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void submit(By locator) {
        driver.findElement(locator).submit();
    }

    public Select getDropdown(By locator) {
        return new Select(driver.findElement(locator));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public void click(WebElement element) {element.click();}

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchLinkAndClickOne(String linkText) {
        List<WebElement> linkList = findElements(links);
        try {
            WebElement link = Utils.findInList(linkText, linkList);
            click(link);
        } catch (Exception e) {
            System.out.println("Texto no encontrado en lista de elementos " + linkText);
            throw e;
        }
    }

    public void switchToIFrame(int index) {
        waitUntilElementIsVisible(By.tagName("iframe"), 60);
        driver.switchTo().frame(index);
    }

    public void exitIFrame() {
        driver.switchTo().defaultContent();
    }

    public void waitUntilElementIsVisible(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean isDisplayed(By locator){
        try {
            driver.findElement(locator).isDisplayed();
            return true;
        } catch (Exception e) {
            System.out.println("Element not found" + locator);
            return false;
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void tearDown() {
        driver.quit();
    }
 }
