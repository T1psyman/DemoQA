package exercise4.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideReposirorySearch {

    @Test
    void souldSelenideRepoMastBeTop() {
        open("https://github.com");
        $("[placeholder='Search GitHub']").setValue("Selenide").pressEnter();

        $$("ul.repo-list li").first().$("a").click();

        $("#repository-container-header").shouldHave(text("selenide / selenide"));


    }

}
