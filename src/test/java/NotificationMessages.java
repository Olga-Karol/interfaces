import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

public class NotificationMessages extends BaseTest {

    static final String URL_PREFIX = "notification_message";

    @Test
    public void notificationMessagesTest() {

        driver.get(baseUrl + URL_PREFIX);
        driver.findElement(By.cssSelector(".example a")).click();
        String message = driver.findElement(By.cssSelector(".flash")).getText();
        assertEquals("Action successful\n" + "×", message);


    }
}

