package utilities.common;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
public class Generator {
    // this class include some fake data

    public static String currentTime = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(Calendar.getInstance().getTime());
    public static String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());

    public static int convertStringVNDToInt(String moneyVND) {
        moneyVND = moneyVND.replaceAll("\\D+", "");
        if (moneyVND.equals(""))
            moneyVND = "0";
        return Integer.parseInt(moneyVND);
    }

    public static String convertDoubleToVND(double money) {
        NumberFormat num = NumberFormat.getNumberInstance();
        String moneyString = num.format(money) + " đ";
        return moneyString;
    }

    public static int convertStringToInt(String s) {
        if (s.equals(""))
            s = "0";
        return Integer.parseInt(s);
    }

    public static String fakerPhoneNum() {
        Random random = new Random();

        String phoneNumber = "";
        String[] viettel = {"86", "96", "97", "98", "32", "33", "34", "35", "36", "37", "38", "39"};
        String[] vina = {"88", "81", "82", "83", "84", "85", "91", "94"};
        String[] mobi = {"89", "90", "93", "70", "76", "77", "78", "79"};
        String[] vinamobile = {"92", "56", "58"};
        String[] gmobile = {"99", "59"};
        String[] itelecom = {"87"};

        String[] phoneFormat = {"+84", "0"};

        phoneNumber += phoneFormat[random.nextInt(phoneFormat.length)];
//        System.out.println("phoneNumber 1: " + phoneNumber);

        String[] allNet = ArrayUtils.addAll(viettel, vina);
        allNet = ArrayUtils.addAll(allNet, mobi);
        allNet = ArrayUtils.addAll(allNet, vinamobile);
        allNet = ArrayUtils.addAll(allNet, gmobile);
        allNet = ArrayUtils.addAll(allNet, itelecom);
//        System.out.println("allNet: " + allNet);

        phoneNumber += allNet[random.nextInt(allNet.length)];
//        System.out.println("phoneNumber 2: " + phoneNumber);

        for (int i = 0; i < 7; i++) {
            phoneNumber += random.nextInt(10);
        }

//        System.out.println("phoneNumber 3: " + phoneNumber);

        return phoneNumber;
    }

    public static String fakerFirstName() {
        Faker faker = new Faker(new Locale("vi")); //new Locale("vi")
        String firstName = faker.name().firstName();
        return firstName;
    }

    public static String fakerLastName() {
        Faker faker = new Faker(new Locale("vi")); //new Locale("vi")
        String lastName = faker.name().lastName();
        return lastName;
    }

    public static String getRandomMailinator() {
        RandomStringUtils randomString = new RandomStringUtils();
        String email = randomString.randomAlphabetic(10) + "@finanteam.testinator.com";
        return email;
    }
}
