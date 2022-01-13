import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;


public class Dropdown extends BaseTest {

    static final String URL_PREFIX = "dropdown";

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        driver.get(baseUrl + URL_PREFIX);
    }

    @Test
    public void dropDownAvailableOptionsTest() {
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        int optionsNumber = dropDown.getOptions().size();
        Assert.assertEquals(optionsNumber, 3, "3 options are available");
        }

    @Test
    public void dropDownCheckOptionsTest() {
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        for (int i = 1; i < dropDown.getOptions().size(); i++) {
            WebElement option = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='" + i + "']"));
            option.click();
            Assert.assertEquals(option.isSelected(), true, "Option " + i + " is selected");
        }
    }
}
