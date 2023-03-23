import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.WebDriverRunner.currentFrameUrl;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.netty.handler.codec.http.HttpHeaders.setIntHeader;



public class Google_refresh {
    @Test
    void main() {
        open("https://google.com.ua/");
        sleep(2000);
        refresh();
        url().equals(currentFrameUrl()); //"https://www.google.com.ua/"
        System.out.println(currentFrameUrl()); //url().equals("https://www.google.com.ua/")
//        webdriver().shouldHave(url("https://www.google.com.ua/"));
    }
}
