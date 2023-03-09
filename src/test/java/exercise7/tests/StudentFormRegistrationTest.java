package exercise7.tests;

import exercise7.pages.RegistrationPage;
import exercise7.pages.RegistrationSuccessForm;
import org.junit.jupiter.api.Test;

import java.io.File;


public class StudentFormRegistrationTest extends TestBase {

    @Test
    void fillFormTest() {
        File file = new File("src/test/resources/picture/1.JPG");
        RegistrationPage registrationPage = new RegistrationPage();
        RegistrationSuccessForm registrationSuccessForm = new RegistrationSuccessForm();

        registrationPage.openPage()
                .removeBannerAndFooter()
                .setFirstName("Chuck")
                .setLastName("Norris")
                .setUserEmail("Bl@ha.com")
                .setGender("Other")
                .setMobileNumber("8293492345")
                .setBirthDay("17", "November", "2000")
                .setSubject("Maths")
                .setHobbies("Reading")
                .uploadPicture(file)
                .setAddress("Moskow nishebrodovo 5")
                .setState("Haryana")
                .setCity("Karnal")
                .pressSubmitButton();

        registrationSuccessForm.checkRegistrationResultModalAppears().
                verifyRegistrationTableItems("Student Name", "Chuck Norris").
                verifyRegistrationTableItems("Student Email", "Bl@ha.com").
                verifyRegistrationTableItems("Gender", "Other").
                verifyRegistrationTableItems("Mobile", "8293492345").
                verifyRegistrationTableItems("Date of Birth", "17 November,2000").
                verifyRegistrationTableItems("Subjects", "Maths").
                verifyRegistrationTableItems("Hobbies", "Reading").
                verifyRegistrationTableItems("Picture", "1.JPG").
                verifyRegistrationTableItems("Address", "Moskow nishebrodovo 5").
                verifyRegistrationTableItems("State and City", "Haryana Karnal").
                closeRegistrationForm();


    }
}
