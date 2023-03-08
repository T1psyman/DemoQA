package exercise4.homework;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionExampleJunit5 {

    @Test
    void shouldBeAsExampleJunit5() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();

        SelenideElement show2mo = $("div.js-wiki-sidebar-toggle-display").
                $$("ul li").last().
                $(byText("Show 2 more pages…"));

        boolean softAssertableButton = $("div.js-wiki-sidebar-toggle-display").
                $$("ul li").equals(text("SoftAssertions"));

        if (!softAssertableButton) {
            show2mo.click();
        }

        $("div.js-wiki-sidebar-toggle-display").
                $$("ul li").get(19).shouldHave(text("SoftAssertions"))
                .$("a").click();

        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
        $("#wiki-body").shouldHave(text("@ExtendWith"));
        $("#wiki-body").shouldHave(text("@RegisterExtension"));
        $("#wiki-body").shouldHave(text("com.codeborne:selenide"));

    }
}
