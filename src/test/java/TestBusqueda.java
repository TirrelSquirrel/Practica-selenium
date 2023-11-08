import Amazon.AmazonGeneral;
import Amazon.AmazonProductPage;
import Amazon.AmazonSearchResultsPage;
import Google.GoogleGeneral;
import Google.GoogleHomePage;
import Google.GoogleSearchPage;
import Project.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestBusqueda {
    Base base;
    GoogleGeneral googleGeneral;
    GoogleSearchPage googleSearchPage;
    GoogleHomePage googleHomePage;

    AmazonGeneral amazonGeneral;
    AmazonProductPage amazonProductPage;
    AmazonSearchResultsPage amazonSearchResultsPage;

    private WebDriver driver;
    By lowToHighPriceDropdown = By.id("s-result-sort-select_1");

    String producto = "Compresor eléctrico";

    @BeforeClass
    public void setup() {
        base = new Base(driver);
        driver = base.chromeDriverConnection();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        base.visit("https://www.google.com");
    }
    @AfterClass
    public void teardown() {
        System.out.println("Test finalizado, cerrando navegador");
        base.tearDown();
    }

    @Test
    public void testBusqueda() {
        googleGeneral = new GoogleGeneral(driver);
        googleGeneral.googleModalAccept();
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.inputSearch(producto);
        base.searchLinkAndClickOne("Amazon");
        amazonGeneral = new AmazonGeneral(driver);
        amazonGeneral.acceptCookies();
        if (amazonGeneral.identifyScreen()) {
            System.out.println("Encontrado panel de identificacion");
            amazonGeneral.inputSearch(producto);}
        if(amazonGeneral.isOnMain("Compresores")) {base.searchLinkAndClickOne("Compresor");}
        amazonProductPage = new AmazonProductPage(driver);
        System.out.println(amazonProductPage.getDeliveryDate());
        System.out.println(amazonProductPage.getPrice());
        amazonGeneral.inputSearch(producto);
        amazonSearchResultsPage = new AmazonSearchResultsPage(driver);
        amazonSearchResultsPage.filterDropdownSelect("Precio: De menor a mayor", lowToHighPriceDropdown);
        amazonSearchResultsPage.filterByPrime();
        System.out.print(amazonSearchResultsPage.getProductsAndPrices());
        System.out.println("Test finalizado con exito");
    }


}
