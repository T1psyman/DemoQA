package exercise8.tests.testsData;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class FakerTestData {
    public static Faker ruFaker = new Faker(new Locale("ru_RU"));
    public static Faker faker = new Faker();

    public static String userGender = faker.options().option("Male", "Female", "Other");
    public static String subject = faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
            "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology");
    public static String hobbies = faker.options().option("Reading", "Sports", "Music");

    public static String userFirstName = ruFaker.name().firstName();
    public static String userSecondName = ruFaker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String userMobileNumber = 8 + faker.phoneNumber().subscriberNumber(9);
    public static String currentAddress = ruFaker.address().fullAddress();

    static Date fakerDateOfBirthday = faker.date().birthday();
    public static String dayOfBirth = (new SimpleDateFormat("dd", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public static String monthOfBirth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(fakerDateOfBirthday);
    public static String yearOfBirth = (new SimpleDateFormat("yyyy", Locale.ENGLISH)).format(fakerDateOfBirthday);

    static Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    public static String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    public static String city = faker.options().option(mapStateWithCity.get(state));
}
