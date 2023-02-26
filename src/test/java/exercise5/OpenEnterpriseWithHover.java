package exercise5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class OpenEnterpriseWithHover {

    SelenideElement sqA = $("#column-a");
    SelenideElement sqB = $("#column-b");

    @Test
    void openedEnterprisesPage() {
        open("https://github.com/");
        $(".Header-old").$$("ul li").get(14).hover();
        $(".Header-old").$$("ul li").get(16).click();
        $(".font-mktg").shouldHave(Condition.text("Build like the best"));
    }


    //    Не тащится прямуоугльник
    @Test
    void clickAndHoldSquare() {
        open("https://the-internet.herokuapp.com/drag_and_drop");


        actions().clickAndHold(sqA).moveToElement(sqB).perform();

    }

    @Test
    void dragAndDropSquare() {
        open("https://the-internet.herokuapp.com/drag_and_drop");


        sqA.dragAndDropTo(sqB);
        sqB.shouldHave(Condition.text("A"));
    }
}
