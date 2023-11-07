package Utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {

    public static WebElement findInList(String searchText, List<WebElement> lista) {
        for(int i = 0; i < lista.size(); ++i) {
            String text = ((WebElement)lista.get(i)).getText();
            if (text.contains(searchText)) {
                return lista.get(i);
            }
        }
        return null;
    }
}
