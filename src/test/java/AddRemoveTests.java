import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;
import static org.testng.Assert.assertEquals;


public class AddRemoveTests extends BaseTest {

    static final String URL_PREFIX = "add_remove_elements/";


    @Test
        public void addRemoveCheckQuantity() {
            driver.get(baseUrl + URL_PREFIX);
            By addButton = By.xpath("//button[text()='Add Element']");
            driver.findElement(addButton).click();
            driver.findElement(addButton).click();
            driver.findElement(By.className("added-manually")).click();
            int deletedButtonsQuantity = driver.findElements(By.className("added-manually")).size();
            assertEquals(deletedButtonsQuantity, 1, "One button should be left");
        }
}

