import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;


abstract public class BaseTest
{

//    public enum BrowserType {
//        Chroum,
//        Firefox,
//    }

    public void setUp()//add javaDoc and comments
    {
       // chooseBrowser();?
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1600x900";
        Configuration.headless = true;
    }

//    protected void chooseBrowser(BrowserType browser)
//    {
//        switch (browser) {
//            case Chroum -> {
//                WebDriverManager.chromedriver().setup();
//                Configuration.browser = "chrome";
//            }
//            case Firefox -> {
//                WebDriverManager.firefoxdriver().setup();
//                Configuration.browser = "firefox";
//            }
//        }
//    }

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