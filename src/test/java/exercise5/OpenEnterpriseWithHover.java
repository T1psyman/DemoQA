package exercise5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class OpenEnterpriseWithHover {

    @Test
    void openedEnterprisesPage(){
        open("https://github.com/");
        $(".Header-old").$$("ul li").get(14).hover();
        $(".Header-old").$$("ul li").get(16).click();
        $(".font-mktg").shouldHave(Condition.text("Build like the best"));
        sleep(5000);
    }
}
