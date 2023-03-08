package exercise7.tests;

import org.junit.jupiter.api.Test;

import java.io.File;


public class StudentFormWithPageObjects extends TestBase {
    File file = new File("src/test/resources/picture/1.JPG");

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Chuck")
                .setLastName("Norris")
                .setEmail("Bl@ha.com")
                .setGender("Other")
                .setNumber("8293492345")
                .setBirthDay("17", "November", "2000")
                .setSubject("Maths")
                .setHobbies("Reading")
                .uploadPicture(file)
                .setAddress("Moskow nishebrodovo 5")
                .setState("Haryana")
                .setCity("Karnal")
                .pressSubmit();

        registrationPage.registrationResulModalAppear().
                registrationVerify("Student Name", "Chuck Norris").
                registrationVerify("Student Email", "Bl@ha.com").
                registrationVerify("Gender", "Other").
                registrationVerify("Mobile", "8293492345").
                registrationVerify("Date of Birth", "17 November,2000").
                registrationVerify("Subjects", "Maths").
                registrationVerify("Hobbies", "Reading").
                registrationVerify("Picture", "1.JPG").
                registrationVerify("Address", "Moskow nishebrodovo 5").
                registrationVerify("State and City", "Haryana Karnal").
                closeRegistrationFrom().
                verifyOpenBasePage();


    }
}
