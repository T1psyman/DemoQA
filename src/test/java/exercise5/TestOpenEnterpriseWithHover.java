package exercise5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestOpenEnterpriseWithHover {

    SelenideElement columnA = $("#column-a");
    SelenideElement columnB = $("#column-b");

    @Test
    void openEnterprisesPage() {
        open("https://github.com/");


        $$(".HeaderMenu-item").findBy(text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link")
                .findBy(text("Enterprise")).click();

        $(".font-mktg").shouldHave(text("Build like the best"));
    }


    //    Не тащится прямуоугльник
    @Test
    void clickAndHoldSquare() {
        open("https://the-internet.herokuapp.com/drag_and_drop");


        actions().clickAndHold(columnA).moveToElement(columnB).perform();
        columnB.shouldHave(text("A"));
    }

    @Test
    void dragAndDropSquare() {
        open("https://the-internet.herokuapp.com/drag_and_drop");


        columnA.dragAndDropTo(columnB);
        columnB.shouldHave(text("A"));
    }
}
