package pl.wlazrad.demo.security.request;

import java.text.ParseException;
import java.time.LocalDate;
//
//public class DateOfBirthValidator implements ConstraintValidator<ValidDateOfBirth, Integer> {
//
//    @Override
//    public void initialize(ValidDateOfBirth constraintAnnotation) {
//    }
//    @Override
//    public boolean isValid(Integer pesel, ConstraintValidatorContext constraintContext) {
//
//        if (pesel == null)
//            return false;
//
//        if (pesel.toString().substring(0,5))
//
//            pesel.toString().substring(0,5)
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd");
//        Date parseDate = sdf1.parse()
//    Date date = new Date();
//        date.
//    return object.equals(object.toUpperCase());
//        else
//            return object.equals(object.toLowerCase());
//    }
//}

class Main {
    public static void main(String[] args) throws ParseException {
       long pesel = 93102212910l;
        System.out.println(daty(pesel));
    }
    static boolean daty( long pesel) throws ParseException {

        String s = String.valueOf(pesel);
        int month = Integer.parseInt(s.substring(2,4));
        int year = Integer.parseInt(s.substring(0,2));
        int day = Integer.parseInt(s.substring(4,6));
        LocalDate resultDate = null;

        if(month>=20 & month<=32){
            month = month - 20;
            year = year + 2000;
            LocalDate localDate = LocalDate.of(year,month,day);
            System.out.println(localDate);
            resultDate =localDate;
        }

        if(month>=80 & month<=92){
            month = month - 80;
            year = year + 1800;
            LocalDate localDate = LocalDate.of(year,month,day);
            System.out.println(localDate);
            resultDate =localDate;

        }

        if (month>=0 & month<=12){
            year = year + 1900;
            LocalDate localDate = LocalDate.of(year,month,day);
            System.out.println(localDate);
            resultDate =localDate;

        }
        return LocalDate.now().minusYears(18).isAfter(resultDate);
    }
}
