package exercise8.pages;

import com.codeborne.selenide.SelenideElement;
import exercise8.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();


    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobileNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subject = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            cityInput = $("#stateCity-wrapper"),
            submitButton = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setMobileNumber(String value) {
        mobileNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }


    public RegistrationPage setSubject(String value) {
        subject.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(File file) {
        picture.uploadFile(file);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        address.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage pressSubmitButton() {
        submitButton.click();

        return this;
    }


}
