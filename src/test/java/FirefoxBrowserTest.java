import com.codeborne.selenide.Configuration;

public class FirefoxBrowserTest extends BrowserTest {

    public FirefoxBrowserTest(){
        super(BrowserType.Firefox);
    }

    @Override
    public void setUp() {
        super.setUp();
        Configuration.browserSize = "1250x900";
    }
}
