package enums;
import lombok.Getter;

@Getter
public enum Site {
    GOOGLE("google.com.ua"),
    ROZETKA("rozetka.com.ua");

    private final String site;

    Site(String site) {
        this.site = site;
    }

}
