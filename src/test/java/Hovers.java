import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class Hovers extends BaseTest {
    static final String URL_PREFIX = "hovers";

    @Test
    public void hoversTest() {
        driver.get(baseUrl + URL_PREFIX);

        for (int i = 1; i < 4; i++) {
        WebElement User = driver.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][" + i + "]"));
        Actions hoverAction = new Actions(driver);
        hoverAction.moveToElement(User).build().perform();
        WebElement userName = driver.findElement(By.xpath("//h5[text()='name: user" + i + "']"));
        WebElement link = driver.findElement(By.xpath("//h5[text()='name: user" + i + "']/following-sibling::a"));
        Assert.assertTrue(userName.isDisplayed(), "Username is not shown");
        link.click();
        WebElement verifyPage = driver.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(verifyPage.isDisplayed(), "404 page should open");
        driver.navigate().back();
        }

    }
}
