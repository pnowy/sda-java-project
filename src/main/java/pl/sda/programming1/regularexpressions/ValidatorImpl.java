package pl.sda.programming1.regularexpressions;

import java.util.regex.Pattern;

public class ValidatorImpl implements Validator {
    private static final Pattern PESEL_PATTERN = Pattern.compile("^\\d{11}$");
    private static final Pattern NIP_PATTERN = Pattern.compile("^\\d{3}-?\\d{3}-?\\d{2}-?\\d{2}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]+-?[0-9]+-?[0-9]+-?[0-9]+$");

    @Override
    public boolean isPeselValid(String pesel) {
        return PESEL_PATTERN.matcher(pesel).matches();
    }

    @Override
    public boolean isNipValid(String nip) {
        return NIP_PATTERN.matcher(nip).matches();
    }

    @Override
    public boolean isPhoneValid(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    @Override
    public boolean isPostalCodeValid(String postalCode) {
        return false;
    }
}
