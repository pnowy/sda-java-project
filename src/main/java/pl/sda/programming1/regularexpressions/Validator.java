package pl.sda.programming1.regularexpressions;

public interface Validator {

    boolean isPeselValid(String pesel);

    boolean isNipValid(String nip);

    boolean isPhoneValid(String phone);

    boolean isPostalCodeValid(String postalCode);

}
