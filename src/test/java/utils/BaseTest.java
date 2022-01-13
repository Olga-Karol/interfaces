package utils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    public ChromeDriver driver;
    static final String KEY_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    static final String VALUE_SYSTEM_PROPERTY = "src/test/resources/chromedriver.exe";
    protected String baseUrl= "http://the-internet.herokuapp.com/";


    @BeforeClass
    public void setUp() {
        System.setProperty(KEY_SYSTEM_PROPERTY, VALUE_SYSTEM_PROPERTY);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }

   @AfterClass
    public void tearDown(){
        driver.quit();
    }

}


