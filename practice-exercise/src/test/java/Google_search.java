import com.codeborne.selenide.SelenideElement;
import data_provider.Google; ///?
import data_provider.xpathObject;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Google_search {

//    private Google Google;
//    public Google GooglePage;
//    @DataProvider
//    Object [][] insertValue(){
//        return new Object[][]{
//                {"Зоотовари"},
//                {"Косметика"},
//                {"Аптека"}
//        };
//    }


    @Test (dataProviderClass = Google.class, dataProvider = "insertValue")
//    @Test (dataProvider = "insertValue")
    @Description("Open Google page and insert to search field value" +
            "Check that all links on the page contain the text \"Zoo\"")
    public void main(String category, String value ) { //Google, String insertValue
        open("https://google.com.ua/");
        sleep(2000);
        $x(".//input[@role='combobox']").val(category).pressEnter();
//        $x(".//input[@role='combobox']").val("Зоотовари").pressEnter();

        sleep(2000);
        List <String> href = $$x("//*[@id='center_col']//a[@href]/h3").texts();
        List <String> adv_href = $$x("//*[@id='tvcap']//a/*[@role='heading']").texts();
        assertThat(href, everyItem(containsStringIgnoringCase(value)));
        assertThat(adv_href, everyItem(containsString(value)));


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

    }
}
