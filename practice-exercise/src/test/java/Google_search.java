import com.codeborne.selenide.SelenideElement;
import data_provider.Google; ///?
import data_provider.xpathObject;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.WebDriverRunner.currentFrameUrl;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Google_search {

    private final SelenideElement
    input = $x("//input[@role='combobox']");
    private final SelenideElement
    nextPage = $x("//*[@id=\"botstuff\"]/div/div[2]/table/tbody/tr/td[3]/a");
    private final SelenideElement
    appbar = $x("//*[@id=\"result-stats\"]");


    @Test (dataProviderClass = Google.class, dataProvider = "insertValue")
    @Description("Open Google page and insert to search field value" + "Check that all links on the page contain the text \"Zoo\"")
    public void allLinksContainExpectedText (String category, String value ) { //Google, String insertValue
        open("https://google.com.ua/");
        sleep(2000);
        input.val(category).pressEnter();
        sleep(2000);
        List<String> href = $$x("//*[@id='center_col']//a[@href]/h3").texts();
        List<String> adv_href = $$x("//*[@id='tvcap']//a/*[@role='heading']").texts();
        assertThat(href, everyItem(containsStringIgnoringCase(value)));
        assertThat(adv_href, everyItem(containsString(value)));
    }

//        if (href.contains(value) && adv_href.contains(value)) {
//            System.out.println("All links contains expected text");
//        } else {
//            System.out.println("Not all of the links contains expected text");
//        }
        //checks
//        List<SelenideElement> links = $$x("//*[@id='center_col']//a[@href]/h3");
//        links.contains("Зоо");
//        System.out.println(links);
//        sleep(2000);
//
//        List<SelenideElement> adv_links = $$x("//*[@id='tvcap']//a/*[@role='heading']");
//        adv_links.contains("Зоо");
//        System.out.println(adv_links);
//        sleep(2000);

    @Test
    void refreshURL() {
        open("https://google.com.ua/");
        sleep(2000);
        refresh();
        url().equals(currentFrameUrl()); //"https://www.google.com.ua/"
    }
    @Test
    @Description("Клікнути на перше посилання, перевірити, що перше посилання https://www.zootovary.com/ (метод url())")
    void checkFirstLink () {
        open("https://google.com.ua/");
        sleep(2000);
        input.val("Зоотовари").pressEnter();
        sleep(2000);

        List <String> links = $$x("//*[@id='search']//a[@href]").texts();
        System.out.println($$x("//*[@id='search']//a[@href]"));
//            links.get(0).;
        sleep(2000);
//        assertThat(links.get(0), hasItemInArray("https://www.zootovary.com/"));
        assertThat("", "https://www.zootovary.com/", isIn(links));
//        assertThat("", url(), equalTo("https://www.zootovary.com/")); //reason error message
        url().equals("https://www.zootovary.com/");

    }

    @Test (dataProviderClass = Google.class, dataProvider = "pageResult") //, dataProvider = "pageResult"
    @Description("Open Google page and insert to search field value" + "Check that all links on the page contain the text \"Zoo\"")
    public void allLinksOn2ndPageContainExpectedText (String category, String result) {
        open("https://google.com.ua/");
        input.val(category).pressEnter();
        sleep(1000);
        nextPage.click();
        assertThat(appbar, equalTo(result));
//        result.contains("страница 2");
//        assertThat(appbar, contains("страница 2"));
//        assertThat(appbar, hasItem(containsString(result)));
    }

}
