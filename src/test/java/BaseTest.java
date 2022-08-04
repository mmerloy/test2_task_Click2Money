import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

/**
 * @author mmerloy
 * @version 0.0.1
 * @since 04.08.2022 23:59
 */
abstract public class BaseTest
{
    public enum BrowserType {
        Chrome,
        Firefox,
    }

    protected BaseTest(BrowserType browser)
    {
        switch (browser) {
            case Chrome -> {
                WebDriverManager.chromedriver().setup();
                Configuration.browser = "chrome";
            }
            case Firefox -> {
                WebDriverManager.firefoxdriver().setup();
                Configuration.browser = "firefox";
            }
        }
    }

    public void setUp()
    {
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1300x900";
        Configuration.headless = false;
    }

    @Before
    public void init()
    {
        setUp();
    }

    @After
    public void tearDown()
    {
        Selenide.closeWebDriver();
    }
}