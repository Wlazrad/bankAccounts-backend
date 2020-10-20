package pl.wlazrad.demo.security.request;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateOfBirthValidator implements ConstraintValidator<ValidDateOfBirth, String> {

    byte[] PESEL = new byte[11];

    @Override
    public void initialize(ValidDateOfBirth constraintAnnotation) {
    }

    @Override
    public boolean isValid(String pesel, ConstraintValidatorContext constraintContext) {
        return checkingTheLegalAge(pesel);
    }

     boolean checkingTheLegalAge(String PESELNumber) {

         for (int i = 0; i < 11; i++){
             PESEL[i] = Byte.parseByte(PESELNumber.substring(i, i+1));
         }
         LocalDate resultDate = null;

         resultDate = LocalDate.of(getBirthYear(),getBirthMonth(), getBirthDay());

        return LocalDate.now().minusYears(18).isAfter(resultDate);
    }

    public int getBirthYear() {
        int year;
        int month;
        year = 10 * PESEL[0];
        year += PESEL[1];
        month = 10 * PESEL[2];
        month += PESEL[3];
        if (month > 80 && month < 93) {
            year += 1800;
        }
        else if (month > 0 && month < 13) {
            year += 1900;
        }
        else if (month > 20 && month < 33) {
            year += 2000;
        }
        else if (month > 40 && month < 53) {
            year += 2100;
        }
        else if (month > 60 && month < 73) {
            year += 2200;
        }
        return year;
    }

    public int getBirthMonth() {
        int month;
        month = 10 * PESEL[2];
        month += PESEL[3];
        if (month > 80 && month < 93) {
            month -= 80;
        }
        else if (month > 20 && month < 33) {
            month -= 20;
        }
        else if (month > 40 && month < 53) {
            month -= 40;
        }
        else if (month > 60 && month < 73) {
            month -= 60;
        }
        return month;
    }

    public int getBirthDay() {
        int day;
        day = 10 * PESEL[4];
        day += PESEL[5];
        return day;
    }
}
