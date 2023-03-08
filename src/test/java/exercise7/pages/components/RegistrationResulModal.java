package exercise7.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResulModal {
    public void verifyRegistrationModel() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void verifyRegistration(String key, String value) {
        $(".modal-body").$(byText(key)).
                parent().shouldHave(text(value));
    }

    public void closeRegistrationFrom() {
        $("#closeLargeModal").click();
    }

}
