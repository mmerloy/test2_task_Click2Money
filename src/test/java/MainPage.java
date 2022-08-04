import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница(поисковая система google)
 */
public class MainPage
{
    //поле для ввода поискового запроса
    private final SelenideElement textBoxInput = $x("//input[@type='text']");

    public MainPage(String url){
        Selenide.open(url);
    }

    /**
     * Выполняется поиск в поисковой системе необходимой картинки и нажимается кнопка Enter
     * @param searchString поисковая строка
     */
    protected SearchPage search(String searchString)
    {
        textBoxInput.setValue(searchString);
        textBoxInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }
}
