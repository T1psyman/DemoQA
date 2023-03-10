package exercise7.tests;

import exercise7.pages.RegistrationPage;
import exercise7.pages.components.RegistrationResultModal;
import org.junit.jupiter.api.Test;

import java.io.File;


public class StudentFormRegistrationTest extends TestBase {

    @Test
    void fillFormTest() {
        File file = new File("src/test/resources/picture/1.JPG");
        RegistrationPage registrationPage = new RegistrationPage();
        RegistrationResultModal registrationResultModal = new RegistrationResultModal();

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

        registrationResultModal.verifyRegistrationModalAppears().
                verifyModalTableItem("Student Name", "Chuck Norris").
                verifyModalTableItem("Student Email", "Bl@ha.com").
                verifyModalTableItem("Gender", "Other").
                verifyModalTableItem("Mobile", "8293492345").
                verifyModalTableItem("Date of Birth", "17 November,2000").
                verifyModalTableItem("Subjects", "Maths").
                verifyModalTableItem("Hobbies", "Reading").
                verifyModalTableItem("Picture", "1.JPG").
                verifyModalTableItem("Address", "Moskow nishebrodovo 5").
                verifyModalTableItem("State and City", "Haryana Karnal").
                closeRegistrationForm();


    }
}
