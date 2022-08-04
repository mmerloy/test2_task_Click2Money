import com.codeborne.selenide.Configuration;

/**
 *Тестирование скачивания картинки в Firefox
 */
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
