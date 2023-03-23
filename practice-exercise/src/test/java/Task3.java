import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Task3 {
    @Test
     void main() {
        open("https://google.com.ua/");
        sleep(2000);
        $x(".//input[@role='combobox']").val("Зоотовари").pressEnter();
        sleep(2000);

        List <String> links = $$x("//*[@id='search']//a[@href]").texts();
        System.out.println($$x("//*[@id='search']//a[@href]"));
//            links.get(0).click();
            sleep(2000);
//            assertThat(links.get(0), hasItemInArray("https://www.zootovary.com/"));
            assertThat("", "https://www.zootovary.com/", isIn(links));
//            assertThat("", url(), equalTo("https://www.zootovary.com/")); //reason error message
//            url().equals("https://www.zootovary.com/");
//            System.out.println(url().equals("https://www.zootovary.com/"));
//            System.out.println(links.get(0));

    }
}