import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.Assert.assertEquals;

public class Typos extends BaseTest {

    static final String URL_PREFIX = "typos";

    @Test
    public void checkTyposTest() {
        driver.get(baseUrl + URL_PREFIX);
        for (int i = 0; i < 10; i++) {
            driver.navigate().refresh();
            String text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();
            assertEquals(text, "Sometimes you'll see a typo, other times you won't.", "Error: the word 'won,t' is misspelled");
        }
    }
}
