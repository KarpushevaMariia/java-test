package data_provider;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.$x;

public class Google {
//    String Google = "https://google.com.ua/";
//    private static final insertValue
//            ЗООТОВАРИ = new insertValue(),
//            КОСМЕТИКА = new insertValue(),
//            АПТЕКА = new insertValue();



    @DataProvider
    Object [][] insertValue(){
        return new Object[][]{
                {"Зоотовари", "Зоо"},
                {"Косметика", "Косметика"},
                {"Аптека", "Аптека"}
        };
    }

//    @Getter
//    private final String
//            pageUrl = "https://google.com.ua/";
//
//    public Google(){
//        super.pageUrl = this.pageUrl;
//    }

    private final SelenideElement
            clickInputField = $x(".//input[@role='combobox']");


//    @BeforeClass
//    void init() { Google = new Google(); }

}
