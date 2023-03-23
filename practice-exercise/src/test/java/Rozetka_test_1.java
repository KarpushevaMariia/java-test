import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class Rozetka_test_1 {
    @Test
void main() {
            open("https://rozetka.com.ua/");
            sleep(1000);
            $x("(.//button)[@id='fat-menu']").click();
            sleep(1000);

            List<SelenideElement> links = $$x(".//div[2]/ul/li[@class='menu-categories__item ng-star-inserted']/a");
            for (SelenideElement category : links) {

                if (category.innerText().contains("Зоотовари")) { // (category.innerText().equals("Зоотовари"))
                    System.out.println(category);
                    System.out.println(links);
                    category.click();
                    sleep(4000);
                }
            }
        }
    }