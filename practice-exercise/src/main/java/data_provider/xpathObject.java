package data_provider;
import com.codeborne.selenide.SelenideElement;
//import lombok.Getter;
import static com.codeborne.selenide.Selenide.*;


public class xpathObject {
    private final SelenideElement
            clickInputField = $x(".//input[@role='combobox']");
}
