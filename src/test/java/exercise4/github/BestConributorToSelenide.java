package exercise4.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BestConributorToSelenide {

    @Test
    void andreySolntsevTopConributor(){
        open("https://github.com/selenide/selenide");

        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();

        $(".Popover-message").shouldHave(text("Andrei Solntsev"));

        sleep(5000);
    }
}
