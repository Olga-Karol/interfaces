import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Tables extends BaseTest {

    static final String URL_PREFIX = "tables";

    @Test
    public void checkTableTest() {
        driver.get(baseUrl + URL_PREFIX);
        List<WebElement> johnSmith = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        for (WebElement element : johnSmith) {
            assertEquals("Smith should be shown","Smith", johnSmith.get(0).getText());
            assertEquals("John should be shown", "John", johnSmith.get(1).getText());
            assertEquals("jsmith@gmail.com should be shown", "jsmith@gmail.com", johnSmith.get(2).getText());
            assertEquals("$50.00 should be shown", "$50.00",  johnSmith.get(3).getText());
            assertEquals("http://www.jsmith.com should be shown", "http://www.jsmith.com", johnSmith.get(4).getText());
            assertEquals("edit delete should be shown", "edit delete", johnSmith.get(5).getText());
        }
    }
}
