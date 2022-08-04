import com.codeborne.selenide.Configuration;

/**
 *Тестирование скачивания картинки в Chrome
 */
public class ChromeBrowserTest extends BrowserTest {

    public ChromeBrowserTest(){
        super(BrowserType.Chrome);
    }

    @Override
    public void setUp() {
        super.setUp();
        Configuration.browserSize = "1600x900";
    }
}
