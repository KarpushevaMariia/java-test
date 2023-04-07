package data_provider;

import lombok.Getter;
import org.testng.annotations.DataProvider;

public class Google {

    @DataProvider
    Object [][] insertValue(){
        return new Object[][]{
                {"Зоотовари", "Зоо"},
                {"Косметика", "Косметика"},
                {"Аптека", "Аптека"}
        };
    }

    @DataProvider
    Object [][] pageResult(){
        return new Object[][]{
                {"Зоотовари", "страница 2"},
                {"Косметика", "страница 2"},
                {"Аптека", "страница 2"}
        };
    }

    @Getter
    private final String
            pageUrl = "https://google.com.ua/";
}
