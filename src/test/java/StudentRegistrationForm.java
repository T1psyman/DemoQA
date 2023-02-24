import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.files.DownloadActions.click;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() throws InterruptedException {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Chuck");
        $("#lastName").setValue("Norris");
        $("#userEmail").setValue("Bl@ha.com");

        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("8293492345");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1980")).click();
        $(".react-datepicker__month-select").$(byText("November")).click();
        $(".react-datepicker__month-select").$(byText("November")).click();
        $(".react-datepicker__day--017").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        File file = new File("/Users/egorblinov/Downloads/1.JPG");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Moskow nishebrodovo 5");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Chuck Norris"));
        $(".modal-body").shouldHave(text("Bl@ha.com"));
        $(".modal-body").shouldHave(text("Other"));
        $(".modal-body").shouldHave(text("8293492345"));
        $(".modal-body").shouldHave(text("17 November,1980"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("Moskow nishebrodovo 5"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));

        $("#closeLargeModal").click();

    }
}
