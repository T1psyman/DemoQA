package exercise8.tests;

import exercise8.pages.RegistrationPage;
import exercise8.pages.components.RegistrationResultModal;
import org.junit.jupiter.api.Test;

import java.io.File;

import static exercise8.tests.testsData.FakerTestData.*;


public class StudentFormRegistrationTest extends TestBase {

    @Test
    void fillFormTest() {
        String fileName = "1.JPG";
        File file = new File("src/test/resources/picture/" + fileName);
        RegistrationPage registrationPage = new RegistrationPage();
        RegistrationResultModal registrationResultModal = new RegistrationResultModal();


        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName(userFirstName)
                .setLastName(userSecondName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setMobileNumber(userMobileNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbies(hobbies)
                .uploadPicture(file)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .pressSubmitButton();

        registrationResultModal.verifyRegistrationModalAppears().
                verifyModalTableItem("Student Name", userFirstName + " " + userSecondName).
                verifyModalTableItem("Student Email", userEmail).
                verifyModalTableItem("Gender", userGender).
                verifyModalTableItem("Mobile", userMobileNumber).
                verifyModalTableItem("Date of Birth", dayOfBirth).
                verifyModalTableItem("Subjects", subject).
                verifyModalTableItem("Hobbies", hobbies).
                verifyModalTableItem("Picture", fileName).
                verifyModalTableItem("Address", currentAddress).
                verifyModalTableItem("State and City", state + " " + city).
                closeRegistrationForm();


    }
}
