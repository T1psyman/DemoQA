package exercise7.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {
    public RegistrationResultModal verifyRegistrationModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationResultModal verifyModalTableItem(String key, String value) {
        $(".modal-body").$(byText(key)).
                parent().shouldHave(text(value));

        return this;
    }

    public RegistrationResultModal closeRegistrationForm() {
        $("#closeLargeModal").click();

        return this;
    }

}
