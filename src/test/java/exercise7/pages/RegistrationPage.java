package exercise7.pages;

import com.codeborne.selenide.SelenideElement;
import exercise7.pages.components.CalendarComponent;
import exercise7.pages.components.RegistrationResulModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResulModal registrationResulModal = new RegistrationResulModal();

    private SelenideElement
            setFirstName = $("#firstName"),
            setLastName = $("#lastName"),
            setEmail = $("#userEmail"),
            setGender = $("#genterWrapper"),
            setNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            openBasePage = $(".practice-form-wrapper"),
            setSubject = $("#subjectsInput"),
            setHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            setAddress = $("#currentAddress"),
            setState = $("#state"),
            setCity = $("#city"),
            stateCityInput = $("#stateCity-wrapper"),
            pressSubmit = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        verifyOpenBasePage();
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        setFirstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        setLastName.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        setEmail.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        setGender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        setNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage registrationResulModalAppear() {
        registrationResulModal.verifyRegistrationModel();

        return this;
    }

    public RegistrationPage registrationVerify(String key, String value) {
        registrationResulModal.verifyRegistration(key, value);

        return this;
    }

    public RegistrationPage closeRegistrationFrom() {
        registrationResulModal.closeRegistrationFrom();

        return this;
    }

    public RegistrationPage verifyOpenBasePage() {
        openBasePage.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage setSubject(String value) {
        setSubject.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        setHobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(File file) {
        uploadPicture.uploadFile(file);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        setAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        setState.click();
        stateCityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        setCity.click();
        stateCityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage pressSubmit() {
        pressSubmit.click();

        return this;
    }


}
