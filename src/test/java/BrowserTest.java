import org.junit.Test;

import java.io.IOException;

/**
 *Тестирование скачивания картинки в браузере
 */
public abstract class BrowserTest extends BaseTest
{
    private final static String BASE_URL = "https://www.google.com/";
    private final static String SEARCH_STRING = "свое имя фамилия";

    public BrowserTest(BrowserType type){
        super(type);
    }

    @Test
    public void searchImage() throws IOException {
        MainPage mainPage = new MainPage(BASE_URL);
        mainPage.search(SEARCH_STRING)
                .openImagesTab()
                .clickImage()
                .downloadImage();
    }
}
