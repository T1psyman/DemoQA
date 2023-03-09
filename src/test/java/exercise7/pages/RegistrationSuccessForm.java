package exercise7.pages;

import exercise7.pages.components.RegistrationResultModal;

public class RegistrationSuccessForm {
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();


    public RegistrationSuccessForm checkRegistrationResultModalAppears() {
        registrationResultModal.verifyRegistrationModalAppears();

        return this;
    }

    public RegistrationSuccessForm verifyRegistrationTableItems(String key, String value) {
        registrationResultModal.verifyModalTableItem(key, value);

        return this;
    }

    public RegistrationSuccessForm closeRegistrationForm() {
        registrationResultModal.closeRegistrationForm();

        return this;
    }

}
