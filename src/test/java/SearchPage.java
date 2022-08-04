import com.codeborne.selenide.SelenideElement;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.protocol.BasicHttpContext;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

/**
* Страница с результатами поиска
* */
public class SearchPage {
    private final SelenideElement imagesTab = $x("//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a");
    //нахождение 3 картинки по умолчанию
    //private final SelenideElement imageNum = $x("//*[@id=\"islrg\"]/div[1]/div[3]/a[1]");
    private final SelenideElement thirdImage = $x("//*[@id=\"islrg\"]/div[1]/div[3]/a[1]");
    private final SelenideElement myImage = $x("//*[@id=\"Sva75c\"]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div[3]/div/a/img");
    private final String filePath = new File(".").getAbsolutePath() + "\\src\\result-image";

    /**
     * Метод открывает вкладку с картинками
     */
    public SearchPage openImagesTab()
    {
        imagesTab.click();
        return this;
    }

    /**
     * Метод для замены номера картинки для скачивания
     * @return новый XPath для нахождения картинки
     */
    public String changeCharInPosition(int position, char ch, String str)
    {
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }

//    public void chooseImage()
//    {
//        String str = String.valueOf(imageNum);
//        str = changeCharInPosition();
//    }

    /**
     * Комментарий на будущее: создать метод, который создает нужный XPath для выбора различного номера картинки
     * clickThirdImage() открывает 3-ю картинку
     */
    public SearchPage clickThirdImage()
    {
        thirdImage.click();
        try {
            Thread.sleep(1000);//задержка для прогрузки картинки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * получение ссылки картинки для скачивания
     */
    private String getImageHref()
    {
        return myImage.getAttribute("src");
    }

    /**
     * Загрузка картинки в локальный репозиторий
     */
    public void downloadImage() throws IOException {
        //Download file using default org.apache.http client
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String href = getImageHref();
        HttpGet httpGet = new HttpGet(href);
        CloseableHttpResponse response = httpClient.execute(httpGet, new BasicHttpContext());

        //Save file on disk
        String fullFileName = filePath + href.substring(href.lastIndexOf("."));
        copyInputStreamToFile(response.getEntity().getContent(), new File(fullFileName));
    }
}