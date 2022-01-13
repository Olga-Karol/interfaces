import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.AssertJUnit.assertEquals;


public class Inputs extends BaseTest {
    static final String URL_PREFIX = "inputs";

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        driver.get(baseUrl + URL_PREFIX);
        driver.navigate().refresh();
    }

    @Test
    public void inputsArrowDownKeysTest() {
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String upKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals("Input value is 1", "1", upKeyResult);
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        String downKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals("Input value is -1", "-1", downKeyResult);
    }

    @Test
    public void inputsManualNumbersTest() {
        driver.navigate().refresh();
        driver.findElement(By.tagName("input")).sendKeys("-55");
        String actualResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals("Input value is -55",  "-55", actualResult);
    }

    @Test
    public void inputsManualTextTest() {
        driver.findElement(By.tagName("input")).sendKeys("no numbers");
        String actualResult = driver.findElement(By.tagName("input")).getAttribute("value");
        assertEquals("Text is not entered",  "", actualResult);
    }

}

