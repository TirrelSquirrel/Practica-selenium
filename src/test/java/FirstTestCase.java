import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTestCase {

    //Declaro el webdriver para poder acceder a el desde todos los métodos
    public WebDriver driver = null;
    //Declaro la variable para el nombre de producto
    public String product = "Compresor eléctrico";


    //Antes de cualquier test inicializo el webdriver
    /*@BeforeTest
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }

    //Test en el que llamo a las funciones necesarias
    @Test
    void mainTest() {
*//*
        handleGoogle();
*//*
        *//*handleAmazonProduct();*//*
        *//*amazonSearch();*//*
        *//*filter("Precio: De menor a mayor");*//*
        takeData();
    }

    //Funcion para trabajar en google
    *//*void handleGoogle() {
        //Accedo a la url
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        //Acepto el modal
        try {
            System.out.println("Buscando modal google");
            driver.findElement(By.id("L2AGLb")).click();
        }catch (Exception e) {
            System.out.println("Modal no encontrado");
            System.out.println(e);
        }
        //Localizo la barra de búsqueda e introduzco el producto a buscar
        driver.findElement(By.tagName("textarea")).sendKeys(product);
        driver.findElement(By.tagName("textarea")).submit();

        iterar("a", "Amazon");
    }*//*

    *//*void iterar(String elementoBuscar, String texto) {
        //Creo una lista con todos los links
        List<WebElement> links = driver.findElements(By.tagName(elementoBuscar));
        //Compruebo los links hasta dar con uno que contenga la "Amazon" y accedo a él
        for (int i = 0; i < links.size(); i++) {
            String text = links.get(i).getText();
            if (text.contains(texto)) {
                links.get(i).click();
                break;
            }
        }
    }*//*

    *//*void generalPage() {
        System.out.println("General page");
*//**//*
        iterar("a", "Compresor");
*//**//*
    }*//*

*//*    void cookies(String id) {
        try{
            System.out.println("Buscando cookies");
            driver.findElement(By.id(id)).click();
        } catch (Exception e) {
            System.out.println("Modal de cookies no encontrado");
            System.out.println(e);
        }
    }*//*

*//*    void handleAmazonProduct() {
        String title = driver.getTitle();
        System.out.println(title);
        //Acepto las cookies

*//**//*        cookies("a-autoid-0");
        cookies("sp-cc-accept");

        // Compruebo en que página de amazon estoy
        if(title.contains("Compresores")) {
            generalPage();
        }*//**//*

        searchDeliveryandPrice();
    }*//*

*//*    private void searchDeliveryandPrice() {
        //Declaro las variables para el precio
        String priceWhole = driver.findElement(By.className("a-price-whole")).getText();
        String priceFraction = driver.findElement(By.className("a-price-fraction")).getText();

        //Busco en la página todos los spans, de los cuales selecciono en el que tenga el texto "Entrega GRATIS"
        //para posteriormente extraer la información de la fecha de entrega
        List<WebElement> links = driver.findElements(By.tagName("span"));
        for (int i = 0; i < links.size(); i++) {
            String text = links.get(i).getText();
            if (text.contains("Entrega GRATIS")) {
                String[] parts = text.split(",");
                text = parts[1];
                String[] date = text.split("\\.");
                System.out.println(priceWhole + "'" + priceFraction + "€");
                System.out.println(date[0]);
                break;
            }
        }
    }*//*

*//*    void amazonSearch() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        driver.findElement(By.id("twotabsearchtextbox")).submit();
    }*//*

*//*    void filter(String dropdownSelect) {
        *//**//*List<WebElement> links = driver.findElements(By.tagName("span"));

        System.out.println("Buscando enlace");
        for (int i = 0; i < links.size(); i++) {
            String text = links.get(i).getText();
            if (text.contains("Envío gratis por Amazon")) {
                System.out.println("Link found");
                links.get(i).click();
                break;
            }
        }*//**//*

        //Selecciono el dropdown y elijo el objetivo
        Select dropdown = new Select(driver.findElement(By.name("s")));
        dropdown.selectByVisibleText(dropdownSelect);
        driver.findElement(By.id("s-result-sort-select_1")).click();
    }*//*
    
    void takeData() {
        List<WebElement> elements;
        elements = driver.findElements(By.className("s-title-instructions-style"));
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i).getText());
        }
        List<String> titles;
        System.out.printf("");
    }

    //Una vez finalizados todos los tests cierro el navegador
    @AfterTest
    void tearDown() {
        driver.quit();
    }*/
}
